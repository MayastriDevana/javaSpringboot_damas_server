package com.damas.dbdamas.model;

import java.sql.Date;

import org.hibernate.annotations.UuidGenerator;

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
@Table(name = "operation_itsecurity")
public class OperationItsecurity {
    
    @Id
    @UuidGenerator
    private String itsecurity_id;

    private String itsecurity_perihal;

    private String itsecurity_pic;

    private String departement;

    private String itsecurity_phase1;

    private Date itsecurity_phase1_start;

    private Date itsecurity_phase1_deadline;

    private Date itsecurity_phase1_done;

    private String itsecurity_phase2;

    private Date itsecurity_phase2_start;

    private Date itsecurity_phase2_deadline;

    private Date itsecurity_phase2_done;

    private String itsecurity_phase3;

    private Date itsecurity_phase3_start;

    private Date itsecurity_phase3_deadline;

    private Date itsecurity_phase3_done;

    private String itsecurity_phase4;

    private Date itsecurity_phase4_start;

    private Date itsecurity_phase4_deadline;

    private Date itsecurity_phase4_done;

    private String itsecurity_phase5;

    private Date itsecurity_phase5_start;

    private Date itsecurity_phase5_deadline;

    private Date itsecurity_phase5_done;

    private String itsecurity_phase6;

    private Date itsecurity_phase6_start;

    private Date itsecurity_phase6_deadline;

    private Date itsecurity_phase6_done;

    private String itsecurity_phase7;

    private Date itsecurity_phase7_start;

    private Date itsecurity_phase7_deadline;

    private Date itsecurity_phase7_done;

    private String itsecurity_status;

    private Date itsecurity_deadline_project;

    private Date itsecurity_project_done;

    private String createdBy;

    private String userdomain;

    private String userdomain_pic;
}
