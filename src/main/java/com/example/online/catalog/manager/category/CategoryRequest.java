package com.example.online.catalog.manager.category;

import jakarta.validation.constraints.NotNull;

public record CategoryRequest(
        @NotNull Integer id,
        @NotNull String name,
        @NotNull String description
) {
    public Category build() {
        var category = new Category();
        category.setId(id);
        category.setName(name);
        category.setDescription(description);

        return category;
    }

}
