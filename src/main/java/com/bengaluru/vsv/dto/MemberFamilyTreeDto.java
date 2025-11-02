package com.bengaluru.vsv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberFamilyTreeDto {
    private Integer vsvId;
    private List<FamilyMemberDto> familyMembers;
}
