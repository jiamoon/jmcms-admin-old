package com.jiamoon.jmcms.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class IntercepterConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(getParameterInterceptor()).addPathPatterns("/admin/dict/**");
        super.addInterceptors(registry);
    }

    @Bean
    public HandlerInterceptor getParameterInterceptor() {
        return new ParameterInterceptor();
    }
}
