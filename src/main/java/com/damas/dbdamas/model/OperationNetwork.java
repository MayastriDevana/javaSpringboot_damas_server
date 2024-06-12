package com.damas.dbdamas.model;



import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity //model
@Table(name = "operation_network")
public class OperationNetwork {
    @Id
    @UuidGenerator
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
 
    
}
