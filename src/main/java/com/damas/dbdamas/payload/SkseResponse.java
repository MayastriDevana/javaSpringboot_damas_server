package com.damas.dbdamas.payload;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Builder //untuk membuat object user response

public class SkseResponse {
    private String id;
    private String nosurat;
    private String perihal;
    private String pic;
    private String departement;
    private String deadline;
    private String status;
    private String userdomain;
    private String userdomainpic;
    private String createdby;
    private Integer maxSize;

}
