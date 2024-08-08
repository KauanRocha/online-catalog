package com.example.online.catalog.auth.config.security;

import com.example.online.catalog.auth.adapters.outbound.repositories.ProfileRepository;
import com.example.online.catalog.auth.adapters.outbound.repositories.UserRepository;
import com.example.online.catalog.auth.domain.exceptions.UserNameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private final ProfileRepository profileRepository;

    private final UserRepository userRepository;

    public UserDetailsServiceImp(ProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(username)
                .orElseThrow(UserNameNotFoundException::new);
        return new UserLogged(null, user);

    }

    public UserDetails loadProfileByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(username)
                .orElseThrow(UserNameNotFoundException::new);

        var profile = profileRepository.findOneByUserId(user.getId())
                                .orElseThrow(UserNameNotFoundException::new);

        return new UserLogged(profile, user);
    }

}
