package com.bengaluru.vsv.dto;

import lombok.Data;

@Data
public class VsvMemberPhotoDto {
    private Integer vsvId;
    private String individualPhotoUrl;
    private String familyPhotoUrl;
    private String individualPhotoBaseUrl;
    private String familyPhotoBaseUrl;
}
