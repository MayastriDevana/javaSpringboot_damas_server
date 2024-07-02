package com.damas.dbdamas.payload.Logistic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemoApprovalResponse {

    private String approval_id ;

    private String memo_id ;

    private String approval_status;

    private String approval_upload; // File path

    private String approval_notes;
}
