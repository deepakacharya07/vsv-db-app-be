package com.bengaluru.vsv.controller;

import com.bengaluru.vsv.service.VsvCommitteeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vsv-committee")
public class VsvCommitteeDetailsController {

    @Autowired
    private VsvCommitteeDetailsService vsvCommitteeDetailsService;
    @GetMapping("")
    public ResponseEntity<?> getAllCommitteeDetails() {
        return vsvCommitteeDetailsService.getCommitteeDetails();
    }
}
