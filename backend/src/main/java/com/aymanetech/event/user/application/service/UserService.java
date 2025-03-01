package com.aymanetech.event.user.application.service;

import com.aymanetech.event.user.application.dto.request.UserLoginRequestDto;
import com.aymanetech.event.user.application.dto.request.UserRegistrationRequestDto;
import com.aymanetech.event.user.application.dto.request.UserRequestDto;
import com.aymanetech.event.user.application.dto.response.AuthenticationResponseDto;
import com.aymanetech.event.user.application.dto.response.UserResponseDto;
import com.aymanetech.event.user.domain.vo.UserId;

import java.util.List;

public interface UserService {
    UserResponseDto registerNewUser(UserRegistrationRequestDto request);

    AuthenticationResponseDto login(UserLoginRequestDto request);

    UserResponseDto findUserById(UserId id);

    List<UserResponseDto> findAllUsers();

    UserResponseDto updateUser(UserId id, UserRequestDto request);

    void deleteUser(UserId id);
}
