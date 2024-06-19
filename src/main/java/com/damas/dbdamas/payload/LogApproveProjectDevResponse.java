package com.damas.dbdamas.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Builder //untuk membuat object user response

public class LogApproveProjectDevResponse {
    private String id;

    private String idproject;

    private String submitter;

    private String authorizer;

    private String submitAt;
    
    private String deadlineApprovement;
    
    private String statusApprovement;
    
    private String projectname;
    
    private String pic;

    private String departement;

    private String kickoffstart;

    private String kickoffdeadline;

    private String kickoffdone;

    private String userrequirementstart;

    private String userrequirementdeadline;

    private String userrequirementdone;

    private String applicationdevelopmentstart;

    private String applicationdevelopmentdeadline;

    private String applicationdevelopmentdone;

    private String sitstart;

    private String sitdeadline;

    private String sitdone;

    private String uatstart;

    private String uatdeadline;

    private String uatdone;

    private String implementationpreparestart;

    private String implementationpreparedeadline;

    private String implementationpreparedone;

    private String implementationmeetingstart;

    private String implementationmeetingdeadline;

    private String implementationmeetingdone;
    
    private String implementationstart;

    private String implementationdeadline;

    private String implementationdone;

    private String postimplementationreviewstart;

    private String postimplementationreviewdeadline;

    private String postimplementationreviewdone;

    private String status;

    private String deadlineproject;

    private String projectdone;

    private Integer maxSize;
}
