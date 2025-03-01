package com.aymanetech.event.user.application.mapper;

import com.aymanetech.event.common.application.mapper.BaseMapper;
import com.aymanetech.event.user.application.dto.request.RoleRequestDto;
import com.aymanetech.event.user.application.dto.response.RoleResponseDto;
import com.aymanetech.event.user.domain.entity.Role;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapper.class)
public interface RoleMapper extends BaseMapper<Role, RoleRequestDto, RoleResponseDto> {
}

