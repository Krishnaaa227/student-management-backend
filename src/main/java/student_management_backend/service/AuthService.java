package student_management_backend.service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import student_management_backend.dto.AuthenticationResponse;
import student_management_backend.dto.LoginRequest;
import student_management_backend.security.CustomUserDetailsService;
import student_management_backend.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import student_management_backend.dto.RegisterRequest;
import student_management_backend.entity.User;
import student_management_backend.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;
    public AuthService(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder,
        AuthenticationManager authenticationManager,
        JwtService jwtService,
        CustomUserDetailsService userDetailsService) {

    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.authenticationManager = authenticationManager;
    this.jwtService = jwtService;
    this.userDetailsService = userDetailsService;
}
    public String register(RegisterRequest request) {

    // Check if username already exists
    if (userRepository.findByUsername(request.getUsername()).isPresent()) {
    throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "Username already exists"
    );
}

    User user = new User();

    user.setUsername(request.getUsername());

    // Hash the password before saving
    user.setPassword(passwordEncoder.encode(request.getPassword()));

    // Default role
    user.setRole("USER");

    userRepository.save(user);

    return "User registered successfully!";
}
public AuthenticationResponse login(LoginRequest request) {

    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()
            )
    );

    UserDetails userDetails =
        userRepository.findByUsername(request.getUsername())
                .map(user -> org.springframework.security.core.userdetails.User
                        .builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .roles(user.getRole())
                        .build())
                .orElseThrow();

String token = jwtService.generateToken(userDetails);

return new AuthenticationResponse(token);
}
}