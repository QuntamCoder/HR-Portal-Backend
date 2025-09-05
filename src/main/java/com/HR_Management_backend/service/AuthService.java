package com.HR_Management_backend.service;

import com.HR_Management_backend.dto.*;
import com.HR_Management_backend.entity.*;
import com.HR_Management_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String signup(SignupRequest request) {
        if (userRepository.findByUsername(request.username).isPresent())
            return "Username already exists!";
        if (userRepository.findByEmail(request.email).isPresent())
            return "Email already exists!";
        Role role = roleRepository.findByName(request.role)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        User user = new User();
        user.setUsername(request.username);
        user.setPasswordHash(passwordEncoder.encode(request.password));
        user.setEmail(request.email);
        user.setRole(role);
        userRepository.save(user);
        return "Signup successful!";
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.username)
                .orElse(null);
        if (user != null && passwordEncoder.matches(request.password, user.getPasswordHash())) {
            return new LoginResponse("Login successful!", user.getUsername(), user.getRole().getName());
        }
        return new LoginResponse("Login failed!", null, null);
    }
}