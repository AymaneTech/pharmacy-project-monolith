package com.aymanetech.pharmacy.user.application.mapper;

import com.aymanetech.pharmacy.common.application.mapper.BaseMapper;
import com.aymanetech.pharmacy.user.application.dto.request.UserRequestDto;
import com.aymanetech.pharmacy.user.application.dto.response.UserResponseDto;
import com.aymanetech.pharmacy.user.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = BaseMapper.class)
public interface UserMapper extends BaseMapper<User, UserRequestDto, UserResponseDto> {

    @Override
    @Mapping(source = "firstName", target = "name.firstName")
    @Mapping(source = "lastName", target = "name.lastName")
    User toEntity(UserRequestDto dto);
}
