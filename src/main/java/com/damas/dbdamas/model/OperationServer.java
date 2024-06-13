package com.damas.dbdamas.model;

import java.sql.Date;

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
@Table(name = "operation_server")
public class OperationServer {
    @Id
    @UuidGenerator
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
}
