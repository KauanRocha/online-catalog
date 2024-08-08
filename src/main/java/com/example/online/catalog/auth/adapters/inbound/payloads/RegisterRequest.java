package com.example.online.catalog.auth.adapters.inbound.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegisterRequest {
	
    @NotBlank(message="{fieldName}-is-mandatory")
    @NotNull
    private String name;

    @NotBlank(message="{fieldName}-is-mandatory")
    @NotNull
    @Size(min = 6, max = 40, message="{fieldName}-must-have-between-{min}-and-{max}-characters")
    private String password;

    @NotBlank(message="{fieldName}-is-mandatory")
    @NotNull
    @Email
    private String email;

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}