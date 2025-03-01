package com.aymanetech.pharmacy.user.application.service.impl;

import com.aymanetech.pharmacy.common.application.service.ApplicationService;
import com.aymanetech.pharmacy.common.exception.ResourceNotFoundException;
import com.aymanetech.pharmacy.user.application.dto.request.RoleRequestDto;
import com.aymanetech.pharmacy.user.application.dto.response.RoleResponseDto;
import com.aymanetech.pharmacy.user.application.mapper.RoleMapper;
import com.aymanetech.pharmacy.user.application.service.RoleService;
import com.aymanetech.pharmacy.user.domain.entity.Role;
import com.aymanetech.pharmacy.user.domain.repository.RoleRepository;
import com.aymanetech.pharmacy.user.domain.vo.RoleId;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationService
@RequiredArgsConstructor
public class DefaultRoleService implements RoleService {
    private final RoleRepository repository;
    private final RoleMapper mapper;

    @Override
    public RoleResponseDto createNewRole(RoleRequestDto request) {
        final Role role = mapper.toEntity(request);
        final Role savedRole = repository.save(role);
        return mapper.toResponseDto(savedRole);
    }

    @Override
    public RoleResponseDto findRoleById(RoleId id) {
        return repository.findById(id)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new ResourceNotFoundException("Role", id.value()));
    }

    @Override
    public List<RoleResponseDto> findAllRoles() {
        return repository.findAll()
                .stream().map(mapper::toResponseDto)
                .toList();
    }

    @Override
    public RoleResponseDto updateRole(RoleId id, RoleRequestDto request) {
        final Role role = findRoleEntityById(id);
        mapper.updateEntity(role, request);
        return mapper.toResponseDto(role);
    }

    @Override
    public void deleteRole(RoleId id) {
        if (!repository.existsById(id)) throw new ResourceNotFoundException("Role", id.value());
        repository.deleteById(id);
    }

    @Override
    public Role findRoleEntityById(RoleId id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role", id.value()));
    }
}
