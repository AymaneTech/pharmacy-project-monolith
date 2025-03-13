package com.aymanetech.event.common.application.service;

import com.aymanetech.event.common.repository.SlugRepository;

public interface SlugService {
    <T> void setRepository(SlugRepository<T> repository);

    String generateUniqueSlug(String source);
}
