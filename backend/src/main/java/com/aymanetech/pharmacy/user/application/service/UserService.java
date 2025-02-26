package com.aymanetech.pharmacy.user.application.service;

import com.aymanetech.pharmacy.user.application.dto.request.UserLoginRequestDto;
import com.aymanetech.pharmacy.user.application.dto.request.UserRegistrationRequestDto;
import com.aymanetech.pharmacy.user.application.dto.request.UserRequestDto;

import java.util.List;

public interface UserService {
    UserRequestDto registerNewUser(UserRegistrationRequestDto request);

    UserRequestDto login(UserLoginRequestDto request);

    UserRequestDto findUserById(Long id);

    List<UserRequestDto> findAllUsers();

    UserRequestDto updateUser(Long id, UserRequestDto request);

    void deleteUser(Long id);
}
