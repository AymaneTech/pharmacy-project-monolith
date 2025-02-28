package com.aymanetech.pharmacy.user.infrastructure.web;

import com.aymanetech.pharmacy.user.application.dto.request.RoleRequestDto;
import com.aymanetech.pharmacy.user.application.dto.response.RoleResponseDto;
import com.aymanetech.pharmacy.user.application.service.RoleService;
import com.aymanetech.pharmacy.user.domain.vo.RoleId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleResponseDto> createRole(@RequestBody RoleRequestDto dto) {
        RoleResponseDto role = roleService.createNewRole(dto);
        return ResponseEntity.created(getUri(role))
                .body(role);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDto> getRoleById(@PathVariable Long id) {
        return ResponseEntity.ok(roleService.findRoleById(RoleId.of(id)));
    }

    @GetMapping
    public ResponseEntity<List<RoleResponseDto>> getAllRoles() {
        return ResponseEntity.ok(roleService.findAllRoles());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponseDto> updateRole(@PathVariable Long id, @RequestBody RoleRequestDto dto) {
        RoleResponseDto role = roleService.updateRole(RoleId.of(id), dto);
        return ResponseEntity.ok(role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(RoleId.of(id));
        return ResponseEntity.noContent().build();
    }

    private URI getUri(RoleResponseDto role) {
        return URI.create("/api/v1/roles/" + role.id());
    }
}