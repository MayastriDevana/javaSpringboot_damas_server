package com.damas.dbsecure.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsrAplikasiResponse {
    private String kodeaplikasi;

    private String userid;

    private String groupakses;
    
    private Integer locked;

    private String session;
}
