package com.aymanetech.pharmacy.employee.domain;

import com.aymanetech.pharmacy.pharmacy.domain.Pharmacy;
import com.aymanetech.pharmacy.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "phar_employees")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("Employee")
@Getter
@Setter
@NoArgsConstructor
public class Employee extends User {

    private LocalDate hiringDate;

    private LocalDate resignationDate;

    private String position;

    private BigDecimal salary;

    @ManyToOne
    private Pharmacy pharmacy;
}
