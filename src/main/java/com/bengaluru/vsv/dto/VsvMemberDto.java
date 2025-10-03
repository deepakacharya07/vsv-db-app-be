package com.bengaluru.vsv.dto;

import com.bengaluru.vsv.model.VsvMemberHoroscope;
import com.bengaluru.vsv.model.VsvMemberOccupation;
import lombok.Data;
import java.util.Date;

@Data
public class VsvMemberDto {
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
    private VsvMemberContactDto contact;

    private VsvMemberPhotoDto memberPhoto;

    private VsvMemberHoroscope memberHoroscope;

    private VsvMemberOccupation memberOccupation;
}

