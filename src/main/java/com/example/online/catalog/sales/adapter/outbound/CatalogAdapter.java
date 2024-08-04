package com.example.online.catalog.sales.adapter.outbound;

import com.example.online.catalog.sales.adapter.converters.CatalogProductsConverter;
import com.example.online.catalog.sales.adapter.outbound.entity.elastic.CatalogProduct;
import com.example.online.catalog.sales.application.port.out.CatalogPort;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogAdapter implements CatalogPort {

    private final ElasticsearchTemplate elasticsearchTemplate;

    public CatalogAdapter(ElasticsearchTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    public List<com.example.online.catalog.sales.application.core.domain.CatalogProduct> getCatalogProductsByCompanyId(Integer companyId) {
        Criteria criteria = new Criteria("company.id").is(companyId);
        return elasticsearchTemplate
                .search(new CriteriaQuery(criteria), CatalogProduct.class)
                .getSearchHits()
                .stream()
                .map(SearchHit::getContent)
                .map(CatalogProductsConverter::convertToDomain)
                .toList();
    }
}
