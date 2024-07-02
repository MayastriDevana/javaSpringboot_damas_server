package com.damas.dbdamas.payload.Operation;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OperationDacenLogResponse {
    
    private String id;

    private String dacen_id;

    private String submitter;

    private String authorizer;

    private String submit_at;

    private String deadline_approvement;

    private String status_approvement;

    private String dacen_perihal;

    private String dacen_pic;

    private String departement;

    private String dacen_phase1;

    private Date dacen_phase1_start;

    private Date dacen_phase1_deadline;

    private Date dacen_phase1_done;

    private String dacen_phase2;

    private Date dacen_phase2_start;

    private Date dacen_phase2_deadline;

    private Date dacen_phase2_done;

    private String dacen_phase3;

    private Date dacen_phase3_start;

    private Date dacen_phase3_deadline;

    private Date dacen_phase3_done;

    private String dacen_phase4;

    private Date dacen_phase4_start;

    private Date dacen_phase4_deadline;

    private Date dacen_phase4_done;

    private String dacen_phase5;

    private Date dacen_phase5_start;

    private Date dacen_phase5_deadline;

    private Date dacen_phase5_done;

    private String dacen_phase6;

    private Date dacen_phase6_start;

    private Date dacen_phase6_deadline;

    private Date dacen_phase6_done;

    private String dacen_phase7;

    private Date dacen_phase7_start;

    private Date dacen_phase7_deadline;

    private Date dacen_phase7_done;

    private String dacen_status;

    private Date dacen_deadline_project;

    private Date dacen_project_done;

    private String createdBy;

    private String userdomain;

    private String userdomain_pic;

    private Integer maxSize;
}