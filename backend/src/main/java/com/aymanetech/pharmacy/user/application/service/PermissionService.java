package com.aymanetech.pharmacy.user.application.service;

import com.aymanetech.pharmacy.user.application.dto.request.PermissionRequestDto;
import com.aymanetech.pharmacy.user.application.dto.response.PermissionResponseDto;

import java.util.List;

public interface PermissionService {

    PermissionResponseDto createNewPermission(PermissionRequestDto request);

    PermissionRequestDto findPermissionById(Long id);

    List<PermissionRequestDto> findAllPermissions();

    PermissionRequestDto updatePermission(Long id, PermissionRequestDto request);

    void deletePermission(Long id);
}