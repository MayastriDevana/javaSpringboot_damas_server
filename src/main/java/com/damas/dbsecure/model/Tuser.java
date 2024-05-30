package com.damas.dbsecure.model;

import java.time.Instant;

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
@Entity
@Table(name = "t_users")
public class Tuser {
    @Id
    private String userid;

    private String username;

    private Integer level;

    private String password;
    
    private Instant lastLogin;

    private Instant expire;

    private Integer status;

    private Integer isaktif;

    private String karyawan;

    private Integer domain;

    private String branch;

    private String userdomain;
}
