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
@Table(name = "operation_itsupport_log")
public class OperationItsupportLog {
    @Id
    @UuidGenerator
    private String id;

    private String itsupport_id;

    private String submitter;

    private String authorizer;

    private String submit_at;

    private String deadline_approvement;

    private String status_approvement;

    private String itsupport_perihal;

    private String itsupport_pic;

    private String departement;

    private String itsupport_phase1;

    private Date itsupport_phase1_start;

    private Date itsupport_phase1_deadline;

    private Date itsupport_phase1_done;

    private String itsupport_phase2;

    private Date itsupport_phase2_start;

    private Date itsupport_phase2_deadline;

    private Date itsupport_phase2_done;

    private String itsupport_phase3;

    private Date itsupport_phase3_start;

    private Date itsupport_phase3_deadline;

    private Date itsupport_phase3_done;

    private String itsupport_phase4;

    private Date itsupport_phase4_start;

    private Date itsupport_phase4_deadline;

    private Date itsupport_phase4_done;

    private String itsupport_phase5;

    private Date itsupport_phase5_start;

    private Date itsupport_phase5_deadline;

    private Date itsupport_phase5_done;

    private String itsupport_phase6;

    private Date itsupport_phase6_start;

    private Date itsupport_phase6_deadline;

    private Date itsupport_phase6_done;

    private String itsupport_phase7;

    private Date itsupport_phase7_start;

    private Date itsupport_phase7_deadline;

    private Date itsupport_phase7_done;

    private String itsupport_status;

    private Date itsupport_deadline_project;

    private Date itsupport_project_done;

    private String createdBy;

    private String userdomain;

    private String userdomain_pic;
}
