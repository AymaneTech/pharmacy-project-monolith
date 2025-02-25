package com.aymanetech.pharmacy.pharmacy.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "phar_pharmacies")

@Getter
@Setter
@NoArgsConstructor
public class Pharmacy {

    @EmbeddedId
    private PharmacyId id;

    private String name;

    private String city;

    private String country;

    private String zip;

    private String extraAddress;
}
