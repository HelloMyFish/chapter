package com.dudu.demo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/2421:15
 */
@Component
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/demo/**").excludePathPatterns("/test/**");
        super.addInterceptors(registry);
    }
}
