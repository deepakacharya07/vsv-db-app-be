package com.bengaluru.vsv.service;

import com.bengaluru.vsv.dto.LoginResponse;
import com.bengaluru.vsv.dto.VsvMemberDTO;
import com.bengaluru.vsv.model.Role;
import com.bengaluru.vsv.model.Users;
import com.bengaluru.vsv.repository.RoleRepo;
import com.bengaluru.vsv.repository.UserRepo;
import com.bengaluru.vsv.config.security.JWTService;
import com.bengaluru.vsv.repository.VsvMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
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
    private VsvMemberRepo vsvMemberRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private VsvMemberService vsvMemberService;

    @Autowired
    private JWTService jwtService;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public ResponseEntity<String> registerUser(Users user) {
        try {
            // Check if phone number is null or not in vsvMemberRepo
            if (user.getPhoneNumber() == null || !vsvMemberRepo.existsByMobileNo(user.getPhoneNumber())) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Mobile number not found in customer records");
            }

            // ✅ Check if email already exists
            if (userRepo.existsByPhoneNumber(user.getPhoneNumber()) || userRepo.existsByUsername(user.getUsername())) {
                return ResponseEntity
                        .status(HttpStatus.CONFLICT) // 409
                        .body("Phone number or username already registered");
            }

            Integer vsvId = vsvMemberRepo.findByMobileNo(user.getPhoneNumber());

            user.setActualPassword(user.getPassword());
            user.setPassword(encoder.encode(user.getPassword()));
            user.setVsvId(vsvId);

            Role defaultRole = roleRepo.findByRoleName("ROLE_USER")
                    .orElseThrow(() -> new IllegalStateException("Default role ROLE_USER not found"));

            user.setRoles(Set.of(defaultRole));

            userRepo.save(user);

            return ResponseEntity.status(HttpStatus.CREATED).body("User successfully registered");

        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Unexpected error: " + ex.getMessage());
        }
    }

    public ResponseEntity<?> verify(Users user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            if (authentication.isAuthenticated()) {
                Users loggedInUser = userRepo.findByUsername(user.getUsername());

                // Step 2: Fetch related VsvMemberMaster entity using vsv_id
                ResponseEntity<VsvMemberDTO> member = vsvMemberService.findById(loggedInUser.getVsvId());

                // Step 3: Generate JWT Token
                String token = jwtService.generateToken(user.getUsername());
                return ResponseEntity.ok(new LoginResponse(token, member.getBody()));
            }
        } catch (AuthenticationException ex) {
            // Catch bad credentials or disabled account
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
    }
}
