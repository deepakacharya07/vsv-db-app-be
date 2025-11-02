package com.bengaluru.vsv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilyMemberDto {
    private int relationVsvId;
    private String relationName;
    private String relationDescription;
    private int level;
    private int order;
}
