package com.damas.dbdamas.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Builder //untuk membuat object user response

public class OperationNetworkResponse {
    private String network_id;
    private String network_perihal;
    private String network_pic;
    private String network_deadline;
    private String network_status;
    private Integer maxSize;

}
