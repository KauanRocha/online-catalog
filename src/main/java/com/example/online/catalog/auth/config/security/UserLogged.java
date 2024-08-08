package com.example.online.catalog.auth.config.security;

import com.example.online.catalog.auth.domain.core.Profile;
import com.example.online.catalog.auth.domain.core.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserLogged implements UserDetails {

    private final Profile profile;

    private final User user;

    public UserLogged(Profile profile, User user) {
        this.profile = profile;
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (profile != null) {
            return List.of(() -> "ROLE_SIMPLE_MANAGER");
        }
        return List.of(() -> "ROLE_SIMPLE_USER");
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    public String getCompanyId() {
        return profile.getUser().getEmail();
    }

    public Object getUserId() {
        return user.getId();
    }
}
