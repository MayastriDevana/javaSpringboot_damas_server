package com.damas.dbdamas.payload.Operation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Builder //untuk membuat object user response

public class OperationNetworkResponse {
    
    private String network_id;

    private String network_perihal;
    
    private String network_pic;

    private String departement;

    private String network_kickoff_start;

    private String network_kickoff_deadline;

    private String network_kickoff_done;

    private String network_mop_start;

    private String network_mop_deadline;
    
    private String network_mop_done;

    private String network_demomop_start;

    private String network_demomop_deadline;

    private String network_demomop_done;

    private String network_implementasi_start;

    private String network_implementasi_deadline;

    private String network_implementasi_done;

    private String network_skse_start;

    private String network_skse_deadline;

    private String network_skse_done;
    
    private String network_uat_start;

    private String network_uat_deadline;

    private String network_uat_done;

    private String network_status;

    private String network_deadline_project;

    private String network_project_done;

    private String createdBy;

    private String userdomain;

    private String userdomain_pic;
    
    private Integer maxSize;

}