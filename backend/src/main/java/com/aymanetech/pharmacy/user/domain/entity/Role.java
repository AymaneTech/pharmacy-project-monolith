package com.aymanetech.pharmacy.user.domain.entity;

import com.aymanetech.pharmacy.user.domain.vo.RoleId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "phar_roles")

@Getter
@Setter
@NoArgsConstructor
public class Role {

    @EmbeddedId
    private RoleId id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "phar_role_permissions",
            joinColumns = @JoinColumn(name = "permission_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Permission> permissions;
}
