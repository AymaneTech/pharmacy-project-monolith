package com.aymanetech.pharmacy.user.domain.vo;

import jakarta.persistence.Column;

public record RoleId(@Column(name = "id") Long value) {
    public static RoleId of(Long id){
        return new RoleId(id);
    }
}
