package com.aymanetech.pharmacy.user.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;

public record RoleId(@Column(name = "id") @GeneratedValue Long value) {
    public static RoleId of(Long id){
        return new RoleId(id);
    }
}
