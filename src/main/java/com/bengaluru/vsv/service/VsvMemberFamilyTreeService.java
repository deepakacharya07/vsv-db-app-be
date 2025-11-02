package com.bengaluru.vsv.service;

import com.bengaluru.vsv.dto.FamilyMemberDto;
import com.bengaluru.vsv.dto.MemberFamilyTreeDto;
import com.bengaluru.vsv.model.VsvFamilyTree;
import com.bengaluru.vsv.repository.VsvMemberFamilyTreeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VsvMemberFamilyTreeService {
    @Autowired
    private VsvMemberFamilyTreeRepo vsvMemberFamilyTreeRepo;
    public ResponseEntity<?> getFamilyTreeByMemberId(Integer memberId) {
        List<VsvFamilyTree> familyTrees = vsvMemberFamilyTreeRepo.findByIdVsvId(memberId);
        if (familyTrees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Family details not found for given member");
        }

        return ResponseEntity.status(HttpStatus.OK).body(this.convertToDTO(familyTrees));
    }

    public MemberFamilyTreeDto convertToDTO(List<VsvFamilyTree> sourceList) {
        if (sourceList == null || sourceList.isEmpty()) {
            return null;
        }

        int vsvId = sourceList.get(0).getId().getVsvId(); // Assuming same vsvId for all
        List<FamilyMemberDto> members = new ArrayList<>();

        for (VsvFamilyTree entity : sourceList) {
            FamilyMemberDto member = new FamilyMemberDto(
                    entity.getRelationVsvId(),
                    entity.getRelationName(),
                    entity.getRelationship().getRelationDescription(),
                    entity.getRelationship().getLevel(),
                    entity.getId().getOrder()
            );
            members.add(member);
        }

        return new MemberFamilyTreeDto(vsvId, members);
    }
}
