package com.example.online.catalog.backoffice.payloads.requests;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public record FilterRequest(
        @NotNull Integer page,
        @NotNull Integer perPage,
        @NotNull String query,
        @NotNull String sort,
        @NotNull String sortColumn
) {

    public Pageable build() {
        Sort s = Sort.by(Direction.fromString(sort), sortColumn);
        return PageRequest.of(page - 1, perPage, s);
    }
}
