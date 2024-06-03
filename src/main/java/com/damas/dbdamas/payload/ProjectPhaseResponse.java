package com.damas.dbdamas.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Builder //untuk membuat object user response

public class ProjectPhaseResponse {
    private String id;
    private String nopmo;
    private String projectname;
    private String phase;
    private String pic;
    private String departement;
    private String team;
    private String deadline;
    private String status;
    private Integer maxSize;

}
