package com.bengaluru.vsv.service;

import com.bengaluru.vsv.model.Role;
import com.bengaluru.vsv.model.Users;
import com.bengaluru.vsv.repo.RoleRepo;
import com.bengaluru.vsv.repo.UserRepo;
import com.bengaluru.vsv.config.security.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
    public Users registerUser(Users user) {
        // Encrypting the password using BCryptPasswordEncoder with 10 rounds
        user.setActualPassword(user.getPassword());
        user.setPassword(encoder.encode(user.getPassword()));
        // Fetch the default role
        Role defaultRole = roleRepo.findByRoleName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Default role ROLE_USER not found"));

        user.setRoles(Set.of(defaultRole));
        return userRepo.save(user);
    }

    public String verify(Users user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        }
        return "failed";
    }
}
