package com.damas.dbdamas.payload;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OperationItmoLogRequest {
    
    @NotBlank
    @Size(max = 255)
    private String id;

    @NotBlank
    @Size(max = 255)
    private String itmo_id;

    @Size(max = 255)
    private String submitter;

    @Size(max = 255)
    private String authorizer;

    @Size(max = 255)
    private String submit_at;

    @Size(max = 255)
    private String deadline_approvement;

    @Size(max = 255)
    private String status_approvement;

    @Size(max = 255)
    private String itmo_perihal;

    @Size(max = 255)
    private String itmo_pic;

    @Size(max = 255)
    private String departement;

    @Size(max = 255)
    private String itmo_phase1;

    private Date itmo_phase1_start;

    private Date itmo_phase1_deadline;

    private Date itmo_phase1_done;

    @Size(max = 255)
    private String itmo_phase2;

    private Date itmo_phase2_start;

    private Date itmo_phase2_deadline;

    private Date itmo_phase2_done;

    @Size(max = 255)
    private String itmo_phase3;

    private Date itmo_phase3_start;

    private Date itmo_phase3_deadline;

    private Date itmo_phase3_done;

    @Size(max = 255)
    private String itmo_phase4;

    private Date itmo_phase4_start;

    private Date itmo_phase4_deadline;

    private Date itmo_phase4_done;

    @Size(max = 255)
    private String itmo_phase5;

    private Date itmo_phase5_start;

    private Date itmo_phase5_deadline;

    private Date itmo_phase5_done;

    @Size(max = 255)
    private String itmo_phase6;

    private Date itmo_phase6_start;

    private Date itmo_phase6_deadline;

    private Date itmo_phase6_done;

    @Size(max = 255)
    private String itmo_phase7;

    private Date itmo_phase7_start;

    private Date itmo_phase7_deadline;

    private Date itmo_phase7_done;

    @Size(max = 255)
    private String itmo_status;

    private Date itmo_deadline_project;

    private Date itmo_project_done;

    @Size(max = 255)
    private String createdBy;

    @Size(max = 255)
    private String userdomain;

    @Size(max = 255)
    private String userdomain_pic;
}
