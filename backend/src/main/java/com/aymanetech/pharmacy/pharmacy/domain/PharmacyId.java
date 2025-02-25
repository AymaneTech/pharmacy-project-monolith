package com.aymanetech.pharmacy.pharmacy.domain;

import jakarta.persistence.Column;

public record PharmacyId(@Column(name = "id") Long value) {
}
