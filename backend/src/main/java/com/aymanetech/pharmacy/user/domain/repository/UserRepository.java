package com.aymanetech.pharmacy.user.domain.repository;

import com.aymanetech.pharmacy.user.domain.entity.User;
import com.aymanetech.pharmacy.user.domain.vo.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UserId> {
}