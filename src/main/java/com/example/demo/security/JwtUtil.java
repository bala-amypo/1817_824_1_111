
package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String secret = "secret-key-123456";

    public String generateToken(String username,
                                String role,
                                String email,
                                String userId) {

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .claim("email", email)
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public void validate(String token) {
        Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token);
    }
}
