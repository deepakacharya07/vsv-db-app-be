package com.bengaluru.vsv.repository;

import com.bengaluru.vsv.model.VsvFamilyTree;
import com.bengaluru.vsv.model.keys.VsvFamilyTreeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VsvMemberFamilyTreeRepo extends JpaRepository<VsvFamilyTree, VsvFamilyTreeKey> {
    List<VsvFamilyTree> findByIdVsvId(Integer vsvId);
}
