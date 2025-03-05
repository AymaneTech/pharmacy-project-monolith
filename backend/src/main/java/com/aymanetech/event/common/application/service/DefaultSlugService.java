package com.aymanetech.event.common.application.service;

import com.aymanetech.event.common.repository.SlugRepository;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

@Service
public class DefaultSlugService implements SlugService {
    private static final Pattern NON_LATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

    private SlugRepository repository;

    @Override
    public <T> void setRepository(SlugRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public String generateUniqueSlug(String source) {
        var slug = toSlug(source);
        var uniqueSlug = slug;
        int counter = 1;
        while (repository.existsBySlug(uniqueSlug)) {
            uniqueSlug = slug + "-" + counter++;
        }
        return uniqueSlug;
    }

    public String toSlug(String input) {
        var noWhitespace = WHITESPACE.matcher(input).replaceAll("-");
        var normalized = Normalizer.normalize(noWhitespace, Normalizer.Form.NFD);
        var slug = NON_LATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }
}