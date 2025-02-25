package com.aymanetech.pharmacy.user.domain.repository;

import com.aymanetech.pharmacy.user.domain.entity.Role;
import com.aymanetech.pharmacy.user.domain.vo.RoleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, RoleId> {
}