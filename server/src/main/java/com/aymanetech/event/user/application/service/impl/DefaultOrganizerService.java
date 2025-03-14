package com.aymanetech.event.user.application.service.impl;

import com.aymanetech.event.common.application.service.ApplicationService;
import com.aymanetech.event.common.exception.ResourceNotFoundException;
import com.aymanetech.event.user.application.service.OrganizerService;
import com.aymanetech.event.user.domain.entity.User;
import com.aymanetech.event.user.domain.repository.UserRepository;
import com.aymanetech.event.user.domain.vo.UserId;
import lombok.RequiredArgsConstructor;

import static com.aymanetech.event.user.domain.vo.UserStatus.ACTIVE;

@ApplicationService
@RequiredArgsConstructor
public class DefaultOrganizerService implements OrganizerService {
    private static final String ORGANIZER_ROLE_NAME = "ROLE_ORGANIZER";

    private final UserRepository repository;

    @Override
    public boolean isOrganizerExists(UserId id) {
        return repository.existsByIdAndRoleNameAndStatus(id, ORGANIZER_ROLE_NAME, ACTIVE);
    }

    @Override
    public User findOrganizerById(UserId id) {
        return repository.findByIdAndRoleNameAndStatus(id, ORGANIZER_ROLE_NAME, ACTIVE)
                .orElseThrow(() -> new ResourceNotFoundException("Organizer", id.value()));
    }
}
