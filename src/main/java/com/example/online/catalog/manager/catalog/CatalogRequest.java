package com.example.online.catalog.manager.catalog;

import com.example.online.catalog.manager.product.ProductRequest;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record CatalogRequest(
        Integer id,
        @NotNull String name,
        @NotNull String description,
        @NotNull Set<ProductRequest> products
) {
    public Catalog build() {
        var catalog = new Catalog();
        catalog.setId(id);
        catalog.setName(name);
        catalog.setDescription(description);

        return catalog;
    }
    
}
