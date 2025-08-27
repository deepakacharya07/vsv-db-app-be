package com.bengaluru.vsv.utils.mapper;

import com.bengaluru.vsv.dto.CommitteDTO;
import com.bengaluru.vsv.model.CommitteMaster;

public class CommitteMapper {

    public static CommitteDTO toDto(CommitteMaster entity) {
        if (entity == null) return null;

        CommitteDTO dto = new CommitteDTO();
        dto.setCommitteId(entity.getCommitteId());
        dto.setCommitteName(entity.getCommitteName());
        dto.setRegistrationNo(entity.getRegistrationNo());
        dto.setAddress(entity.getAddress());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setPin(entity.getPin());
        dto.setBankIFSC(entity.getBankIFSC());
        // Skipping members list here to avoid recursion or heavy loading

        return dto;
    }

    public static CommitteMaster toEntity(CommitteDTO dto) {
        if (dto == null) return null;

        CommitteMaster entity = new CommitteMaster();
        entity.setCommitteId(dto.getCommitteId());
        entity.setCommitteName(dto.getCommitteName());
        entity.setRegistrationNo(dto.getRegistrationNo());
        entity.setAddress(dto.getAddress());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setPin(dto.getPin());
        entity.setContactNumber(dto.getContactNumber());
        entity.setBankIFSC(dto.getBankIFSC());
        // Skip setting members list here

        return entity;
    }
}

