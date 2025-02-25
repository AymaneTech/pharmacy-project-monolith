package com.aymanetech.pharmacy.reference.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "phar_reference_medicines")

@Getter
@Setter
@NoArgsConstructor
public class ReferenceMedicine {

    @EmbeddedId
    private ReferenceMedicineId id;

    private String code;

    private String commercialName;

    private String genericName;

    private String dosage;

    @Enumerated(EnumType.STRING)
    private DosageUnit dosageUnit;

    private String form;

    @Enumerated(EnumType.STRING)
    private Packaging packaging;

    private BigDecimal publicPrice;

    private BigDecimal hospitalPrice;

    private BigDecimal basePrice;

    private String category;

    private String reimbursementRate;
}
