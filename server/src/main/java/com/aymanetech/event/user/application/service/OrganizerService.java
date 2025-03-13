package com.aymanetech.event.user.application.service;

import com.aymanetech.event.user.domain.entity.User;
import com.aymanetech.event.user.domain.vo.UserId;

public interface OrganizerService {

    boolean isOrganizerExists(UserId id);

    User findOrganizerById(UserId id);
}
