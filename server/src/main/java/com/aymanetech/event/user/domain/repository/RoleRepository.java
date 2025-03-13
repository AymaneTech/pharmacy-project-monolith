package com.aymanetech.event.user.domain.repository;

import com.aymanetech.event.user.domain.entity.Role;
import com.aymanetech.event.user.domain.vo.RoleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, RoleId> {
}