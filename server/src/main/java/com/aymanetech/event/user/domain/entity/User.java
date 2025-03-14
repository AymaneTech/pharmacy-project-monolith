package com.aymanetech.event.user.domain.entity;

import com.aymanetech.event.user.domain.vo.Name;
import com.aymanetech.event.user.domain.vo.Timestamp;
import com.aymanetech.event.user.domain.vo.UserId;
import com.aymanetech.event.user.domain.vo.UserStatus;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
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
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private UserStatus status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getName()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isEnabled() {
        return this.status == UserStatus.ACTIVE;
    }
}
