package com.damas.dbdamas.payload;

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

    private String network_kickoff_end;

    private String network_kickoff_acct_end;

    private String network_mop_start;

    private String network_mop_end;
    
    private String network_mop_acct_end;

    private String network_demomop_start;

    private String network_demomop_end;

    private String network_demomop_acct_end;

    private String network_implementasi_start;

    private String network_implementasi_end;

    private String network_implementasi_acct_end;

    private String network_skse_start;

    private String network_skse_end;

    private String network_skse_acct_end;
    
    private String network_uat_start;

    private String network_uat_end;

    private String network_uat_acct_end;

    private String network_status;

    private String network_deadline_project;
    private Integer maxSize;

}
