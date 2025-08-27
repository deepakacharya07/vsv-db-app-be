package com.bengaluru.vsv.dto;

import lombok.Data;
import java.util.Date;

@Data
public class VsvMemberDTO {
    private Integer vsvId;
    private String name;
    private String gender;
    private Date dob;
    private Integer age;
    private String birthPlace;
    private String nativePlace;
    private Integer maritalStatus;
    private String mobileNo;
    private Integer bloodGroup;
    private Integer qualificationId;
    private Boolean isStudent;
    private String courseDetail;
    private Integer memberStatus;

    //private CommitteDTO committe;  // Simplified nested object
    private VsvMemberContactDTO contact;
}

