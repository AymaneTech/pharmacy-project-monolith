package com.aymanetech.pharmacy.reference.domain;

import com.aymanetech.pharmacy.reference.domain.vo.ReferenceMedicineId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceMedicineRepository extends JpaRepository<ReferenceMedicine, ReferenceMedicineId> {
}