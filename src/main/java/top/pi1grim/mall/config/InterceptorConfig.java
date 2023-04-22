package top.pi1grim.mall.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.pi1grim.mall.core.interceptor.ExpireReset;
import top.pi1grim.mall.core.interceptor.TokenCheck;

import java.util.List;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public ExpireReset expireReset() {
        return new ExpireReset();
    }

    @Bean
    public TokenCheck tokenCheck() {
        return new TokenCheck();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        String[] includePath = new String[]{
                "**/umsMember/**",
        };

        String[] excludePath = new String[]{
                "**/umsMember/login",
                "**/umsMember/register",
        };

        registry.addInterceptor(expireReset()).addPathPatterns("/**");
        registry.addInterceptor(tokenCheck()).addPathPatterns(includePath).excludePathPatterns(excludePath);
    }
}
