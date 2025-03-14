package com.aymanetech.event.event.domain.entity;

import com.aymanetech.event.event.domain.vo.CategoryId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categories")

@Getter
@Setter
@NoArgsConstructor
public class Category {

    @EmbeddedId
    private CategoryId id;

    private String name;

    private String description;

    private String slug;

    @OneToMany(mappedBy = "category")
    private List<Event> events;
}
