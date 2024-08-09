package com.example.online.catalog.sales.adapter.outbound.entity.sql.order;

import com.example.online.catalog.sales.adapter.outbound.entity.sql.User;
import jakarta.persistence.*;

@Entity(name = "SalesCustomer")
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
