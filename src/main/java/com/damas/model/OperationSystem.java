package com.damas.model;

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
@Table(name = "operation_system")
public class OperationSystem {
    @Id
    @UuidGenerator
    private String system_id;

    private String system_name;

    private String system_desc;

    private String system_threshold_1;

    private String system_threshold_2;

    private String system_threshold_3;
}
