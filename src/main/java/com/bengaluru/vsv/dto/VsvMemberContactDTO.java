package com.bengaluru.vsv.dto;

import lombok.Data;

@Data
public class VsvMemberContactDTO {
    private Integer vsvId;
    private String presentAddress;
    private Integer presentPin;
    private String presentGoogleMapLocn;
    private String permanentAddress;
    private Integer permanentPin;
    private String permanentGoogleMapLocn;
    private String whatsappNo;
    private String landLineNo;
    private String emailId;
}
