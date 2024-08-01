package com.example.online.catalog.backoffice.services;

import com.example.online.catalog.backoffice.models.sql.Company;
import com.example.online.catalog.backoffice.models.sql.Product;
import com.example.online.catalog.backoffice.payloads.requests.FilterRequest;
import com.example.online.catalog.backoffice.payloads.requests.ProductRequest;
import com.example.online.catalog.backoffice.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> findAll(Company company, FilterRequest filter) {
        return productRepository.findAllByCompanyAndNameContainingIgnoreCase(company, filter.query(), filter.build());
    }

    public Optional<Product> findById(Integer id, Company company) {
        return productRepository.findByIdAndCompany(id, company);
    }

    private Product save(ProductRequest productRequest, Company company) {
        Product product = productRequest.build();
        product.setCompany(company);
        return productRepository.save(product);
    }

    public Product update(ProductRequest productRequest, Company company) {
        return save(productRequest, company);
    }

    public Product create(ProductRequest productRequest, Company company) {
        return save(productRequest, company);
    }

    public void delete(Integer id, Company company) {
        productRepository.deleteByIdAndCompany(id, company);
    }
}
