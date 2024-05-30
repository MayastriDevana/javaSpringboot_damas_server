package com.damas.dbsecure.payload;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String userid;

    private String username;

    private Integer level;
    
    private Instant lastLogin;

    private Instant expire;

    private Integer status;

    private Integer isaktif;

    private String karyawan;

    private Integer domain;

    private String branch;

    private String userdomain;
}
