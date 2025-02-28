package com.aymanetech.pharmacy.user.application.service.impl;

import com.aymanetech.pharmacy.common.application.service.ApplicationService;
import com.aymanetech.pharmacy.user.application.dto.request.UserLoginRequestDto;
import com.aymanetech.pharmacy.user.application.dto.request.UserRegistrationRequestDto;
import com.aymanetech.pharmacy.user.application.dto.request.UserRequestDto;
import com.aymanetech.pharmacy.user.application.dto.response.UserResponseDto;
import com.aymanetech.pharmacy.user.application.mapper.UserMapper;
import com.aymanetech.pharmacy.user.application.service.RoleService;
import com.aymanetech.pharmacy.user.application.service.UserService;
import com.aymanetech.pharmacy.user.domain.entity.User;
import com.aymanetech.pharmacy.user.domain.repository.UserRepository;
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
    public UserRequestDto registerNewUser(UserRegistrationRequestDto request) {
        User user = mapper.toEntity(request)
                .setPassword("hashedPassword") // todo: hash password
                .setRole(null);
        return null;
    }

    @Override
    public UserResponseDto login(UserLoginRequestDto request) {
        return null;
    }

    @Override
    public UserResponseDto findUserById(UserId id) {
        return null;
    }

    @Override
    public List<UserResponseDto> findAllUsers() {
        return List.of();
    }

    @Override
    public UserResponseDto updateUser(UserId id, UserRequestDto request) {
        return null;
    }

    @Override
    public void deleteUser(UserId id) {

    }
}
