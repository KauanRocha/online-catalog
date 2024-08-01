package com.example.online.catalog.backoffice.services;


import com.example.online.catalog.backoffice.models.sql.Company;
import com.example.online.catalog.backoffice.models.elastic.Catalog;
import com.example.online.catalog.backoffice.payloads.requests.CatalogRequest;
import com.example.online.catalog.backoffice.payloads.requests.FilterRequest;
import com.example.online.catalog.backoffice.repositories.elastic.CatalogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.data.elasticsearch.client.elc.Queries.matchQuery;

@Service
public class CatalogService {

    private final CatalogRepository catalogRepository;
    private final ElasticsearchTemplate elasticsearchTemplate;

    public CatalogService(CatalogRepository catalogRepository, ElasticsearchTemplate elasticsearchTemplate) {
        this.catalogRepository = catalogRepository;
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    public Page<Catalog> findAll(Company company, FilterRequest filter) {
        var pageable = filter.build();
        Query searchQuery = new NativeQueryBuilder()
                .withQuery((matchQuery("company.id", company.getId()))
                        .must(matchQuery("name", filter.query()).fuzziness("AUTO")))
                .withPageable(pageable)
                .build();

        return elasticsearchTemplate.search(searchQuery, Catalog.class).map(SearchHit::getContent);
    }

    public Optional<Catalog> findById(String id, Company company) {
        return catalogRepository.findById(id)
                .filter(catalog -> catalog.getCompany().getId().equals(company.getId()));
    }

    private Catalog save(CatalogRequest catalogRequest, Company company) {
        Catalog catalog = catalogRequest.build();
        catalog.se(company);
        return catalogRepository.save(catalog);
    }

    public Catalog update(CatalogRequest catalogRequest, Company company) {
        return save(catalogRequest, company);
    }

    public Catalog create(CatalogRequest catalogRequest, Company company) {
        return save(catalogRequest, company);
    }

    public void delete(String id, Company company) {
        catalogRepository.findById(id)
                .filter(catalog -> catalog.getCompany().getId().equals(company.getId()))
                .ifPresent(catalogRepository::delete);
    }
}
