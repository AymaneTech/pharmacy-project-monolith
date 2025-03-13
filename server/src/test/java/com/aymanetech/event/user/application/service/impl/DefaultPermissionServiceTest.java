package com.aymanetech.event.user.application.service.impl;

import com.aymanetech.event.user.application.dto.request.PermissionRequestDto;
import com.aymanetech.event.user.application.dto.response.PermissionResponseDto;
import com.aymanetech.event.user.application.mapper.PermissionMapper;
import com.aymanetech.event.user.domain.entity.Permission;
import com.aymanetech.event.user.domain.repository.PermissionRepository;
import com.aymanetech.event.user.domain.vo.PermissionId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class DefaultPermissionServiceTest {

    @Mock
    private PermissionRepository repository;
    @Mock
    private PermissionMapper mapper;
    @InjectMocks
    private DefaultPermissionService sut;

    @Test
    void givenValidName_whenCreateNewPermission_thenSuccss() {
        PermissionId permissionId = PermissionId.of(2);
        PermissionRequestDto request = new PermissionRequestDto("CreateUsers");
        Permission entity = new Permission(request.name());
        PermissionResponseDto expected = new PermissionResponseDto(permissionId.value(), entity.getName());

        given(mapper.toEntity(request)).willReturn(entity);
        entity.setId(permissionId);
        given(repository.save(entity)).willReturn(entity);
        given(mapper.toResponseDto(entity)).willReturn(expected);

        PermissionResponseDto actual = sut.createNewPermission(request);

        assertThat(actual).isNotNull();
        assertThat(actual.name()).isEqualTo(request.name());
        assertThat(actual.id()).isEqualTo(permissionId.value());

        verify(repository).save(entity);
    }
}