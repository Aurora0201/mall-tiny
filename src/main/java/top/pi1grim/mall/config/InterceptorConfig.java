package top.pi1grim.mall.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.pi1grim.mall.core.interceptor.ExpireReset;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public ExpireReset expireReset() {
        return new ExpireReset();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(expireReset()).addPathPatterns("/**");
    }
}
