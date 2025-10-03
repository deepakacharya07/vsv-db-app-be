package com.bengaluru.vsv.dto;

import lombok.Data;

@Data
public class CommitteDto {
    private Integer committeId;
    private String committeName;
    private String registrationNo;
    private String address;
    private String city;
    private String state;
    private Long pin;
    private String bankIFSC;
    private String contactNumber;
}
