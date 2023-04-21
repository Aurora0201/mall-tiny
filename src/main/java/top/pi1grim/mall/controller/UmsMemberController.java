package top.pi1grim.mall.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import top.pi1grim.mall.common.utils.EntityUtils;
import top.pi1grim.mall.common.utils.JWTUtils;
import top.pi1grim.mall.core.constant.RedisConstant;
import top.pi1grim.mall.dto.LoginDTO;
import top.pi1grim.mall.dto.RegisterDTO;
import top.pi1grim.mall.entity.UmsMember;
import top.pi1grim.mall.exception.MemberException;
import top.pi1grim.mall.common.response.Response;
import top.pi1grim.mall.service.UmsMemberService;
import top.pi1grim.mall.type.ErrorCode;
import top.pi1grim.mall.type.ResponseCode;

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

    @PostMapping("/register")
    @Operation(summary = "注册API", description = "使用POST请求，成功则返回用户名，成功代码2005")
    public Response register(@RequestBody RegisterDTO registerDTO) {
        //验证是否存在空字段
        if(EntityUtils.fieldIsNull(registerDTO)){
            throw new MemberException(ErrorCode.ILLEGAL_REQUEST, registerDTO);
        }

        //验证用户名是否已经注册
        UmsMember member = memberService.getOne(new LambdaQueryWrapper<UmsMember>().eq(UmsMember::getUsername, registerDTO.getUsername()));
        if(Objects.nonNull(member)){
            throw new MemberException(ErrorCode.USERNAME_EXIST, member.getUsername());
        }

        //插入数据库
        member = new UmsMember()
                .setUsername(registerDTO.getUsername())
                .setPhone(registerDTO.getPhone())
                .setGender(registerDTO.getGender())
                .setPassword(registerDTO.getPassword())
                .setCreatedTime(LocalDateTime.now());
        if (Objects.nonNull(member)){
            memberService.save(member);
        }
        log.info("注册成功 ====> " + member);
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
        //放入Redis中，设置存活时间
        template.boundValueOps(token).set(JSON.toJSONString(member), RedisConstant.TOKEN_EXPIRE_TIME, TimeUnit.SECONDS);
        log.info("登录成功 ====> " + member);
        return Response.success(ResponseCode.LOGIN_SUCCESS, token);
    }
}
