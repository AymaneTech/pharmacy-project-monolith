package com.aymanetech.event.common.repository;

import java.util.Optional;

public interface SlugRepository<T> {

    boolean existsBySlug(String slug);

    Optional<T> findBySlug(String slug);
}
