package com.NotepadWeb.NotepadWebBackEnd.Service;


import com.NotepadWeb.NotepadWebBackEnd.Entity.LoginResponse;
import com.NotepadWeb.NotepadWebBackEnd.Security.JwtIssuer;
import com.NotepadWeb.NotepadWebBackEnd.Security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;
    public LoginResponse attempLogin(String email, String password){
        var authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email,password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        var principal=(UserPrincipal)authentication.getPrincipal();

        var roles=principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        var token=jwtIssuer.issue(principal.getUserId(), principal.getEmail(), roles);
        return LoginResponse.builder()
                .accessToken(token)
                .build();

    }
    }

