package com.example.takoapp.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //принимает регистр для регистрации какой либо странички html veiw
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login");
    }
}
