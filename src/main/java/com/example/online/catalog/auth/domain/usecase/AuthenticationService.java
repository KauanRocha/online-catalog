package com.example.online.catalog.auth.domain.usecase;

import com.example.online.catalog.auth.adapters.inbound.payloads.JwtResponse;
import com.example.online.catalog.auth.adapters.inbound.payloads.LoginRequest;
import com.example.online.catalog.auth.adapters.inbound.payloads.RegisterRequest;
import com.example.online.catalog.auth.adapters.outbound.repositories.ProfileRepository;
import com.example.online.catalog.auth.adapters.outbound.repositories.UserRepository;
import com.example.online.catalog.auth.config.security.TokenService;
import com.example.online.catalog.auth.config.security.UserLogged;
import com.example.online.catalog.auth.domain.core.User;
import com.example.online.catalog.auth.domain.exceptions.EmailAlreadyExistsException;
import com.example.online.catalog.auth.domain.exceptions.UserNameNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

  private final TokenService jwtService;

  private final UserRepository userRepository;

  private final ProfileRepository profileRepository;

  private final PasswordEncoder passwordEncoder;

    public AuthenticationService(TokenService jwtService, UserRepository userRepository, ProfileRepository profileRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
    this.jwtService = jwtService;
      this.userRepository = userRepository;
      this.profileRepository = profileRepository;
      this.passwordEncoder = passwordEncoder;
    }

  public JwtResponse interLogin(LoginRequest loginRequest) {

    var user = userRepository.findByEmail(loginRequest.username())
            .orElseThrow(() -> new EmailAlreadyExistsException(loginRequest.username()));

    if(!passwordEncoder.matches(loginRequest.password(), user.getPassword())) {
      throw new EmailAlreadyExistsException("Problem for registering user");
    }

    var profile = profileRepository.findOneByUserId(user.getId())
            .orElseThrow(UserNameNotFoundException::new);

    String token = jwtService.generateToken(new UserLogged(profile, user));
    return new JwtResponse(token,
            user.getId(),
            user.getName(),
            user.getEmail());
  }

  public JwtResponse login(LoginRequest loginRequest) {

    var user = userRepository.findByEmail(loginRequest.username())
            .orElseThrow(() -> new EmailAlreadyExistsException(loginRequest.username()));

    if(!passwordEncoder.matches(loginRequest.password(), user.getPassword())) {
      throw new EmailAlreadyExistsException("Problem for registering user");
    }
    String token = jwtService.generateToken(new UserLogged(null, user));
    return new JwtResponse(token,
            user.getId(),
            user.getName(),
            user.getEmail());
  }

  public JwtResponse register(RegisterRequest signUpRequest) {
    var optionalUser = userRepository.findByEmail(signUpRequest.getEmail());
    if (optionalUser.isPresent()) {
      throw new EmailAlreadyExistsException("Problem for registering user");
    }

    User user = new User();
    user.setName(signUpRequest.getUsername());
    user.setEmail(signUpRequest.getEmail());
    user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
    userRepository.save(user);

    var token = jwtService.generateToken(new UserLogged(null, user));

    return new JwtResponse(token,
            user.getId(),
            user.getName(),
            user.getEmail());
  }
}
