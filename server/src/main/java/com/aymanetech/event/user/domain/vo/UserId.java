package com.aymanetech.event.user.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;

@Embeddable
public record UserId(@Column(name = "id") @GeneratedValue Integer value) {
    public static UserId of(Integer id){
        return new UserId(id);
    }
}
