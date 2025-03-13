package com.aymanetech.event.user.domain.entity;

import com.aymanetech.event.user.domain.vo.RoleId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "roles")

@Getter
@Setter
@NoArgsConstructor
public class Role implements Serializable {

    @EmbeddedId
    private RoleId id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "permission_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Permission> permissions = new HashSet<>();

    public void assignPermission(Permission permission) {
        permission.assignRole(this);
        permissions.add(permission);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Role role = (Role) object;
        return Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
