package com.bengaluru.vsv.repo;

import com.bengaluru.vsv.dto.VsvMemberContactDTO;
import com.bengaluru.vsv.model.VsvMemberContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VsvMemberContactRepo extends JpaRepository<VsvMemberContact, Integer> {
}
