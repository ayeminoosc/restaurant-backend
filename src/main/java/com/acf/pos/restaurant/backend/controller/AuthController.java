package com.acf.pos.restaurant.backend.controller;

import com.acf.pos.restaurant.backend.pojo.AuthRequest;
import com.acf.pos.restaurant.backend.pojo.AuthResponse;
import com.acf.pos.restaurant.backend.pojo.RefreshRequest;
import com.acf.pos.restaurant.backend.pojo.RegistrationRequest;
import com.acf.pos.restaurant.backend.security.JwtUtil;
import com.acf.pos.restaurant.backend.service.RefreshTokenService;
import com.acf.pos.restaurant.backend.service.RegistrationService;
import com.acf.pos.restaurant.backend.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${jwt.expiration.minutes:15}")
    private long expirationTimeInMinutes;

    @Autowired private RefreshTokenService refreshTokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest request) {
        try {
            registrationService.register(request);
            return ResponseEntity.ok("Registration successful");
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Registration failed: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) throws SQLException {
        String email = request.getEmail();
        String phoneNumber = request.getPhoneNumber();
        String password = request.getPassword();

        if (!userService.validateCredentials(email, phoneNumber, password)) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }

        String subject = email != null ? email : phoneNumber;

        String accessToken = jwtUtil.generateToken(subject, expirationTimeInMinutes * 60 * 1000);
        String refreshToken = refreshTokenService.create(subject);
        return ResponseEntity.ok(new AuthResponse(accessToken, refreshToken));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody RefreshRequest request) throws SQLException {
        String username = refreshTokenService.verify(request.getRefreshToken());
        String newAccessToken = jwtUtil.generateToken(username, 15 * 60 * 1000);
        return ResponseEntity.ok(new AuthResponse(newAccessToken, request.getRefreshToken()));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody RefreshRequest request) throws SQLException {
        refreshTokenService.revoke(request.getRefreshToken());
        return ResponseEntity.ok().build();
    }
}
