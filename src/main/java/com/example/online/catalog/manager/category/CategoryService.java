package com.example.online.catalog.manager.category;

import com.example.online.catalog.manager.common.exceptions.BackOfficeNotFoundException;
import com.example.online.catalog.manager.company.Company;
import com.example.online.catalog.manager.common.FilterRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryJpaRepository categoryJpaRepository;

    public CategoryService(CategoryJpaRepository categoryJpaRepository) {
        this.categoryJpaRepository = categoryJpaRepository;
    }

    public Page<Category> findAll(Company company, FilterRequest filter) {
        return categoryJpaRepository.findAllByCompanyAndNameContainingIgnoreCase(company, filter.query(), filter.build());
    }

    public Category findById(Integer id, Company company) {
        return categoryJpaRepository.findByIdAndCompany(id, company)
                .orElseThrow(BackOfficeNotFoundException::new);
    }

    private Category save(CategoryRequest categoryRequest, Company company) {
        var category = categoryRequest.build();
        category.setCompany(company);
        return categoryJpaRepository.save(category);
    }

    public Category update(CategoryRequest categoryRequest, Company company) {
        return save(categoryRequest, company);
    }

    public Category create(CategoryRequest categoryRequest, Company company) {
        return save(categoryRequest, company);
    }

    public void delete(Integer id, Company company) {
        categoryJpaRepository.deleteByIdAndCompany(id, company);
    }
}
