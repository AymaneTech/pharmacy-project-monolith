package com.aymanetech.pharmacy.user.domain.entity;

import com.aymanetech.pharmacy.user.domain.vo.PermissionId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "phar_permissions")

@Getter
@Setter
@NoArgsConstructor
public class Permission {

    @EmbeddedId
    private PermissionId id;

    private String name;

    @ManyToMany(mappedBy = "permissions")
    private List<Role> roles;
}
