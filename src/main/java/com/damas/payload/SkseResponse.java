package com.damas.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Builder //untuk membuat object user response

public class SkseResponse {
    private String nosurat;
    private String perihal;
    private String pic;
    private String deadline;
    private String status;
    private Integer maxSize;

}
