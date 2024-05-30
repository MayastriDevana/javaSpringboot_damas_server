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
@Table(name = "logistic_memo")
public class LogisticMemo {
    @Id
    @UuidGenerator
    private String memo_id;
    
    private String memo_num;

    private String memo_perihal;

    private String memo_pic;

    private String memo_deadline;
    
    private String memo_status;

}
