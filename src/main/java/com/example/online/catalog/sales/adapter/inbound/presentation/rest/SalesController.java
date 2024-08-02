package com.example.online.catalog.sales.adapter.inbound.presentation.rest;

import com.example.online.catalog.sales.application.core.domain.Company;
import com.example.online.catalog.sales.application.port.in.CatalogServicePort;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( path = "/sales")
public class SalesController {

    private final CatalogServicePort catalogService;

    public SalesController(CatalogServicePort catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping(path = "/stores")
    public List<Company> searchStores(@RequestParam @NotNull String zipCode, @RequestParam(defaultValue = "") String searchTerm) {
        return catalogService.searchForStores(zipCode, searchTerm);
    }
}
