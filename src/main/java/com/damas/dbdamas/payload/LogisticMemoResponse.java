package com.damas.dbdamas.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LogisticMemoResponse {
    private String memo_id;
    private String memo_num;
    private String memo_perihal;
    private String memo_pic;
    private String memo_status;
    private String memo_deadline;
    private int maxSize;

    public LogisticMemoResponse(String memo_id, String memo_num, String memo_perihal, String memo_pic, String memo_status, String memo_deadline, int maxSize) {
        this.memo_id = memo_id;
        this.memo_num = memo_num;
        this.memo_perihal = memo_perihal;
        this.memo_pic = memo_pic;
        this.memo_status = memo_status;
        this.memo_deadline = memo_deadline;
        this.maxSize = maxSize;
    }
}
