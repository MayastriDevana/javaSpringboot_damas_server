package com.damas.dbdamas.model.Logistic;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity // model
@Table(name = "logistic_memo")
public class LogisticMemo {
    @Id
    @UuidGenerator
    private String memo_id;

    private String memo_num;

    private String memo_perihal;

    private String memo_pic;

    private String memo_department;

    private String memo_createdBy;

    private String memo_reviewer;
    
    private String memo_deadline;

    private String memo_status;

    
    private String memo_notes;  // Hidden field, can store longer text

    @Column(nullable = true, length = 255)
    private String memo_upload;  // Field for storing uploaded files

    private String userdomain;

    @Column(name = "userdomain_pic")
    private String userdomainpic;

    @Column(name = "userdomain_reviewer")
    private String userdomainreviewer;


}
