package com.aymanetech.pharmacy.user.application.service;

import com.aymanetech.pharmacy.user.application.dto.request.RoleRequestDto;
import com.aymanetech.pharmacy.user.application.dto.response.RoleResponseDto;
import com.aymanetech.pharmacy.user.domain.entity.Role;
import com.aymanetech.pharmacy.user.domain.vo.RoleId;

import java.util.List;

public interface RoleService {

    RoleResponseDto createNewRole(RoleRequestDto request);

    RoleResponseDto findRoleById(RoleId id);

    List<RoleResponseDto> findAllRoles();

    RoleResponseDto updateRole(RoleId id, RoleRequestDto request);

    void deleteRole(RoleId id);

    Role findRoleEntityById(RoleId id);
}