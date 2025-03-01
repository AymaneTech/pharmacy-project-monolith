package com.aymanetech.event.user.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;

public record PermissionId(@Column(name = "id") @GeneratedValue Long value) {
    public static PermissionId of(Integer id) {
        return new PermissionId(id.longValue());
    }

    public static PermissionId of(Long id) {
        return new PermissionId(id);
    }
}
