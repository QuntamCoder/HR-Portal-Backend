package com.HR_Management_backend.controller;

import com.HR_Management_backend.entity.Role;
import com.HR_Management_backend.entity.User;
import com.HR_Management_backend.repository.RoleRepository;
import com.HR_Management_backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/signup")
    public Map<String, Object> signup(@RequestBody Map<String, String> payload) {
        String username = payload.get("username");
        String password = payload.get("password");
        String email = payload.get("email");
        String role = payload.get("role");

        String result = authService.signup(username, password, email, role);
        Map<String, Object> resp = new HashMap<>();
        if ("success".equals(result)) {
            resp.put("success", true);
            resp.put("message", "Registration successful! Please sign in.");
        } else {
            resp.put("success", false);
            resp.put("message", result);
        }
        return resp;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> payload) {
        String username = payload.get("username");
        String password = payload.get("password");
        String role = payload.get("role");

        Optional<User> userOpt = authService.authenticate(username, password, role);
        Map<String, Object> resp = new HashMap<>();
        if (userOpt.isPresent()) {
            resp.put("success", true);
            resp.put("role", userOpt.get().getRole().getName());
        } else {
            resp.put("success", false);
            resp.put("message", "Invalid credentials");
        }
        return resp;
    }

    @GetMapping("/roles")
    public List<Map<String, Object>> getRoles() {
        List<Role> roles = roleRepository.findAll();
        List<Map<String, Object>> list = new ArrayList<>();
        for (Role r : roles) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", r.getId());
            map.put("name", r.getName());
            list.add(map);
        }
        return list;
    }
}