package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Simple dummy user (you can replace with DB user later)
        return User.builder()
                .username(username)
                .password("{noop}password")
                .roles("USER")
                .build();
    }
}
