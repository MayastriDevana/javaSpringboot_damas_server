package com.damas.dbdamas.model;

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
@Table(name = "projectphase")
public class ProjectPhase {
    @Id
    @UuidGenerator
    private String id;

    @Column(name = "kick_off")
    private String kickoff;

    @Column(name = "user_requirement")
    private String userrequirement;

    @Column(name = "application_development")
    private String applicationdevelopment;

    private String sit;

    private String uat;

    @Column(name = "implementation_prepare")
    private String implementationprepare;

    @Column(name = "implementation_meeting")
    private String implementationmeeting;
    
    private String implementation;

    @Column(name = "post_implementation_review")
    private String 	postimplementationreview;

}
