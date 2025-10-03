package com.bengaluru.vsv.service;

import com.bengaluru.vsv.dto.VsvMemberDto;
import com.bengaluru.vsv.model.VsvMemberMaster;
import com.bengaluru.vsv.repository.VsvMemberRepo;
import com.bengaluru.vsv.utils.mapper.VsvMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VsvMemberService {
    @Autowired
    private VsvMemberRepo vsvMemberRepo;

    public List<VsvMemberDto> findAllMembers() {
        return vsvMemberRepo.findAll()
                .stream()
                .map(VsvMemberMapper::toDto)
                .collect(Collectors.toList());
    }

    public ResponseEntity<VsvMemberDto> findById(Integer id) {
        return vsvMemberRepo.findById(id)
                .map(member -> ResponseEntity.ok(VsvMemberMapper.toDto(member)))
                .orElse(ResponseEntity.notFound().build());
    }

    public VsvMemberMaster save(VsvMemberMaster updatedMember) {
        return vsvMemberRepo.save(updatedMember);
    }

    public boolean existsById(Integer id) {
        return vsvMemberRepo.existsById(id);
    }

    public void deleteById(Integer id) {
        vsvMemberRepo.deleteById(id);
    }

    public Optional<VsvMemberMaster> findByIdEntity(Integer id) {
        return vsvMemberRepo.findById(id);
    }

    public List<VsvMemberDto> searchByName(String name) {
        return vsvMemberRepo.searchByName(name)
                .stream()
                .map(VsvMemberMapper::toDto)
                .collect(Collectors.toList());
    }
}
