package com.bengaluru.vsv.repo;

import com.bengaluru.vsv.model.VsvMemberMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VsvMemberRepo extends JpaRepository<VsvMemberMaster, Integer> {
    @Query("SELECT m FROM VsvMemberMaster m WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<VsvMemberMaster> searchByName(@Param("name") String name);

    boolean existsByMobileNo(String mobileNo);
}
