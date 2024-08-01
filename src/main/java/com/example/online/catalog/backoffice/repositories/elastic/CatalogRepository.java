package com.example.online.catalog.backoffice.repositories.elastic;

import com.example.online.catalog.backoffice.models.elastic.Catalog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends ElasticsearchRepository<Catalog, String> {
}
