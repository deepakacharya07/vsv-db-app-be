package com.bengaluru.vsv.repository;

import com.bengaluru.vsv.model.committee.VsvCommitteeDetails;
import com.bengaluru.vsv.model.keys.CommitteDetailsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VsvCommitteeDetailsRepo extends JpaRepository<VsvCommitteeDetails, CommitteDetailsKey> {
}
