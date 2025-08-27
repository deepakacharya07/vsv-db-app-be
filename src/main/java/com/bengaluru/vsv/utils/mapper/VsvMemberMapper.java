package com.bengaluru.vsv.utils.mapper;

import com.bengaluru.vsv.dto.CommitteDTO;
import com.bengaluru.vsv.dto.VsvMemberDTO;
import com.bengaluru.vsv.model.VsvMemberContact;
import com.bengaluru.vsv.model.VsvMemberMaster;

public class VsvMemberMapper {

    // Convert entity to DTO
    public static VsvMemberDTO toDto(VsvMemberMaster entity) {
        if (entity == null) return null;

        VsvMemberDTO dto = new VsvMemberDTO();
        dto.setVsvId(entity.getVsvId());
        dto.setName(entity.getName());
        dto.setGender(entity.getGender());
        dto.setDob(entity.getDob());
        dto.setAge(entity.getAge());
        dto.setBirthPlace(entity.getBirthPlace());
        dto.setNativePlace(entity.getNativePlace());
        dto.setMaritalStatus(entity.getMaritalStatus());
        dto.setMobileNo(entity.getMobileNo());
        dto.setBloodGroup(entity.getBloodGroup());
        dto.setQualificationId(entity.getQualificationId());
        dto.setIsStudent(entity.getIsStudent());
        dto.setCourseDetail(entity.getCourseDetail());
        dto.setMemberStatus(entity.getMemberStatus());

        // Map committee if needed
        //if (entity.getCommitte() != null) {
        //    dto.setCommitte(CommitteMapper.toDto(entity.getCommitte()));
        //}
        dto.setContact(VsvMemberContactMapper.toDto(entity.getContact()));
        return dto;
    }

    // Convert DTO to entity
    public static VsvMemberMaster toEntity(VsvMemberDTO dto) {
        if (dto == null) return null;

        VsvMemberMaster entity = new VsvMemberMaster();
        entity.setVsvId(dto.getVsvId());
        entity.setName(dto.getName());
        entity.setGender(dto.getGender());
        entity.setDob(dto.getDob());
        entity.setAge(dto.getAge());
        entity.setBirthPlace(dto.getBirthPlace());
        entity.setNativePlace(dto.getNativePlace());
        entity.setMaritalStatus(dto.getMaritalStatus());
        entity.setMobileNo(dto.getMobileNo());
        entity.setBloodGroup(dto.getBloodGroup());
        entity.setQualificationId(dto.getQualificationId());
        entity.setIsStudent(dto.getIsStudent());
        entity.setCourseDetail(dto.getCourseDetail());
        entity.setMemberStatus(dto.getMemberStatus());

        // Map committee if needed
        //if (dto.getCommitte() != null) {
        //    entity.setCommitte(CommitteMapper.toEntity(dto.getCommitte()));
        //}
        // Set contact info if present
        VsvMemberContact contact = VsvMemberContactMapper.toEntity(dto.getContact());
        if (contact != null) {
            contact.setMember(entity); // important for bidirectional relation
            entity.setContact(contact);
        }
        return entity;
    }
}


