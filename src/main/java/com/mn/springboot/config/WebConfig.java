package com.mn.springboot.config;

import com.mn.springboot.filter.MyFileter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Autowired
    private MyFileter myFileter;

    @Bean
    public FilterRegistrationBean init(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(myFileter);
        registrationBean.setName("myFilter");
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
