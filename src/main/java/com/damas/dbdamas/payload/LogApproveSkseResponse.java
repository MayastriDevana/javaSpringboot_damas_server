package com.damas.dbdamas.payload;


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

    private String deadline;

    private String status;

    private Integer maxSize;
}
