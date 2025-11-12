package com.bengaluru.vsv.service;

import com.bengaluru.vsv.dto.VsvCommitteeDetailsDto;
import com.bengaluru.vsv.model.committee.VsvCommitteeDetails;
import com.bengaluru.vsv.repository.VsvCommitteeDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VsvCommitteeDetailsService {
    @Value("${app.base-url}")
    private String baseUrl;

    @Autowired
    private VsvCommitteeDetailsRepo vsvCommitteeDetailsRepo;

    public ResponseEntity<?> getCommitteeDetails() {
        List<VsvCommitteeDetails> committeeDetails = vsvCommitteeDetailsRepo.findAll();
        if (committeeDetails.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Committee details not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(committeeDetails));
    }

    private List<VsvCommitteeDetailsDto> convertToDto(List<VsvCommitteeDetails> committeeDetails) {
        List<VsvCommitteeDetailsDto> committeeDetailsList = new ArrayList<>();
        for (VsvCommitteeDetails committeeDetail : committeeDetails) {
            VsvCommitteeDetailsDto dto = new VsvCommitteeDetailsDto();
            dto.setVsvId(committeeDetail.getCommitteDetailsKey().getVsvId());
            dto.setCommitteId(committeeDetail.getCommitteDetailsKey().getCommitteId());
            dto.setComDesgnId(committeeDetail.getCommitteDetailsKey().getComDesgnId());
            dto.setCommitteLocId(committeeDetail.getCommitteDetailsKey().getCommitteLocId());
            dto.setStartDate(committeeDetail.getStartDate());
            dto.setEndDate(committeeDetail.getEndDate());
            if(committeeDetail.getMemberMaster() != null) {
                dto.setGender(committeeDetail.getMemberMaster().getGender());
                if (committeeDetail.getMemberMaster().getMemberPhoto() != null && committeeDetail.getMemberMaster().getMemberPhoto().getIndividualPhotoBlob()!= null) {
                    String imageUrl = String.format("%s/vsv-photo/%d",
                            baseUrl,
                            committeeDetail.getMemberMaster().getVsvId());
                    dto.setIndividualPhotoBaseUrl(imageUrl);
                }
            }
            dto.setMemberName(committeeDetail.getMemberName());
            dto.setCommitteeHeader(committeeDetail.getCommitteHeader());
            dto.setCommitteeDesignation(committeeDetail.getCommitteDesignation());
            committeeDetailsList.add(dto);
        }

        return committeeDetailsList;
    }
}
