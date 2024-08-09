package com.example.online.catalog.sales.configs;


import com.example.online.catalog.sales.application.core.usecase.CartUseCase;
import com.example.online.catalog.sales.application.core.usecase.CatalogUseCase;
import com.example.online.catalog.sales.application.port.out.CartPort;
import com.example.online.catalog.sales.application.port.out.CatalogPort;
import com.example.online.catalog.sales.application.port.out.CompanyPort;
import com.example.online.catalog.sales.application.port.out.CustomerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StarterUseCases {

    @Bean
    public CatalogUseCase catalogUseCase(CompanyPort companyPort, CatalogPort catalogPort) {
        return new CatalogUseCase(companyPort, catalogPort);
    }

    @Bean
    public CartUseCase cartUseCase(CartPort cartPort, CustomerPort customerPort) {
        return new CartUseCase(cartPort, customerPort);
    }
}
