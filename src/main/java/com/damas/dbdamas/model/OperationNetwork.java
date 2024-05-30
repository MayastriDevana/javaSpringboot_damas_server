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

    private String network_deadline;

    private String network_status;

    
}
