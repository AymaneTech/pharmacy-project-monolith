package com.aymanetech.pharmacy.user.application.mapper;

import com.aymanetech.pharmacy.common.application.mapper.BaseMapper;
import com.aymanetech.pharmacy.user.application.dto.request.PermissionRequestDto;
import com.aymanetech.pharmacy.user.application.dto.response.PermissionResponseDto;
import com.aymanetech.pharmacy.user.domain.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapper.class)
public interface PermissionMapper extends BaseMapper<Permission, PermissionRequestDto, PermissionResponseDto> {
}
