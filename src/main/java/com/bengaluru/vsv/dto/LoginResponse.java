package com.bengaluru.vsv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String authToken;
    private VsvMemberDTO member;
}
