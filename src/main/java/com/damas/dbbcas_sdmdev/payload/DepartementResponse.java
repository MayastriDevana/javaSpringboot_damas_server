package com.damas.dbbcas_sdmdev.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Builder //untuk membuat object user response

public class DepartementResponse {
    private String catapaid;
    private String nama;
    private String departement;
    private Integer maxSize;

}
