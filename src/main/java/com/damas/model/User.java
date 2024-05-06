package com.damas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity //model
@Table(name = "users")
public class User {
    @Id
    private String username;
    private String password;
    private String token;
    private String name;
    private String role;

    @Column(name = "token_expired_at")
    private Long tokenExpiredAt;
}
