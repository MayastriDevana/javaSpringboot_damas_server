package com.damas.model;

import org.hibernate.annotations.UuidGenerator;

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
    @UuidGenerator
    private String id;
    
    private String username;

    private String password;

    private String name;
    
    private String role;

    private String token;

    private String status;


    @Column(name = "token_expired_at")
    private Long tokenExpiredAt;
}
