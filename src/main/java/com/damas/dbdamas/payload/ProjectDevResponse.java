package com.damas.dbdamas.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Builder //untuk membuat object user response

public class ProjectDevResponse {
    private String id;

    private String projectname;
    
    private String pic;

    private String departement;

    private String kickoff;

    private String userrequirement;

    private String applicationdevelopment;

    private String sit;

    private String uat;

    private String implementationprepare;

    private String implementationmeeting;
    
    private String implementation;

    private String postimplementationreview;

    private String status;

    private Integer maxSize;

}
