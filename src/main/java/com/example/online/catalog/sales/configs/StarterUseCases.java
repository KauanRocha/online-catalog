package com.example.online.catalog.sales.configs;


import com.example.online.catalog.sales.application.core.usecase.CatalogUseCase;
import com.example.online.catalog.sales.application.port.out.CompanyPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StarterUseCases {

    @Bean
    public CatalogUseCase catalogUseCase(CompanyPort companyPort) {
        return new CatalogUseCase(companyPort);
    }
}
