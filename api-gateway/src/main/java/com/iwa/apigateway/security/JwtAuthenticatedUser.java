package com.iwa.apigateway.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtAuthenticatedUser implements Authentication {

    private final String userId;
    private boolean authenticated = true;

    public JwtAuthenticatedUser(String userId) {
        this.userId = userId;
    }

    // Implémentez les méthodes de l'interface Authentication
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; // Pas de rôles spécifiques
    }

    @Override
    public Object getCredentials() {
        return null; // Pas nécessaire
    }

    @Override
    public Object getDetails() {
        return userId;
    }

    @Override
    public Object getPrincipal() {
        return userId;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return userId;
    }
}