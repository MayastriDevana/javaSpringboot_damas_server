package com.damas.dbdamas.payload;


import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // untuk membuat object user response

public class LogApproveSkseResponse {
    private String id;

    private String idskse;

    private String submitter;

    private String authorizer;

    private String submitAt;

    private String deadlineApprovement;

    private String statusApprovement;

    private String nosurat;

    private String perihal;

    private String pic;

    private String departement;

    private String deadlineskse;

    private String status;

    private String userdomain;

    private String userdomainpic;

    private String createdby;

    private Integer maxSize;
}
