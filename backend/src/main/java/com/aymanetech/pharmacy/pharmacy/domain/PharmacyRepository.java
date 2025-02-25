package com.aymanetech.pharmacy.pharmacy.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, PharmacyId> {
}