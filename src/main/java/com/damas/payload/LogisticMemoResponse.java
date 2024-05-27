package com.damas.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Builder //untuk membuat object user response

public class LogisticMemoResponse {
    private String memo_num;
    private String memo_perihal;
    private String memo_pic;
    private String memo_deadline;
    private String memo_status;
    private Integer maxSize;


}
