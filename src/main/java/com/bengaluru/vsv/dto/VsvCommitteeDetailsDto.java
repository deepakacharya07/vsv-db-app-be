package com.bengaluru.vsv.dto;

import com.bengaluru.vsv.model.committee.CommitteeDesignation;
import com.bengaluru.vsv.model.committee.CommitteeHeader;
import com.bengaluru.vsv.model.committee.VsvCommitteeDetails;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VsvCommitteeDetailsDto {
    private int committeId;
    private int committeLocId;
    private int comDesgnId;
    private Integer vsvId;
    private String memberName;
    private Date startDate;
    private Date endDate;
    private String gender;
    private CommitteeDesignation committeeDesignation;
    private CommitteeHeader committeeHeader;
}
