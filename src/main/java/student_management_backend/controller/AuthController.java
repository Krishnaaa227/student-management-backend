package student_management_backend.controller;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import student_management_backend.dto.AuthenticationResponse;
import student_management_backend.dto.LoginRequest;
import student_management_backend.dto.RegisterRequest;
import student_management_backend.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

   @PostMapping("/register")
public String register(@Valid @RequestBody RegisterRequest request) {
    return authService.register(request);
}

@PostMapping("/login")
public AuthenticationResponse login(@Valid @RequestBody LoginRequest request) {
    return authService.login(request);
}
}