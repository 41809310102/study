package com.example.myblog.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration

public class WebConfig  implements WebMvcConfigurer { //拦截器
  /* @Override
    public void addInterceptors(InterceptorRegistry registry) {
     registry.addInterceptor(new Loginterceptor())
             .addPathPatterns("/admin/**")
             .addPathPatterns("/admin/login");
    }*/
}
