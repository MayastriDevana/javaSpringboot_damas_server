package com.damas.dbsecure.model;



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
@Table(name = "t_usraplikasi")
public class UsrAplikasi {

    private String kodeaplikasi;
    
    @Id
    private String userid;

    private String groupakses;
    
    private Integer locked;
    
    private String session;

}
