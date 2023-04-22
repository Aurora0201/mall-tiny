package top.pi1grim.mall.core.interceptor;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import top.pi1grim.mall.core.constant.RedisConstant;
import top.pi1grim.mall.core.constant.StringConstant;

import java.util.concurrent.TimeUnit;

public class ExpireReset implements HandlerInterceptor {

    @Resource
    private StringRedisTemplate template;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        if(StringConstant.OPTIONS.equals(method))return true;

        String token = request.getHeader(StringConstant.TOKEN);
        if (StringUtils.isNotEmpty(token)) {
            String json = template.boundValueOps(token).get();
            if (StringUtils.isNotEmpty(json)) {
                template.boundValueOps(token).expire(RedisConstant.TOKEN_EXPIRE_TIME, TimeUnit.SECONDS);
            }
        }
        return true;
    }
}
