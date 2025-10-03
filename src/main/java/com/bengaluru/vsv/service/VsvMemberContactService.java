package com.bengaluru.vsv.service;

import com.bengaluru.vsv.dto.VsvMemberContactDto;
import com.bengaluru.vsv.model.VsvMemberContact;
import com.bengaluru.vsv.repository.VsvMemberContactRepo;
import com.bengaluru.vsv.utils.mapper.VsvMemberContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VsvMemberContactService {
    @Autowired
    private VsvMemberContactRepo contactRepo;

    public ResponseEntity<VsvMemberContactDto> findById(Integer id) {
        Optional<VsvMemberContact> contactOpt = contactRepo.findById(id);
        return contactOpt.map(contact -> ResponseEntity.ok(VsvMemberContactMapper.toDto(contact)))
                .orElse(ResponseEntity.notFound().build());
    }

    public VsvMemberContactDto save(VsvMemberContactDto contactDTO) {
        VsvMemberContact contact = VsvMemberContactMapper.toEntity(contactDTO);
        VsvMemberContact saved = contactRepo.save(contact);
        return VsvMemberContactMapper.toDto(saved);
    }

    public boolean existsById(Integer id) {
        return contactRepo.existsById(id);
    }

    public void deleteById(Integer id) {
        contactRepo.deleteById(id);
    }
}
