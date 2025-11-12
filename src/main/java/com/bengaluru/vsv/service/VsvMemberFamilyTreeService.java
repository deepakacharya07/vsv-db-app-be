package com.bengaluru.vsv.service;

import com.bengaluru.vsv.dto.FamilyMemberDto;
import com.bengaluru.vsv.dto.MemberFamilyTreeDto;
import com.bengaluru.vsv.model.VsvFamilyTree;
import com.bengaluru.vsv.repository.VsvMemberFamilyTreeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VsvMemberFamilyTreeService {
    @Value("${app.base-url}")
    private String baseUrl;

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
            FamilyMemberDto familyMemberDto = new FamilyMemberDto();
            familyMemberDto.setRelationVsvId(entity.getRelationVsvId());
            familyMemberDto.setRelationName(entity.getRelationName());
            familyMemberDto.setLevel(entity.getRelationship().getLevel());
            familyMemberDto.setRelationDescription(entity.getRelationship().getRelationDescription());
            if(entity.getRelatedMember() != null) {
                familyMemberDto.setGender(entity.getRelatedMember().getGender());
                if(entity.getRelatedMember().getMemberPhoto() != null && entity.getRelatedMember().getMemberPhoto().getIndividualPhotoBlob()!= null) {
                    String imageUrl = String.format("%s/vsv-photo/%d",
                            baseUrl,
                            entity.getRelatedMember().getMemberPhoto().getVsvId());
                    familyMemberDto.setIndividualPhotoBaseUrl(imageUrl);
                }
            }
            members.add(familyMemberDto);
        }

        return new MemberFamilyTreeDto(vsvId, members);
    }
}
