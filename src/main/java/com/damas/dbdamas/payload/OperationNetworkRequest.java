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


}
