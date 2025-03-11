package com.aymanetech.event.event.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;

public record EventId(@Column(name = "id") @GeneratedValue Long value) {
    public static EventId of(Long id){
        return new EventId(id);
    }
}
