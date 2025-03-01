package com.aymanetech.pharmacy.user.infrastructure.web;

import com.aymanetech.pharmacy.user.application.dto.request.UserRequestDto;
import com.aymanetech.pharmacy.user.application.dto.response.UserResponseDto;
import com.aymanetech.pharmacy.user.application.service.UserService;
import com.aymanetech.pharmacy.user.domain.vo.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findUserById(UserId.of(id)));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Integer id, @RequestBody UserRequestDto dto) {
        UserResponseDto user = userService.updateUser(UserId.of(id), dto);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(UserId.of(id));
        return ResponseEntity.noContent().build();
    }
}