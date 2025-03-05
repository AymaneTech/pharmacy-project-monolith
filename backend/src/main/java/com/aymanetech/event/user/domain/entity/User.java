package com.aymanetech.event.user.domain.entity;

import com.aymanetech.event.user.domain.vo.Name;
import com.aymanetech.event.user.domain.vo.Timestamp;
import com.aymanetech.event.user.domain.vo.UserId;
import com.aymanetech.event.user.domain.vo.UserStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")

@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails, Serializable {

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

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getName()));
    }

    @Override
    public String getUsername() {
        return email;
    }
}