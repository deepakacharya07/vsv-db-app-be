package com.bengaluru.vsv.controller;

import com.bengaluru.vsv.repository.VsvMemberPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vsv-photo")
public class VsvMemberPhotoController {

    @Autowired
    private VsvMemberPhotoRepository photoRepository;

    @GetMapping(value = "/{vsvId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getIndividualPhoto(@PathVariable Integer vsvId) {
        var photo = photoRepository.findById(vsvId)
                .orElseThrow(() -> new RuntimeException("Photo not found"));

        byte[] image = photo.getIndividualPhotoBlob();
        if (image == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }
}
