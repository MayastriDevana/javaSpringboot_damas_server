package com.damas.dbdamas.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //berisi setter dan getter
@AllArgsConstructor //biar class bisa di buat menggunakan argumen/params
@NoArgsConstructor //biar class bisa di buat tidak menggunakan argumen/params
@Builder

public class OperationNetworkRequest {

    @NotBlank
    @Size(max = 255)
    private String network_id;

    @NotBlank
    @Size(max = 255)
    private String network_perihal;
    
    @NotBlank
    @Size(max = 255)
    private String network_pic;

    @NotBlank
    @Size(max = 255)
    private String departement;

    @NotBlank
    @Size(max = 255)
    private String network_kickoff_start;

    @NotBlank
    @Size(max = 255)
    private String network_kickoff_end;


    @Size(max = 255)
    private String network_kickoff_acct_end;

    @NotBlank
    @Size(max = 255)
    private String network_mop_start;

    @NotBlank
    @Size(max = 255)
    private String network_mop_end;

    @Size(max = 255)
    private String network_mop_acct_end;

    @NotBlank
    @Size(max = 255)
    private String network_demomop_start;

    @NotBlank
    @Size(max = 255)
    private String network_demomop_end;


    @Size(max = 255)
    private String network_demomop_acct_end;

    @NotBlank
    @Size(max = 255)
    private String network_implementasi_start;

    @NotBlank
    @Size(max = 255)
    private String network_implementasi_end;

    @Size(max = 255)
    private String network_implementasi_acct_end;

    @NotBlank
    @Size(max = 255)
    private String network_skse_start;

    @NotBlank
    @Size(max = 255)
    private String network_skse_end;


    @Size(max = 255)
    private String network_skse_acct_end;
    
    @NotBlank
    @Size(max = 255)
    private String network_uat_start;

    @NotBlank
    @Size(max = 255)
    private String network_uat_end;


    @Size(max = 255)
    private String network_uat_acct_end;

    @NotBlank
    @Size(max = 255)
    private String network_status;

    @NotBlank
    @Size(max = 255)
    private String network_deadline_project;


}
