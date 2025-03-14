package com.aymanetech.event.user.domain.repository;

import com.aymanetech.event.user.domain.entity.User;
import com.aymanetech.event.user.domain.vo.UserId;
import com.aymanetech.event.user.domain.vo.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UserId> {
    Optional<User> findByEmail(String email);

    @Query("SELECT EXISTS (SELECT o FROM User AS o WHERE o.id = :id AND o.role.name = :roleName AND o.status = :status)")
    boolean existsByIdAndRoleNameAndStatus(UserId id, String roleName, UserStatus status);


    @Query("SELECT o FROM User AS o WHERE o.id = :id AND o.role.name = :roleName AND o.status = :status")
    Optional<User> findByIdAndRoleNameAndStatus(UserId id, String roleName, UserStatus status);
}