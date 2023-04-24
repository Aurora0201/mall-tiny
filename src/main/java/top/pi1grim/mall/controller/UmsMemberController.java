package top.pi1grim.mall.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import top.pi1grim.mall.common.utils.EntityUtils;
import top.pi1grim.mall.common.utils.JWTUtils;
import top.pi1grim.mall.core.constant.RedisConstant;
import top.pi1grim.mall.core.constant.StringConstant;
import top.pi1grim.mall.dto.LoginDTO;
import top.pi1grim.mall.dto.MemberInfoDTO;
import top.pi1grim.mall.dto.PasswordDTO;
import top.pi1grim.mall.dto.RegisterDTO;
import top.pi1grim.mall.entity.UmsMember;
import top.pi1grim.mall.exception.MemberException;
import top.pi1grim.mall.common.response.Response;
import top.pi1grim.mall.service.UmsMemberService;
import top.pi1grim.mall.type.ErrorCode;
import top.pi1grim.mall.type.ResponseCode;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-21
 */
@RestController
@RequestMapping("/api/v1/umsMember")
@CrossOrigin
@Slf4j
@Tag(name = "用户业务API，负责注册，登录，个人信息修改等多种职责")
public class UmsMemberController {

    @Resource
    private UmsMemberService memberService;

    @Resource
    private StringRedisTemplate template;

    @Resource
    private RedissonClient client;

    private UmsMember getMember(HttpServletRequest request) {
        String token = request.getHeader(StringConstant.TOKEN);
        String json = template.boundValueOps(token).get();
        return JSON.parseObject(json, UmsMember.class);
    }

    @PostMapping("/register")
    @Operation(summary = "注册API", description = "使用POST请求，成功则返回用户名，成功代码2005")
    public Response register(@RequestBody RegisterDTO registerDTO) {
        //验证是否存在空字段
        if(EntityUtils.fieldIsNull(registerDTO)){
            throw new MemberException(ErrorCode.ILLEGAL_REQUEST, registerDTO);
        }
        //对用户名上锁
        RLock rLock = client.getLock(registerDTO.getUsername());

        try{
            UmsMember member;
            if (rLock.tryLock(RedisConstant.TRY_LOCK_TIME, RedisConstant.LOCK_TIME, TimeUnit.SECONDS)) {
                //验证用户名是否已经注册
                member = memberService.getOne(new LambdaQueryWrapper<UmsMember>().eq(UmsMember::getUsername, registerDTO.getUsername()));
                if(Objects.nonNull(member)){
                    throw new MemberException(ErrorCode.USERNAME_EXIST, member.getUsername());
                }
                //插入数据库
                member = new UmsMember().setCreatedTime(LocalDateTime.now());
                EntityUtils.assign(member, registerDTO);

                if (Objects.nonNull(member)){
                    memberService.save(member);
                }
                log.info("注册成功 ====> " + member);
            }
        }catch (InterruptedException e){
            log.error("注册时异常", e);
            Thread.currentThread().interrupt();
        }finally {
            rLock.unlock();
        }

        return Response.success(ResponseCode.REGISTER_SUCCESS, registerDTO.getUsername());
    }

    @PostMapping("/login")
    @Operation(summary = "登录API", description = "使用POST请求，成功则返回用户名，成功代码2010")
    public Response login(@RequestBody LoginDTO loginDTO) {
        if(EntityUtils.fieldIsNull(loginDTO)){
            throw new MemberException(ErrorCode.ILLEGAL_REQUEST, loginDTO);
        }

        UmsMember member = memberService.getOne(new LambdaQueryWrapper<UmsMember>().eq(UmsMember::getUsername, loginDTO.getUsername()));
        if(Objects.isNull(member)){
            throw new MemberException(ErrorCode.MEMBER_NOT_EXIST, loginDTO);
        }

        //验证账户是否处于启用
        if (member.getStatus() == 0){
            throw new MemberException(ErrorCode.MEMBER_NOT_AVAILABLE, loginDTO);
        }

        if (!loginDTO.getPassword().equals(member.getPassword())) {
            throw new MemberException(ErrorCode.USERNAME_PASSWORD_MISMATCH, loginDTO);
        }

        //先生成Token
        String token = JWTUtils.genToken(loginDTO.getUsername());
        JSONObject session = new JSONObject();
        session.put("member", member);
        session.put("login_time", Instant.now());
        //放入Redis中，设置存活时间
        template.boundValueOps(token).set(JSON.toJSONString(session), RedisConstant.TOKEN_EXPIRE_TIME, TimeUnit.SECONDS);
        log.info("登录成功 ====> " + member);
        return Response.success(ResponseCode.LOGIN_SUCCESS, token);
    }

    @GetMapping("/info")
    @Operation(summary = "获取用户信息API", description = "使用GET请求，在Header中携带token，成功则返回当前用户信息，成功代码2015")
    public Response info(HttpServletRequest request) {
        UmsMember member = getMember(request);
        MemberInfoDTO dto = MemberInfoDTO.builder().build();
        EntityUtils.assign(dto, member);
        log.info("返回当前用户信息");
        return Response.success(ResponseCode.RETURN_INFO_SUCCESS, dto);
    }

    @PostMapping("/info")
    @Operation(summary = "修改用户信息API", description = "使用POST请求，在Header中携带token，成功则返回更新后用户信息，成功代码2020")
    public Response updateInfo(@RequestBody MemberInfoDTO dto, HttpServletRequest request) {
        UmsMember member = getMember(request);
        String token = request.getHeader(StringConstant.TOKEN);
        EntityUtils.assign(member, dto);
        //更新数据库
        memberService.updateById(member);
        //更新Redis
        template.boundValueOps(token).set(JSON.toJSONString(member));
        //返回新的用户信息
        log.info("用户信息更新成功");
        return Response.success(ResponseCode.UPDATE_INFO_SUCCESS, dto);
    }

    @PostMapping("/password")
    @Operation(summary = "修改用户密码API", description = "使用POST请求，在Header中携带token，成功则返回用户名，成功代码2025")
    public Response updatePassword(@RequestBody PasswordDTO dto, HttpServletRequest request) {
        UmsMember member = getMember(request);
        String token = request.getHeader(StringConstant.TOKEN);

        if(EntityUtils.fieldIsNull(dto)){
            throw new MemberException(ErrorCode.ILLEGAL_REQUEST, dto);
        }
        //判断旧密码是否正确
        if(!member.getPassword().equals(dto.getOldPassword())){
            throw new MemberException(ErrorCode.OLD_PASSWORD_MISMATCH, dto);
        }

        member.setPassword(dto.getNewPassword());
        memberService.updateById(member);
        template.boundValueOps(token).set(JSON.toJSONString(member));
        log.info("更新用户密码 ====> " + member);
        return Response.success(ResponseCode.UPDATE_PASSWORD_SUCCESS, member.getUsername());
    }
}
