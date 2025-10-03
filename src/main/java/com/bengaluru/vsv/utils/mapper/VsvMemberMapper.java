package com.bengaluru.vsv.utils.mapper;

import com.bengaluru.vsv.dto.VsvMemberDto;
import com.bengaluru.vsv.dto.VsvMemberPhotoDto;
import com.bengaluru.vsv.model.VsvMemberContact;
import com.bengaluru.vsv.model.VsvMemberMaster;
import com.bengaluru.vsv.model.VsvMemberPhoto;

import java.util.Base64;

public class VsvMemberMapper {

    // Convert entity to DTO
    public static VsvMemberDto toDto(VsvMemberMaster entity) {
        if (entity == null) return null;

        VsvMemberDto dto = new VsvMemberDto();
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
        dto.setContact(VsvMemberContactMapper.toDto(entity.getContact()));
        if (entity.getMemberPhoto() != null) {
            dto.setMemberPhoto(toDto(entity.getMemberPhoto()));
        }
        dto.setMemberHoroscope(entity.getMemberHoroscope());
        dto.setMemberOccupation(entity.getMemberOccupation());
        return dto;
    }

    public static VsvMemberPhotoDto toDto(VsvMemberPhoto entity) {
        if (entity == null) return null;

        VsvMemberPhotoDto dto = new VsvMemberPhotoDto();
        dto.setVsvId(entity.getVsvId());
        dto.setIndividualPhoto(entity.getIndividualPhoto());
        dto.setFamilyPhoto(entity.getFamilyPhoto());
        return dto;
    }

    // Convert DTO to entity
    public static VsvMemberMaster toEntity(VsvMemberDto dto) {
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
        VsvMemberContact contact = VsvMemberContactMapper.toEntity(dto.getContact());
        if (contact != null) {
            contact.setMember(entity); // important for bidirectional relation
            entity.setContact(contact);
        }
        if (dto.getMemberPhoto() != null) {
            entity.setMemberPhoto(toEntity(dto.getMemberPhoto()));
        }
        entity.setMemberHoroscope(dto.getMemberHoroscope());
        entity.setMemberOccupation(dto.getMemberOccupation());
        return entity;
    }

    public static VsvMemberPhoto toEntity(VsvMemberPhotoDto dto) {
        if (dto == null) return null;

        VsvMemberPhoto entity = new VsvMemberPhoto();
        entity.setVsvId(dto.getVsvId());
        entity.setIndividualPhoto(dto.getIndividualPhoto());
        entity.setFamilyPhoto(dto.getFamilyPhoto());
        return entity;
    }
}


