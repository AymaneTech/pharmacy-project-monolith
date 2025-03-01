package com.aymanetech.event.user.domain.entity;

import com.aymanetech.event.user.domain.vo.PermissionId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "phar_permissions")

@Getter
@Setter
@NoArgsConstructor
public class Permission implements Serializable {

    @EmbeddedId
    private PermissionId id;

    private String name;

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles = new HashSet<>();

    public Permission(@NotBlank String name) {
        this.name = name;
    }

    public void assignRole(Role role) {
        role.assignPermission(this);
        roles.add(role);
    }

    @Override
    public boolean equals(Object object) {
        if (object != null && getClass() != object.getClass()) return false;
        Permission permission = (Permission) object;
        return Objects.equals(name, permission.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
