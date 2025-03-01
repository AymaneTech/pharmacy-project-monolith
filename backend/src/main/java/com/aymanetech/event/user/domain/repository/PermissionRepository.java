package com.aymanetech.event.user.domain.repository;

import com.aymanetech.event.user.domain.entity.Permission;
import com.aymanetech.event.user.domain.vo.PermissionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, PermissionId> {
}