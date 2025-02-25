package com.aymanetech.pharmacy.reference.domain.vo;

import jakarta.persistence.Column;

public record ReferenceMedicineId(@Column(name = "id") Long value) {
}
