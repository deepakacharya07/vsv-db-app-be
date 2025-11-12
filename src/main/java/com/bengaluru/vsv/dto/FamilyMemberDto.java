package com.bengaluru.vsv.dto;

import lombok.Data;

@Data
public class FamilyMemberDto {
    private int relationVsvId;
    private String relationName;
    private String relationDescription;
    private int level;
    private int order;
    private String gender;
    private String individualPhotoBaseUrl;
}
