package com.damas.dbdamas.model;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
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
@Table(name = "log_approve_skse")
public class LogApproveSkse {
     @Id
    @UuidGenerator
    private String id;

    @Column(name = "id_skse") 
    private String idskse;

    private String submitter;

    private String authorizer;

    @Column(name = "submit_at") 
    private String submitAt;
    
    @Column(name = "deadline_approvement") 
    private String deadlineApprovement;
    
    @Column(name = "status_approvement") 
    private String statusApprovement;

    @Column(name = "skse_nosurat")
    private String nosurat;

    @Column(name = "skse_perihal")
    private String perihal;

    @Column(name = "skse_pic")
    private String pic;

    @Column(name = "skse_departement")
    private String departement;

    @Column(name = "skse_deadline")
    private String deadline;
    
    @Column(name = "skse_status")
    private String status;
}
