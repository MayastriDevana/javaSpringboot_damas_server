package com.damas.dbdamas.payload.Operation;

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

public class OperationDacenLogRequest {

    @NotBlank
    @Size(max = 255)
    private String id;

    @NotBlank
    @Size(max = 255)
    private String dacen_id;

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
    private String dacen_perihal;

    @Size(max = 255)
    private String dacen_pic;

    @Size(max = 255)
    private String departement;

    @Size(max = 255)
    private String dacen_phase1;

    private Date dacen_phase1_start;

    private Date dacen_phase1_deadline;

    private Date dacen_phase1_done;

    @Size(max = 255)
    private String dacen_phase2;

    private Date dacen_phase2_start;

    private Date dacen_phase2_deadline;

    private Date dacen_phase2_done;

    @Size(max = 255)
    private String dacen_phase3;

    private Date dacen_phase3_start;

    private Date dacen_phase3_deadline;

    private Date dacen_phase3_done;

    @Size(max = 255)
    private String dacen_phase4;

    private Date dacen_phase4_start;

    private Date dacen_phase4_deadline;

    private Date dacen_phase4_done;

    @Size(max = 255)
    private String dacen_phase5;

    private Date dacen_phase5_start;

    private Date dacen_phase5_deadline;

    private Date dacen_phase5_done;

    @Size(max = 255)
    private String dacen_phase6;

    private Date dacen_phase6_start;

    private Date dacen_phase6_deadline;

    private Date dacen_phase6_done;

    @Size(max = 255)
    private String dacen_phase7;

    private Date dacen_phase7_start;

    private Date dacen_phase7_deadline;

    private Date dacen_phase7_done;

    @Size(max = 255)
    private String dacen_status;

    private Date dacen_deadline_project;

    private Date dacen_project_done;

    @Size(max = 255)
    private String createdby;

    @Size(max = 255)

    private String userdomain;

    @Size(max = 255)
    private String userdomain_pic;
}
