package com.bengaluru.vsv.dto;

import com.bengaluru.vsv.utils.types.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private Integer vsvId;
    private String username;
    private String email;
    private String phoneNumber;
    private Status status; // enum as string
    private List<RoleDto> roles;
}
