package com.bengaluru.vsv.utils.mapper;

import com.bengaluru.vsv.dto.RoleDto;
import com.bengaluru.vsv.dto.UserDto;
import com.bengaluru.vsv.model.Role;
import com.bengaluru.vsv.model.Users;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto toDTO(Users user) {
        if (user == null) return null;

        return new UserDto(
                user.getId(),
                user.getVsvId(),
                user.getUsername(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getStatus(), // assuming enum
                toRoleDTOList(user.getRoles())
        );
    }

    public static List<RoleDto> toRoleDTOList(Set<Role> roles) {
        if (roles == null) return null;

        return roles.stream()
                .map(role -> new RoleDto(role.getId(), role.getRoleName()))
                .collect(Collectors.toList());
    }

    // Optional: if you ever need reverse mapping
    public static Role toEntity(RoleDto dto) {
        if (dto == null) return null;

        Role role = new Role();
        role.setId(dto.getId());
        role.setRoleName(dto.getRoleName());
        return role;
    }
}
