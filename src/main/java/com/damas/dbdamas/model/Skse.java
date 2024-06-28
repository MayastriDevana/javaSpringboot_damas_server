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
@Entity //model
@Table(name = "ppo_skse")
public class Skse {
    @Id
    @UuidGenerator
    private String id;
    
    @Column(name = "skse_nosurat")
    private String nosurat;

    @Column(name = "skse_perihal")
    private String perihal;

    @Column(name = "skse_pic")
    private String pic;

    @Column(name = "skse_departement")
    private String departement;

    @Column(name = "skse_deadline")
    private String deadlineskse;
    
    @Column(name = "skse_status")
    private String status;

    private String userdomain;

    @Column(name = "userdomain_pic")
    private String userdomainpic;

    @Column(name = "created_by")
    private String createdby;

}
