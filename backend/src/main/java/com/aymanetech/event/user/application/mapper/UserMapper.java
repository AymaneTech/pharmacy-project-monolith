package com.aymanetech.event.user.application.mapper;

import com.aymanetech.event.common.application.mapper.BaseMapper;
import com.aymanetech.event.user.application.dto.request.UserRegistrationRequestDto;
import com.aymanetech.event.user.application.dto.request.UserRequestDto;
import com.aymanetech.event.user.application.dto.response.UserResponseDto;
import com.aymanetech.event.user.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = BaseMapper.class)
public interface UserMapper extends BaseMapper<User, UserRequestDto, UserResponseDto> {

    @Override
    @Mapping(source = "firstName", target = "name.firstName")
    @Mapping(source = "lastName", target = "name.lastName")
    User toEntity(UserRequestDto dto);

    @Override
    @Mapping(target = "firstName", source = "name.firstName")
    @Mapping(target = "lastName", source = "name.lastName")
    UserResponseDto toResponseDto(User user);

    @Mapping(source = "firstName", target = "name.firstName")
    @Mapping(source = "lastName", target = "name.lastName")
    User toEntity(UserRegistrationRequestDto dto);
}
