package com.aymanetech.pharmacy.user.application.service;

import com.aymanetech.pharmacy.user.domain.vo.PermissionId;
import com.aymanetech.pharmacy.user.domain.vo.RoleId;

import java.util.List;

public interface RolePermissionService {

    void assignPermissionToRole(RoleId roleId, PermissionId permissionId);

    void assignPermissionsToRole(RoleId roleId, List<PermissionId> permissionIds);
}
