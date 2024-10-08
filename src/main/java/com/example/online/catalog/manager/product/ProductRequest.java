package com.example.online.catalog.manager.product;

import com.example.online.catalog.manager.category.CategoryRequest;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

public record ProductRequest(
        Integer id,
        @NotNull String name,
        @NotNull String description,
        @NotNull BigDecimal price,
        @NotNull BigDecimal promotionalPrice,
        @NotNull CategoryRequest category,
        @NotNull Set<ProductRequest> additionalProducts
) {

    public ProductRequest {
        if (additionalProducts == null) {
            additionalProducts = Set.of();
        }
    }

    public Product build() {
        var product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setPromotionalPrice(price);
        product.setDescription(description);
        product.setAdditionalProducts(
                additionalProducts.stream()
                        .map(ProductRequest::build)
                        .collect(Collectors.toSet())
        );

        return product;
    }
}
