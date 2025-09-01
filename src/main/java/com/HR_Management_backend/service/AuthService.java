package com.HR_Management_backend.service;

import com.HR_Management_backend.entity.User;
import com.HR_Management_backend.entity.Role;
import com.HR_Management_backend.repository.UserRepository;
import com.HR_Management_backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String signup(String username, String password, String email, String roleName) {
        if (userRepository.existsByUsername(username) || userRepository.existsByEmail(email)) {
            return "Username or Email already exists";
        }
        Role role = roleRepository.findByNameIgnoreCase(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        User user = new User();
        user.setUsername(username);
        user.setPasswordHash(encoder.encode(password));
        user.setEmail(email);
        user.setRole(role);
        userRepository.save(user);
        return "success";
    }

    public Optional<User> authenticate(String username, String password, String roleName) {
        Optional<User> optUser = userRepository.findByUsernameAndRole_NameIgnoreCase(username, roleName);
        if (optUser.isPresent() && encoder.matches(password, optUser.get().getPasswordHash())) {
            return optUser;
        }
        return Optional.empty();
    }
}