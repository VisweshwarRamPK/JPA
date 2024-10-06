package com.example.employee.config;

import com.example.employee.filter.CustomFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<CustomFilter> loggingFilter() {
        FilterRegistrationBean<CustomFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new CustomFilter());
        registrationBean.addUrlPatterns("/employees/*");

        return registrationBean;
    }
}
