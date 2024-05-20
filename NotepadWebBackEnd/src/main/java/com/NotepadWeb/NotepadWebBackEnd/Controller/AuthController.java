package com.NotepadWeb.NotepadWebBackEnd.Controller;


import com.NotepadWeb.NotepadWebBackEnd.Entity.LoginRequest;
import com.NotepadWeb.NotepadWebBackEnd.Entity.LoginResponse;
import com.NotepadWeb.NotepadWebBackEnd.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth/login")
    public LoginResponse login (@RequestBody @Validated LoginRequest request){
        return authService.attempLogin(request.getEmail(),request.getPassword());


    }
}
