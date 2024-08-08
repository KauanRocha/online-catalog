package com.example.online.catalog.sales.adapter.inbound.presentation.rest.controllers;

import com.example.online.catalog.sales.adapter.inbound.presentation.payloads.request.FilterRequest;
import com.example.online.catalog.sales.adapter.inbound.presentation.payloads.response.SimpleCompanyResponse;
import com.example.online.catalog.sales.application.core.domain.catalog.CatalogProduct;
import com.example.online.catalog.sales.application.port.in.CatalogServicePort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path = "/sales")
public class SalesController {

    private final CatalogServicePort catalogService;

    public SalesController(CatalogServicePort catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping(path = "/stores")
    public List<SimpleCompanyResponse> searchStores(@RequestParam String zipCode, @RequestBody FilterRequest filterRequest) {
        return catalogService.searchForStores(zipCode, filterRequest.q())
                .stream().map(SimpleCompanyResponse::new).toList();
    }

    @GetMapping(path = "/{companyId}/products")
    public List<CatalogProduct> searchStores(@PathVariable Integer companyId, @RequestParam(defaultValue = "") String searchTerm) {
        return catalogService.searchProductsByCompanyId(companyId, searchTerm);
    }
}