package com.bengaluru.vsv.service;

import com.bengaluru.vsv.config.security.UserPrincipal;
import com.bengaluru.vsv.model.Users;
import com.bengaluru.vsv.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);
        if (user == null) {
            System.out.println("Users not found");
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(user);
    }
}
