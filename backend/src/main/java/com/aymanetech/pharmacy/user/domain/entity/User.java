package com.aymanetech.pharmacy.user.domain.entity;

import com.aymanetech.pharmacy.user.domain.vo.Name;
import com.aymanetech.pharmacy.user.domain.vo.Timestamp;
import com.aymanetech.pharmacy.user.domain.vo.UserId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "phar_users")

@Getter
@Setter
@NoArgsConstructor
public class User {

    @EmbeddedId
    private UserId id;

    @Embedded
    private Name name;

    private String email;

    private String password;

    @Embedded
    private Timestamp timestamp;

    @ManyToOne
    private Role role;
}