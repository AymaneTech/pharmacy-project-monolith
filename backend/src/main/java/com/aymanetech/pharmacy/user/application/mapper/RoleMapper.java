package com.aymanetech.pharmacy.user.application.mapper;

import com.aymanetech.pharmacy.common.application.mapper.BaseMapper;
import com.aymanetech.pharmacy.user.application.dto.request.RoleRequestDto;
import com.aymanetech.pharmacy.user.application.dto.response.RoleResponseDto;
import com.aymanetech.pharmacy.user.domain.entity.Role;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapper.class)
public interface RoleMapper extends BaseMapper<Role, RoleRequestDto, RoleResponseDto> {
}

