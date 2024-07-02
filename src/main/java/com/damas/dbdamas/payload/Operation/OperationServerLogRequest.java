package com.damas.dbdamas.payload.Operation;

import java.sql.Date;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OperationServerLogRequest {
    
    @Size(max = 255)
    private String id;

    @Size(max = 255)
    private String server_id;
    
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
    private String server_perihal;

    @Size(max = 255)
    private String server_pic;

    @Size(max = 255)
    private String departement;

    private Date server_kickoff_start;

    private Date server_kickoff_deadline;

    private Date server_kickoff_done;

    private Date server_peyiapanserver_start;

    private Date server_peyiapanserver_deadline;

    private Date server_peyiapanserver_done;

    private Date server_instalasiaplikasi_start;

    private Date server_instalasiaplikasi_deadline;

    private Date server_instalasiaplikasi_done;

    private Date server_instalcheckpoint_start;

    private Date server_instalcheckpoint_deadline;

    private Date server_instalcheckpoint_done;

    private Date server_testingkoneksi_start;

    private Date server_testingkoneksi_deadline;

    private Date server_testingkoneksi_done;

    private Date server_serahterimaserver_start;

    private Date server_serahterimaserver_deadline;

    private Date server_serahterimaserver_done;

    private Date server_implementasi_start;

    private Date server_implementasi_deadline;

    private Date server_implementasi_done;

    @Size(max = 255)
    private String server_status;

    private Date server_deadline_project;

    private Date server_project_done;

    @Size(max = 255)
    private String createdBy;

    @Size(max = 255)
    private String userdomain;

    @Size(max = 255)
    private String userdomain_pic;
}
