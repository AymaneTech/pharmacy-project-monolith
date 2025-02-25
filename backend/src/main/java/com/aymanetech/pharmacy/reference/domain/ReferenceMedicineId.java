package com.aymanetech.pharmacy.reference.domain;

import jakarta.persistence.Column;

public record ReferenceMedicineId(@Column(name = "id") Long value) {
}
