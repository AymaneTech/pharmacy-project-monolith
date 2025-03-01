package com.aymanetech.event.user.application.service;

import com.aymanetech.event.user.domain.vo.PermissionId;
import com.aymanetech.event.user.domain.vo.RoleId;

import java.util.List;

public interface RolePermissionService {

    void assignPermissionToRole(RoleId roleId, PermissionId permissionId);

    void assignPermissionsToRole(RoleId roleId, List<PermissionId> permissionIds);
}
