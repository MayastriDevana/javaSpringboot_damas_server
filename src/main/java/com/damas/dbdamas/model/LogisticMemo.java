package com.damas.dbdamas.model;

import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
    
    private Date memo_deadline;

    private String memo_status;

    
    private String memo_notes;  // Hidden field, can store longer text

    // @Lob
    // private byte[] memo_upload;  // Field for storing uploaded files
}
