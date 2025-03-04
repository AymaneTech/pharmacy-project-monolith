package com.aymanetech.event.event.domain.repository;

import com.aymanetech.event.event.domain.entity.Category;
import com.aymanetech.event.event.domain.vo.CategoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, CategoryId> {
}
