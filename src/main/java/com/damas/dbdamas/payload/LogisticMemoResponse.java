package com.damas.dbdamas.payload;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Builder //untuk membuat object user response

public class LogisticMemoResponse {
    private String memo_id;
    private String memo_num;
    private String memo_perihal;
    private String memo_pic;
    private String memo_department;
    private String memo_createdBy;
    private String memo_reviewer;
    private String memo_status;
    private String memo_deadline;
    private String memo_notes;
    private String memo_upload;
    
    private String userdomain;

    private String userdomainpic;

    private String userdomainreviewer;
    // private String memo_signature;

    private Integer maxSize;

}
