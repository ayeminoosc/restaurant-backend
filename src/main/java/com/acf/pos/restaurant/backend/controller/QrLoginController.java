//package com.acf.pos.restaurant.backend.controller;
//
//import com.acf.pos.restaurant.backend.security.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/auth/qr")
//public class QrLoginController {
//
//    @Autowired
//    private QrSessionService qrService;
//    @Autowired private JwtUtil jwtUtil;
//    @Autowired private RefreshTokenService refreshTokenService;
//
//    @PostMapping("/create")
//    public QrSession createQrSession() {
//        return qrService.createPendingSession();
//    }
//
//    @PostMapping("/approve")
//    public ResponseEntity<?> approveQr(@RequestBody QrApproveRequest req, @AuthenticationPrincipal UserDetails user) {
//        qrService.approve(req.getSessionId(), user.getUsername());
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/status")
//    public ResponseEntity<?> checkStatus(@RequestParam String sessionId) {
//        Optional<String> username = qrService.getApprovedUsername(sessionId);
//        if (username.isPresent()) {
//            String access = jwtUtil.generateToken(username.get(), 15 * 60 * 1000);
//            String refresh = refreshTokenService.create(username.get());
//            return ResponseEntity.ok(new AuthResponse(access, refresh));
//        } else {
//            return ResponseEntity.status(204).build(); // Not ready
//        }
//    }
//}
