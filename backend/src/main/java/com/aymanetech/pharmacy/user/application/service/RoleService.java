package com.aymanetech.pharmacy.user.application.service;

import com.aymanetech.pharmacy.user.application.dto.request.RoleRequestDto;
import com.aymanetech.pharmacy.user.application.dto.response.RoleResponseDto;
import com.aymanetech.pharmacy.user.domain.vo.PermissionId;
import com.aymanetech.pharmacy.user.domain.vo.RoleId;

import java.util.List;

public interface RoleService {

    RoleResponseDto createNewRole(RoleRequestDto request);

    RoleRequestDto findRoleById(Long id);

    List<RoleRequestDto> findAllRoles();

    RoleRequestDto updateRole(Long id, RoleRequestDto request);

    void deleteRole(Long id);

    void assignPermissionToRole(RoleId roleId, PermissionId permissionId);

    void assignPermissionsToRole(RoleId roleId, List<PermissionId> permissionIds);
}