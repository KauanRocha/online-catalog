package com.example.online.catalog.backoffice.payloads.requests;

import com.example.online.catalog.backoffice.models.elastic.Catalog;
import jakarta.validation.constraints.NotNull;

import java.util.Set;
import java.util.stream.Collectors;

public record CatalogRequest(
        String id,
        @NotNull String name,
        @NotNull String description,
        @NotNull Set<ProductRequest> products
) {
    public Catalog build() {
        var catalog = new Catalog();
        catalog.setId(id);
        catalog.setName(name);
        catalog.setDescription(description);
        catalog.setProducts(
                products.stream()
                        .map(ProductRequest::build)
                        .collect(Collectors.toSet())
        );

        return catalog;
    }
    
}
