package com.example.online.catalog.sales.application.port.out;

import com.example.online.catalog.auth.domain.core.User;

import java.util.Optional;

public interface UserPort {

    Optional<User> findById(Integer id);

    User save(User user);

}
