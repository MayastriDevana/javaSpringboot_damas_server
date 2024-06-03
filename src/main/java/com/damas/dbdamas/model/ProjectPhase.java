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

    @Column(name = "no_pmo")
    private String nopmo;

    @Column(name = "project_name")
    private String projectname;

    private String phase;

    private String pic;

    private String departement;

    private String team;

    private String deadline;
    
    private String status;

}
