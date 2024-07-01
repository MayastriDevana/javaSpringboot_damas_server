package com.damas.dbdamas.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // berisi setter dan getter
@AllArgsConstructor // biar class bisa di buat menggunakan argumen/params
@NoArgsConstructor // biar class bisa di buat tidak menggunakan argumen/params
@Builder

public class LogApproveProjectDevRequest {

    @Size(max = 100)
    private String id;

    @Size(max = 100)
    private String idproject;

    @Size(max = 100)
    private String submitter;

    @Size(max = 100)
    private String authorizer;

    @Size(max = 100)
    private String submitAt;
    
    @Size(max = 100)
    private String deadlineApprovement;
    
    @Size(max = 100)
    private String statusApprovement;

    @NotBlank
    @Size(max = 100)
    private String projectname;

    @NotBlank
    @Size(max = 100)
    private String pic;

    @Size(max = 100)
    private String departement;

    @NotBlank
    @Size(max = 100)
    private String kickoffstart;

    @NotBlank
    @Size(max = 100)
    private String kickoffdeadline;

    @Size(max = 100)
    private String kickoffdone;

    @NotBlank
    @Size(max = 100)
    private String userrequirementstart;

    @NotBlank
    @Size(max = 100)
    private String userrequirementdeadline;

    @Size(max = 100)
    private String userrequirementdone;

    @NotBlank
    @Size(max = 100)
    private String applicationdevelopmentstart;

    @NotBlank
    @Size(max = 100)
    private String applicationdevelopmentdeadline;

    @Size(max = 100)
    private String applicationdevelopmentdone;

    @NotBlank
    @Size(max = 100)
    private String sitstart;

    @NotBlank
    @Size(max = 100)
    private String sitdeadline;

    @Size(max = 100)
    private String sitdone;

    @NotBlank
    @Size(max = 100)
    private String uatstart;

    @NotBlank
    @Size(max = 100)
    private String uatdeadline;

    @Size(max = 100)
    private String uatdone;

    @NotBlank
    @Size(max = 100)
    private String implementationpreparestart;

    @NotBlank
    @Size(max = 100)
    private String implementationpreparedeadline;

    @Size(max = 100)
    private String implementationpreparedone;

    @NotBlank
    @Size(max = 100)
    private String implementationmeetingstart;

    @NotBlank
    @Size(max = 100)
    private String implementationmeetingdeadline;

    @Size(max = 100)
    private String implementationmeetingdone;

    @NotBlank
    @Size(max = 100)
    private String implementationstart;

    @NotBlank
    @Size(max = 100)
    private String implementationdeadline;

    @Size(max = 100)
    private String implementationdone;

    @NotBlank
    @Size(max = 100)
    private String postimplementationreviewstart;

    @NotBlank
    @Size(max = 100)
    private String postimplementationreviewdeadline;

    @Size(max = 100)
    private String postimplementationreviewdone;

    @NotBlank
    @Size(max = 100)
    private String status;

    @NotBlank
    @Size(max = 100)
    private String deadlineproject;

    @Size(max = 100)
    private String projectdone;

    @Size(max = 100)
    private String userdomain;

    @Size(max = 100)
    private String userdomainpic;

    @Size(max = 100)
    private String createdby;
}
