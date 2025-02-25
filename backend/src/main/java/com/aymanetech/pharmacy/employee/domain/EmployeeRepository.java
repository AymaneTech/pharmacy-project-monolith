package com.aymanetech.pharmacy.employee.domain;

import com.aymanetech.pharmacy.user.domain.vo.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, UserId> {
}