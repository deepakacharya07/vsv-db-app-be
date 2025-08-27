package com.bengaluru.vsv.utils.mapper;

import com.bengaluru.vsv.dto.VsvMemberContactDTO;
import com.bengaluru.vsv.model.VsvMemberContact;

public class VsvMemberContactMapper {
    public static VsvMemberContactDTO toDto(VsvMemberContact entity) {
        if (entity == null) return null;

        VsvMemberContactDTO dto = new VsvMemberContactDTO();
        dto.setVsvId(entity.getVsvId());
        dto.setPresentAddress(entity.getPresentAddress());
        dto.setPresentPin(entity.getPresentPin());
        dto.setPresentGoogleMapLocn(entity.getPresentGoogleMapLocn());
        dto.setPermanentAddress(entity.getPermanentAddress());
        dto.setPermanentPin(entity.getPermanentPin());
        dto.setPermanentGoogleMapLocn(entity.getPermanentGoogleMapLocn());
        dto.setWhatsappNo(entity.getWhatsappNo());
        dto.setLandLineNo(entity.getLandLineNo());
        dto.setEmailId(entity.getEmailId());
        return dto;
    }

    public static VsvMemberContact toEntity(VsvMemberContactDTO dto) {
        if (dto == null) return null;

        VsvMemberContact entity = new VsvMemberContact();
        entity.setVsvId(dto.getVsvId());
        entity.setPresentAddress(dto.getPresentAddress());
        entity.setPresentPin(dto.getPresentPin());
        entity.setPresentGoogleMapLocn(dto.getPresentGoogleMapLocn());
        entity.setPermanentAddress(dto.getPermanentAddress());
        entity.setPermanentPin(dto.getPermanentPin());
        entity.setPermanentGoogleMapLocn(dto.getPermanentGoogleMapLocn());
        entity.setWhatsappNo(dto.getWhatsappNo());
        entity.setLandLineNo(dto.getLandLineNo());
        entity.setEmailId(dto.getEmailId());
        return entity;
    }
}
