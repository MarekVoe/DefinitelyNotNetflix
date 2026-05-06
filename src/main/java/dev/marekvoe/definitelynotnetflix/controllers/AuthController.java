package dev.marekvoe.definitelynotnetflix.controllers;

import dev.marekvoe.definitelynotnetflix.dto.LoginRequest;
import dev.marekvoe.definitelynotnetflix.models.User;
import dev.marekvoe.definitelynotnetflix.repositories.IUserRepository;
import dev.marekvoe.definitelynotnetflix.services.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setId(null);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        User existing  = userRepository.findByUsername(request.getUsername()).orElseThrow();
        if (!passwordEncoder.matches(request.getPassword(), existing.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }
        return jwtService.generateToken(existing.getUsername());
    }
}
