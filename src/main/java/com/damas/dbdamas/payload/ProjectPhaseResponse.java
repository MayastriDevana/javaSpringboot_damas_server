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

    private String kickoff;

    private String userrequirement;

    private String applicationdevelopment;

    private String sit;

    private String uat;

    private String implementationprepare;

    private String implementationmeeting;
    
    private String implementation;

    private String postimplementationreview;

    private Integer maxSize;

}
