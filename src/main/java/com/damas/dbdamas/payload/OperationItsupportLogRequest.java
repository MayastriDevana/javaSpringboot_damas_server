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

public class OperationItsupportLogRequest {

    @NotBlank
    @Size(max = 255)
    private String id;

    @NotBlank
    @Size(max = 255)
    private String itsupport_id;

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
    private String itsupport_perihal;

    @Size(max = 255)
    private String itsupport_pic;

    @Size(max = 255)
    private String departement;

    @Size(max = 255)
    private String itsupport_phase1;

    private Date itsupport_phase1_start;

    private Date itsupport_phase1_deadline;

    private Date itsupport_phase1_done;

    @Size(max = 255)
    private String itsupport_phase2;

    private Date itsupport_phase2_start;

    private Date itsupport_phase2_deadline;

    private Date itsupport_phase2_done;

    @Size(max = 255)
    private String itsupport_phase3;

    private Date itsupport_phase3_start;

    private Date itsupport_phase3_deadline;

    private Date itsupport_phase3_done;

    @Size(max = 255)
    private String itsupport_phase4;

    private Date itsupport_phase4_start;

    private Date itsupport_phase4_deadline;

    private Date itsupport_phase4_done;

    @Size(max = 255)
    private String itsupport_phase5;

    private Date itsupport_phase5_start;

    private Date itsupport_phase5_deadline;

    private Date itsupport_phase5_done;

    @Size(max = 255)
    private String itsupport_phase6;

    private Date itsupport_phase6_start;

    private Date itsupport_phase6_deadline;

    private Date itsupport_phase6_done;

    @Size(max = 255)
    private String itsupport_phase7;

    private Date itsupport_phase7_start;

    private Date itsupport_phase7_deadline;

    private Date itsupport_phase7_done;

    @Size(max = 255)
    private String itsupport_status;

    private Date itsupport_deadline_project;

    private Date itsupport_project_done;
}
