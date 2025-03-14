package com.aymanetech.event.user.application.service;

import com.aymanetech.event.user.application.dto.request.RoleRequestDto;
import com.aymanetech.event.user.application.dto.response.RoleResponseDto;
import com.aymanetech.event.user.domain.entity.Role;
import com.aymanetech.event.user.domain.vo.RoleId;

import java.util.List;

public interface RoleService {

    RoleResponseDto createNewRole(RoleRequestDto request);

    RoleResponseDto findRoleById(RoleId id);

    List<RoleResponseDto> findAllRoles();

    RoleResponseDto updateRole(RoleId id, RoleRequestDto request);

    void deleteRole(RoleId id);

    Role findRoleEntityById(RoleId id);

    Role findRoleByName(String role);
}