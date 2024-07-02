package com.damas.dbdamas.model.Operation;

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
@Entity
@Table(name = "operation_network_log")
public class OperationNetworkLog {
    
    @Id
    @UuidGenerator
    private String id;

    private String network_id;

    private String submitter;

    private String authorizer;

    private String submit_at;

    private String deadline_approvement;
     
    private String status_approvement;

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
    
}
