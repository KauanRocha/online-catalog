package com.example.online.catalog.auth.adapters.outbound.repositories;

import com.example.online.catalog.auth.domain.core.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Optional<Profile> findOneByUserId(Integer id);
}
