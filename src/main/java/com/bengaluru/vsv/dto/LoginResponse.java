package com.bengaluru.vsv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String authToken;
    private Integer vsvId;
    private List<RoleDto> userRole;
    //private VsvMemberDto member;
}
