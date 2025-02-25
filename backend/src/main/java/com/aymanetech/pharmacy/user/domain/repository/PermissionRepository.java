package com.aymanetech.pharmacy.user.domain.repository;

import com.aymanetech.pharmacy.user.domain.entity.Permission;
import com.aymanetech.pharmacy.user.domain.vo.PermissionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, PermissionId> {
}