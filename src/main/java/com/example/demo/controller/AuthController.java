// package com.example.demo.controller;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.security.JwtUtil;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final JwtUtil jwtUtil;

//     public AuthController(JwtUtil jwtUtil) {
//         this.jwtUtil = jwtUtil;
//     }

//     @PostMapping("/login")
//     public ResponseEntity<String> login(@RequestBody AuthRequest request) {
//         String token = jwtUtil.generateToken(
//                 request.getUsername(),
//                 request.getRole(),
//                 request.getEmail(),
//                 1L
//         );
//         return ResponseEntity.ok(token);
//     }
// }
package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {
        // Mock registration response
        return "Registered: " + request.getUsername();
    }
}
