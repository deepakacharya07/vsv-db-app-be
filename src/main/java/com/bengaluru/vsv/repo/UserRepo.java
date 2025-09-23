package com.bengaluru.vsv.repo;

import com.bengaluru.vsv.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}
