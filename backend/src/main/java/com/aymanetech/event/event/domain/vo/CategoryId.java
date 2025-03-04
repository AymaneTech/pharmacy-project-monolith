package com.aymanetech.event.event.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;

public record CategoryId(@Column(name = "id") @GeneratedValue Long value) {
}
