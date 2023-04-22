package top.pi1grim.mall.core.interceptor;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import top.pi1grim.mall.core.constant.StringConstant;
import top.pi1grim.mall.exception.TokenException;
import top.pi1grim.mall.type.ErrorCode;

public class TokenCheck implements HandlerInterceptor {

    @Resource
    private StringRedisTemplate template;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        if(StringConstant.OPTIONS.equals(method))return true;

        //检查token是否合法
        String token = request.getHeader(StringConstant.TOKEN);
        if(StringUtils.isEmpty(token)){
            throw new TokenException(ErrorCode.NO_TOKEN_CARRIED, null);
        }

        String json = template.boundValueOps(token).get();
        if (StringUtils.isEmpty(json)) {
            throw new TokenException(ErrorCode.TOKEN_EXPIRATION, null);
        }

        return true;
    }
}
