package com.example.online.catalog.backoffice.services;

import com.example.online.catalog.backoffice.exceptions.BackOfficeNotFoundException;
import com.example.online.catalog.backoffice.models.sql.Company;
import com.example.online.catalog.backoffice.models.sql.Product;
import com.example.online.catalog.backoffice.payloads.requests.FilterRequest;
import com.example.online.catalog.backoffice.payloads.requests.ProductRequest;
import com.example.online.catalog.backoffice.repositories.sql.ProductJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductJpaRepository productJpaRepository;

    public ProductService(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    public Page<Product> findAll(Company company, FilterRequest filter) {
        return productJpaRepository.findAllByCompanyAndNameContainingIgnoreCase(company, filter.query(), filter.build());
    }

    public Product findById(Integer id, Company company) {
        return productJpaRepository.findByIdAndCompany(id, company)
                .orElseThrow(BackOfficeNotFoundException::new);
    }

    private Product save(ProductRequest productRequest, Company company) {
        Product product = productRequest.build();
        product.setCompany(company);
        return productJpaRepository.save(product);
    }

    public Product update(ProductRequest productRequest, Company company) {
        return save(productRequest, company);
    }

    public Product create(ProductRequest productRequest, Company company) {
        return save(productRequest, company);
    }

    public void delete(Integer id, Company company) {
        productJpaRepository.deleteByIdAndCompany(id, company);
    }
}
