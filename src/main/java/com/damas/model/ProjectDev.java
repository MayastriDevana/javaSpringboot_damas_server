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
@Entity //model
@Table(name = "projectdev")
public class ProjectDev {
    @Id
    @UuidGenerator
    private String id;
    
    private String projectname;

    private String pic;

    private String deadline;
    
    private String status;

}
