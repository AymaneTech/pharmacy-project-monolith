package com.aymanetech.event.event.domain.repository;

import com.aymanetech.event.common.repository.SlugRepository;
import com.aymanetech.event.event.domain.entity.Event;
import com.aymanetech.event.event.domain.vo.EventId;
import com.aymanetech.event.user.domain.vo.UserId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, EventId>, SlugRepository<Event> {
    Page<Event> findAllByOrganiserId(UserId organizerId, Pageable pageable);

    Page<Event> findAllByTitle(String title, Pageable pageable);
}
