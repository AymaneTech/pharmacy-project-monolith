package com.aymanetech.pharmacy.user.application.service.impl;

import com.aymanetech.pharmacy.common.application.service.ApplicationService;
import com.aymanetech.pharmacy.common.exception.ResourceNotFoundException;
import com.aymanetech.pharmacy.user.application.dto.request.PermissionRequestDto;
import com.aymanetech.pharmacy.user.application.dto.response.PermissionResponseDto;
import com.aymanetech.pharmacy.user.application.mapper.PermissionMapper;
import com.aymanetech.pharmacy.user.application.service.PermissionService;
import com.aymanetech.pharmacy.user.domain.entity.Permission;
import com.aymanetech.pharmacy.user.domain.repository.PermissionRepository;
import com.aymanetech.pharmacy.user.domain.vo.PermissionId;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationService
@RequiredArgsConstructor
public class DefaultPermissionService implements PermissionService {
    private final PermissionRepository repository;
    private final PermissionMapper mapper;

    @Override
    public PermissionResponseDto createNewPermission(final PermissionRequestDto request) {
        final Permission permission = mapper.toEntity(request);
        final Permission savedPermission = repository.save(permission);
        return mapper.toResponseDto(savedPermission);
    }

    @Override
    public PermissionResponseDto findPermissionById(final PermissionId id) {
        return repository.findById(id)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new ResourceNotFoundException(id.value()));
    }

    @Override
    public List<PermissionResponseDto> findAllPermissions() {
        return repository.findAll().stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @Override
    public PermissionResponseDto updatePermission(final PermissionId id, final PermissionRequestDto request) {
        final Permission permission = findPermissionEntityById(id);
        mapper.updateEntity(permission, request);
        return mapper.toResponseDto(permission);
    }

    @Override
    public void deletePermission(final PermissionId id) {
        if (!repository.existsById(id)) throw new ResourceNotFoundException(id.value());
        repository.deleteById(id);
    }

    private Permission findPermissionEntityById(final PermissionId id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id.value()));
    }
}
