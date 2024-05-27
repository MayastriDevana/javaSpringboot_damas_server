package com.damas.model;

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
@Table(name = "skse")
public class Skse {
    @Id
    @UuidGenerator
    private String id;
    
    private String nosurat;

    private String perihal;

    private String pic;

    private String deadline;
    
    private String status;

}
