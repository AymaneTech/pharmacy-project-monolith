package com.aymanetech.event.event.application.mapper;

import com.aymanetech.event.common.application.mapper.BaseMapper;
import com.aymanetech.event.event.application.dto.request.EventRequestDto;
import com.aymanetech.event.event.application.dto.response.EventResponseDto;
import com.aymanetech.event.event.domain.entity.Event;
import org.mapstruct.Mapper;


@Mapper(config = BaseMapper.class)
public interface EventMapper extends BaseMapper<Event, EventRequestDto, EventResponseDto> {
}
