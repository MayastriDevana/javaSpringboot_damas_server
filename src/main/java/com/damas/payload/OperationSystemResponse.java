package com.damas.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OperationSystemResponse {
    private String system_name;
    private String system_desc;
    private String system_threshold_1;
    private String system_threshold_2;
    private String system_threshold_3;
    private Integer maxSize;
}
