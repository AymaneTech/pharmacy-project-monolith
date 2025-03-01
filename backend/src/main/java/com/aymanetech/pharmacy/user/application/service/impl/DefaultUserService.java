package com.aymanetech.pharmacy.user.application.service.impl;

import com.aymanetech.pharmacy.common.application.service.ApplicationService;
import com.aymanetech.pharmacy.common.exception.ResourceNotFoundException;
import com.aymanetech.pharmacy.security.domain.TokenService;
import com.aymanetech.pharmacy.user.application.dto.request.UserLoginRequestDto;
import com.aymanetech.pharmacy.user.application.dto.request.UserRegistrationRequestDto;
import com.aymanetech.pharmacy.user.application.dto.request.UserRequestDto;
import com.aymanetech.pharmacy.user.application.dto.response.AuthenticationResponseDto;
import com.aymanetech.pharmacy.user.application.dto.response.UserResponseDto;
import com.aymanetech.pharmacy.user.application.mapper.UserMapper;
import com.aymanetech.pharmacy.user.application.service.RoleService;
import com.aymanetech.pharmacy.user.application.service.UserService;
import com.aymanetech.pharmacy.user.domain.entity.User;
import com.aymanetech.pharmacy.user.domain.repository.UserRepository;
import com.aymanetech.pharmacy.user.domain.vo.RoleId;
import com.aymanetech.pharmacy.user.domain.vo.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@ApplicationService
@RequiredArgsConstructor
public class DefaultUserService implements UserService {
    private final UserRepository repository;
    private final RoleService roleService;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Override
    public UserResponseDto registerNewUser(UserRegistrationRequestDto request) {
        var defaultRole = roleService.findRoleEntityById(RoleId.of(1L));

        var user = mapper.toEntity(request)
                .setPassword(passwordEncoder.encode(request.password()))
                .setRole(defaultRole);

        var savedUser = repository.save(user);
        return mapper.toResponseDto(savedUser);
    }

    @Override
    public AuthenticationResponseDto login(UserLoginRequestDto request) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        var token = tokenService.generateToken(authentication);
        return new AuthenticationResponseDto(token);
    }

    @Override
    public UserResponseDto findUserById(UserId id) {
        return repository.findById(id)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new ResourceNotFoundException("User", id.value()));
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
        // todo: use another dto for this to ignore password here
        var user = findUserEntityById(id);
        var role = roleService.findRoleEntityById(RoleId.of(request.roleId()));

        mapper.updateEntity(user, request);
        user.setRole(role);

        var updatedUser = repository.save(user);
        return mapper.toResponseDto(updatedUser);
    }

    @Override
    public void deleteUser(UserId id) {
        if (!repository.existsById(id))
            throw new ResourceNotFoundException("User", id.value());
        repository.deleteById(id);
    }

    private User findUserEntityById(UserId id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role", id.value()));
    }
}