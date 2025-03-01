package com.aymanetech.event.user.application.service.impl;

import com.aymanetech.event.common.application.service.ApplicationService;
import com.aymanetech.event.common.exception.ResourceNotFoundException;
import com.aymanetech.event.user.application.service.RolePermissionService;
import com.aymanetech.event.user.domain.entity.Permission;
import com.aymanetech.event.user.domain.entity.Role;
import com.aymanetech.event.user.domain.repository.PermissionRepository;
import com.aymanetech.event.user.domain.repository.RoleRepository;
import com.aymanetech.event.user.domain.vo.PermissionId;
import com.aymanetech.event.user.domain.vo.RoleId;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationService
@RequiredArgsConstructor
public class DefaultRolePermissionService implements RolePermissionService {
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    @Override
    public void assignPermissionToRole(final RoleId roleId, final PermissionId permissionId) {
        final Role role = findRoleById(roleId);
        final Permission permission = findPermissionById(roleId, permissionId);
        role.assignPermission(permission);
    }

    @Override
    public void assignPermissionsToRole(RoleId roleId, List<PermissionId> permissionIds) {
        final Role role = findRoleById(roleId);
        permissionRepository.findAllById(permissionIds)
                .forEach(role::assignPermission);
    }

    private Permission findPermissionById(RoleId roleId, PermissionId permissionId) {
        return permissionRepository.findById(permissionId)
                .orElseThrow(() -> new ResourceNotFoundException("Role", roleId.value()));
    }

    private Role findRoleById(RoleId roleId) {
        return roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role", roleId.value()));
    }
}
