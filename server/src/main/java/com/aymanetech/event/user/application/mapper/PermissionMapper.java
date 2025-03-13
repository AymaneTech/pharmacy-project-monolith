package com.aymanetech.event.user.application.mapper;

import com.aymanetech.event.common.application.mapper.BaseMapper;
import com.aymanetech.event.user.application.dto.request.PermissionRequestDto;
import com.aymanetech.event.user.application.dto.response.PermissionResponseDto;
import com.aymanetech.event.user.domain.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapper.class)
public interface PermissionMapper extends BaseMapper<Permission, PermissionRequestDto, PermissionResponseDto> {
}
