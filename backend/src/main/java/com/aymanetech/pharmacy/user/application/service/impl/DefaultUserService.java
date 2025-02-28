package com.aymanetech.pharmacy.user.application.service.impl;

import com.aymanetech.pharmacy.common.application.service.ApplicationService;
import com.aymanetech.pharmacy.common.exception.ResourceNotFoundException;
import com.aymanetech.pharmacy.user.application.dto.request.UserLoginRequestDto;
import com.aymanetech.pharmacy.user.application.dto.request.UserRegistrationRequestDto;
import com.aymanetech.pharmacy.user.application.dto.request.UserRequestDto;
import com.aymanetech.pharmacy.user.application.dto.response.UserResponseDto;
import com.aymanetech.pharmacy.user.application.mapper.UserMapper;
import com.aymanetech.pharmacy.user.application.service.RoleService;
import com.aymanetech.pharmacy.user.application.service.UserService;
import com.aymanetech.pharmacy.user.domain.entity.Role;
import com.aymanetech.pharmacy.user.domain.entity.User;
import com.aymanetech.pharmacy.user.domain.repository.UserRepository;
import com.aymanetech.pharmacy.user.domain.vo.RoleId;
import com.aymanetech.pharmacy.user.domain.vo.UserId;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationService
@RequiredArgsConstructor
public class DefaultUserService implements UserService {
    private final UserRepository repository;
    private final RoleService roleService;
    private final UserMapper mapper;

    @Override
    public UserResponseDto registerNewUser(UserRegistrationRequestDto request) {
        Role defaultRole = roleService.findRoleEntityById(RoleId.of(1L));

        User user = mapper.toEntity(request)
                .setPassword("hash password")
                .setRole(defaultRole);

        User savedUser = repository.save(user);
        return mapper.toResponseDto(savedUser);
    }

    @Override
    public UserResponseDto login(UserLoginRequestDto request) {
        User user = repository.findByEmail(request.email())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("user with email %s not found", request.email())));
        // todo handle registration properly

        return mapper.toResponseDto(user);
    }

    @Override
    public UserResponseDto findUserById(UserId id) {
        return repository.findById(id)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new ResourceNotFoundException(id.value()));
    }

    @Override
    public List<UserResponseDto> findAllUsers() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @Override
    public UserResponseDto updateUser(UserId id, UserRequestDto request) {
        User user = findUserEntityById(id);
        mapper.updateEntity(user, request);

        if (request.roleId() != null) {
            Role role = roleService.findRoleEntityById(RoleId.of(request.roleId()));
            user.setRole(role);
        }

        User updatedUser = repository.save(user);
        return mapper.toResponseDto(updatedUser);
    }

    @Override
    public void deleteUser(UserId id) {
        if (!repository.existsById(id))
            throw new ResourceNotFoundException(id.value());
        repository.deleteById(id);
    }

    private User findUserEntityById(UserId id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id.value()));
    }
}