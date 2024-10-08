package com.example.online.catalog.manager.company;

import jakarta.validation.constraints.NotNull;

public record CompanyRequest(
        Integer id,
        @NotNull String name,
        @NotNull String description
) {
    public Company build() {
        var company = new Company();
        company.setId(id);
        company.setName(name);
        company.setDescription(description);

        return company;
    }
    
}
