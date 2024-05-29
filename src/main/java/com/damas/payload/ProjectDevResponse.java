package com.damas.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Builder //untuk membuat object user response

public class ProjectDevResponse {
    private String id;
    private String projectname;
    private String pic;
    private String deadline;
    private String status;
    private Integer maxSize;

}
