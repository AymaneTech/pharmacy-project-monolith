package com.aymanetech.pharmacy.user.infrastructure.web;

import com.aymanetech.pharmacy.user.application.dto.request.PermissionRequestDto;
import com.aymanetech.pharmacy.user.application.dto.response.PermissionResponseDto;
import com.aymanetech.pharmacy.user.application.service.PermissionService;
import com.aymanetech.pharmacy.user.domain.vo.PermissionId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/permissions")
@RequiredArgsConstructor
public class PermissionController {
    private final PermissionService permissionService;

    @PostMapping
    public ResponseEntity<PermissionResponseDto> createPermission(@RequestBody PermissionRequestDto dto) {
        PermissionResponseDto permission = permissionService.createNewPermission(dto);
        return ResponseEntity.created(getUri(permission))
                .body(permission);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionResponseDto> getPermissionById(@PathVariable Long id) {
        return ResponseEntity.ok(permissionService.findPermissionById(PermissionId.of(id)));
    }

    @GetMapping
    public ResponseEntity<List<PermissionResponseDto>> getAllPermissions() {
        return ResponseEntity.ok(permissionService.findAllPermissions());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissionResponseDto> updatePermission(@PathVariable Long id, @RequestBody PermissionRequestDto dto) {
        PermissionResponseDto permission = permissionService.updatePermission(PermissionId.of(id), dto);
        return ResponseEntity.ok(permission);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable Long id) {
        permissionService.deletePermission(PermissionId.of(id));
        return ResponseEntity.noContent().build();
    }

    private URI getUri(PermissionResponseDto permission) {
        return URI.create("/api/v1/permissions/" + permission.id());
    }
}