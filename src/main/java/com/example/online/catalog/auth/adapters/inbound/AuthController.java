package com.example.online.catalog.auth.adapters.inbound;

import com.example.online.catalog.auth.adapters.inbound.payloads.JwtResponse;
import com.example.online.catalog.auth.adapters.inbound.payloads.LoginRequest;
import com.example.online.catalog.auth.adapters.inbound.payloads.RegisterRequest;
import com.example.online.catalog.auth.domain.usecase.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public JwtResponse login(@RequestBody LoginRequest loginRequest) {
        return authenticationService.login(loginRequest);
    }

    @PostMapping("/login/intern")
    @ResponseStatus(HttpStatus.OK)
    public JwtResponse interLogin(@RequestBody LoginRequest loginRequest) {
        return authenticationService.interLogin(loginRequest);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public JwtResponse register(@RequestBody RegisterRequest registerRequest) {
        return authenticationService.register(registerRequest);
    }
}
