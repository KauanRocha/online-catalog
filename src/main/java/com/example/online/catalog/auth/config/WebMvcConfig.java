package com.example.online.catalog.auth.config;

import com.example.online.catalog.auth.adapters.inbound.resolvers.CompanyIdArgumentResolver;
import com.example.online.catalog.auth.adapters.inbound.resolvers.UserIdArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new CompanyIdArgumentResolver());
        resolvers.add(new UserIdArgumentResolver());
    }
}