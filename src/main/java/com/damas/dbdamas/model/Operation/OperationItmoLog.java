package com.damas.dbdamas.model.Operation;

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
@Table(name = "operation_itmo_log")
public class OperationItmoLog {
    @Id
    @UuidGenerator
    private String id;

    private String itmo_id;

    private String submitter;

    private String authorizer;

    private String submit_at;

    private String deadline_approvement;

    private String status_approvement;

    private String itmo_perihal;

    private String itmo_pic;

    private String departement;

    private String itmo_phase1;

    private Date itmo_phase1_start;

    private Date itmo_phase1_deadline;

    private Date itmo_phase1_done;

    private String itmo_phase2;

    private Date itmo_phase2_start;

    private Date itmo_phase2_deadline;

    private Date itmo_phase2_done;

    private String itmo_phase3;

    private Date itmo_phase3_start;

    private Date itmo_phase3_deadline;

    private Date itmo_phase3_done;

    private String itmo_phase4;

    private Date itmo_phase4_start;

    private Date itmo_phase4_deadline;

    private Date itmo_phase4_done;

    private String itmo_phase5;

    private Date itmo_phase5_start;

    private Date itmo_phase5_deadline;

    private Date itmo_phase5_done;

    private String itmo_phase6;

    private Date itmo_phase6_start;

    private Date itmo_phase6_deadline;

    private Date itmo_phase6_done;

    private String itmo_phase7;

    private Date itmo_phase7_start;

    private Date itmo_phase7_deadline;

    private Date itmo_phase7_done;

    private String itmo_status;

    private Date itmo_deadline_project;

    private Date itmo_project_done;

    private String createdBy;

    private String userdomain;

    private String userdomain_pic;
}
