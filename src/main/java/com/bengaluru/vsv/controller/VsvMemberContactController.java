package com.bengaluru.vsv.controller;

import com.bengaluru.vsv.dto.VsvMemberContactDTO;
import com.bengaluru.vsv.service.VsvMemberContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vsv-member-contact")
public class VsvMemberContactController {

    @Autowired
    private VsvMemberContactService contactService;

    // Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<VsvMemberContactDTO> getContactById(@PathVariable Integer id) {
        return contactService.findById(id);
    }

    // Create or update
    @PostMapping
    public ResponseEntity<VsvMemberContactDTO> saveOrUpdate(@RequestBody VsvMemberContactDTO contactDTO) {
        VsvMemberContactDTO saved = contactService.save(contactDTO);
        return ResponseEntity.ok(saved);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Integer id) {
        if (!contactService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        contactService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
