package com.damas.dbdamas.model.Logistic;

import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "memo_approval")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemoApproval {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @UuidGenerator
    @Column(name = "approval_id")
    private String approvalId;

    @Column(name = "memo_id")
    private String memoId;

    private String approval_status;
    private String approval_upload; // Store file path
    private String approval_notes;
}
