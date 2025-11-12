package com.bengaluru.vsv.controller;

import com.bengaluru.vsv.dto.VsvMemberDto;
import com.bengaluru.vsv.model.VsvMemberMaster;
import com.bengaluru.vsv.service.VsvMemberFamilyTreeService;
import com.bengaluru.vsv.service.VsvMemberService;
import com.bengaluru.vsv.utils.mapper.VsvMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vsv-member")
public class VsvMemberController {
    @Autowired
    private VsvMemberService vsvMemberService;

    @Autowired
    private VsvMemberFamilyTreeService vsvMemberFamilyTreeService;

    @Autowired
    private VsvMemberMapper vsvMemberMapper;

    @GetMapping
    public List<VsvMemberDto> getAllMembers() {
        return vsvMemberService.findAllMembers();
    }

    // Get member by ID
    @GetMapping("/{id}")
    public ResponseEntity<VsvMemberDto> getMemberById(@PathVariable Integer id) {
        return vsvMemberService.findById(id);
    }

    @GetMapping("/family/{id}")
    public ResponseEntity<?> getFamilyMembersById(@PathVariable Integer id) {
        return vsvMemberFamilyTreeService.getFamilyTreeByMemberId(id);
    }

    // Create new member
    @PostMapping
    public ResponseEntity<VsvMemberMaster> createMember(@RequestBody VsvMemberMaster newMember) {
        VsvMemberMaster saved = vsvMemberService.save(newMember);
        return ResponseEntity.ok(saved);
    }

    // Update member
    @PutMapping("/{id}")
    public ResponseEntity<VsvMemberDto> updateMember(@PathVariable Integer id,
                                                     @RequestBody VsvMemberDto updatedDto) {
        Optional<VsvMemberMaster> existingOpt = vsvMemberService.findByIdEntity(id);
        if (existingOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        VsvMemberMaster updatedEntity = vsvMemberMapper.toEntity(updatedDto);
        updatedEntity.setVsvId(id);

        // Optional: preserve fields from existing entity
        // e.g. updatedEntity.setCreatedDateTime(existingOpt.get().getCreatedDateTime());

        VsvMemberMaster saved = vsvMemberService.save(updatedEntity);
        VsvMemberDto savedDto = vsvMemberMapper.toDto(saved);
        return ResponseEntity.ok(savedDto);
    }

    // Delete member
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Integer id) {
        if (!vsvMemberService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        vsvMemberService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<VsvMemberDto> searchByName(@RequestParam String name) {
        return vsvMemberService.searchByName(name);
    }
}
