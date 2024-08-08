package com.example.online.catalog.manager.company;

import com.example.online.catalog.manager.common.FilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/manager/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public Page<Company> getAllCompanies(FilterRequest filter) {
        return companyService.findAll(filter);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company createCompany(@RequestBody CompanyRequest companyRequest) {
        return companyService.create(companyRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Company updateCompany(@PathVariable Integer id, @RequestBody CompanyRequest companyRequest) {
        return companyService.update(companyRequest);
    }
}
