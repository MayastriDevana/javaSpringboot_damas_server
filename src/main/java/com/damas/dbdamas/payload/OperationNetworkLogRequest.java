package com.damas.dbdamas.payload;

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

public class OperationNetworkLogRequest {

    @NotBlank
    @Size(max = 255)
    private String id;

    @NotBlank
    @Size(max = 255)
    private String network_id;

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
    private String network_perihal;

    @Size(max = 255)
    private String network_pic;
    
    @Size(max = 255)
    private String departement;

    @Size(max = 255)
    private String network_kickoff_start;
    
    @Size(max = 255)
    private String network_kickoff_deadline;
    
    @Size(max = 255)
    private String network_kickoff_done;
    
    @Size(max = 255)
    private String network_mop_start;
    
    @Size(max = 255)
    private String network_mop_deadline;
     
    @Size(max = 255)
    private String network_mop_done;
    
    @Size(max = 255)
    private String network_demomop_start;
    
    @Size(max = 255)
    private String network_demomop_deadline;
    
    @Size(max = 255)
    private String network_demomop_done;
    
    @Size(max = 255)
    private String network_implementasi_start;
    
    @Size(max = 255)
    private String network_implementasi_deadline;

    @Size(max = 255)
    private String network_implementasi_done;

    @Size(max = 255)
    private String network_skse_start;

    @Size(max = 255)
    private String network_skse_deadline;

    @Size(max = 255)
    private String network_skse_done;

    @Size(max = 255)
    private String network_uat_start;

    @Size(max = 255)
    private String network_uat_deadline;

    @Size(max = 255)
    private String network_uat_done;

    @Size(max = 255)
    private String network_status;

    @Size(max = 255)
    private String network_deadline_project;

    @Size(max = 255)
    private String network_project_done;

}
