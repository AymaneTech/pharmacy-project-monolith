package com.aymanetech.pharmacy.user.domain.vo;

import jakarta.persistence.Column;

public record PermissionId(@Column(name = "id") Long value) {
    public static PermissionId of(Integer id) {
        return new PermissionId(id.longValue());
    }

    public static PermissionId of(Long id) {
        return new PermissionId(id);
    }
}
