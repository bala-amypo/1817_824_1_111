
// package com.example.demo.security;

// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.stereotype.Component;

// import java.util.Date;

// @Component
// public class JwtUtil {

//     private final String secret = "secret-key-123456";

//     public String generateToken(String username,
//                                 String role,
//                                 String email,
//                                 String userId) {

//         return Jwts.builder()
//                 .setSubject(username)
//                 .claim("role", role)
//                 .claim("email", email)
//                 .claim("userId", userId)
//                 .setIssuedAt(new Date())
//                 .signWith(SignatureAlgorithm.HS256, secret)
//                 .compact();
//     }

//     public void validate(String token) {
//         Jwts.parser()
//                 .setSigningKey(secret)
//                 .parseClaimsJws(token);
//     }
// }
package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "secretkey123";

    public String generateToken(String username, String role, String email, Long userId) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        claims.put("email", email);
        claims.put("userId", userId);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
