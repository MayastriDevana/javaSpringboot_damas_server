package com.damas.dbdamas.payload;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OperationServerResponse {
    
    private String server_id;

    private String server_perihal;

    private String server_pic;

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

    private String server_status;

    private Date server_deadline_project;

    private Integer maxSize;
}
