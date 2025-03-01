package com.aymanetech.pharmacy.user.application.service;

import com.aymanetech.pharmacy.user.application.dto.request.UserLoginRequestDto;
import com.aymanetech.pharmacy.user.application.dto.request.UserRegistrationRequestDto;
import com.aymanetech.pharmacy.user.application.dto.request.UserRequestDto;
import com.aymanetech.pharmacy.user.application.dto.response.AuthenticationResponseDto;
import com.aymanetech.pharmacy.user.application.dto.response.UserResponseDto;
import com.aymanetech.pharmacy.user.domain.vo.UserId;

import java.util.List;

public interface UserService {
    UserResponseDto registerNewUser(UserRegistrationRequestDto request);

    AuthenticationResponseDto login(UserLoginRequestDto request);

    UserResponseDto findUserById(UserId id);

    List<UserResponseDto> findAllUsers();

    UserResponseDto updateUser(UserId id, UserRequestDto request);

    void deleteUser(UserId id);
}
