package com.aymanetech.event.event.domain.repository;

import com.aymanetech.event.event.domain.entity.Event;
import com.aymanetech.event.event.domain.vo.EventId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, EventId> {
}
