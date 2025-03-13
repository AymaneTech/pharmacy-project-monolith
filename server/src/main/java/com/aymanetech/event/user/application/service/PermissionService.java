package com.aymanetech.event.user.application.service;

import com.aymanetech.event.user.application.dto.request.PermissionRequestDto;
import com.aymanetech.event.user.application.dto.response.PermissionResponseDto;
import com.aymanetech.event.user.domain.vo.PermissionId;

import java.util.List;

public interface PermissionService {

    PermissionResponseDto createNewPermission(PermissionRequestDto request);

    PermissionResponseDto findPermissionById(PermissionId id);

    List<PermissionResponseDto> findAllPermissions();

    PermissionResponseDto updatePermission(PermissionId id, PermissionRequestDto request);

    void deletePermission(PermissionId id);
}