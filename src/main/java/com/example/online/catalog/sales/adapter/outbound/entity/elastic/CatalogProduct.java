package com.example.online.catalog.sales.adapter.outbound.entity.elastic;

import com.example.online.catalog.backoffice.models.elastic.Catalog;
import com.example.online.catalog.backoffice.models.sql.Category;
import com.example.online.catalog.backoffice.models.sql.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.util.Set;

@Document(indexName = "catalog_products")
public class CatalogProduct {

    @Id
    private String id;

    @Field(type = FieldType.Integer)
    private Integer productId;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Double)
    private BigDecimal price;

    @Field(type = FieldType.Object)
    private Category category;

    @Field(type = FieldType.Object)
    private Catalog catalog;

    @Field(type = FieldType.Nested, includeInParent = true)
    private Set<Product> additionalProducts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Set<Product> getAdditionalProducts() {
        return additionalProducts;
    }

    public void setAdditionalProducts(Set<Product> additionalProducts) {
        this.additionalProducts = additionalProducts;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
