package com.aymanetech.pharmacy.user.domain.vo;

import jakarta.persistence.Column;

public record PermissionId(@Column(name = "id") Long value) {
}
