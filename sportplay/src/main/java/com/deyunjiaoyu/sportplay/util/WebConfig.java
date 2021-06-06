package com.deyunjiaoyu.sportplay.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//配置跨域请求
/*
1.欲跨域的路劲
2.请求来源
3.请求方法
4.允许携带
5.最大时间
*/
@Configuration
public class WebConfig  extends WebMvcConfigurerAdapter {
    @Override
    public  void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("Http://localhost:8080","null")
                .allowedMethods("GET","POST","PUT","OPTIONS","DELETE","HEAD")//请求方法
                .allowCredentials(true)
                .maxAge(3600);

    }
}
