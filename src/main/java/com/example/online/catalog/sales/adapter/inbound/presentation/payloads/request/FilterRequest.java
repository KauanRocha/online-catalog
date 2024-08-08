package com.example.online.catalog.sales.adapter.inbound.presentation.payloads.request;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public record FilterRequest(String q, Integer page, Integer perPage, String sort, String sortColumn) {

    public Pageable build() {
        Sort s = Sort.by(Direction.fromString(sort), sortColumn);
        return PageRequest.of(page - 1, perPage, s);
    }
}
