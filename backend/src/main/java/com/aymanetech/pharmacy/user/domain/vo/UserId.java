package com.aymanetech.pharmacy.user.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record UserId(@Column(name = "id") Long value) {
}
