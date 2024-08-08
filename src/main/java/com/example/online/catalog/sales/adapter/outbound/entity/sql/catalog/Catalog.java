package com.example.online.catalog.sales.adapter.outbound.entity.sql.catalog;

import com.example.online.catalog.sales.adapter.outbound.entity.sql.Company;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "SalesCatalog")
@Table(name = "catalogs")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "id_company")
    private Company company;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "catalog")
    private List<CatalogProduct> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<CatalogProduct> getProducts() {
        return products;
    }

    public void setProducts(List<CatalogProduct> products) {
        this.products = products;
    }
}
