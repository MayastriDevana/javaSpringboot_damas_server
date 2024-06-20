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

public class ProjectDevRequest {

    @NotBlank
    @Size(max = 100)
    private String projectname;

    @NotBlank
    @Size(max = 100)
    private String pic;

    @Size(max = 100)
    private String departement;

    @Size(max = 100)
    private String kickoffstart;

    @Size(max = 100)
    private String kickoffdeadline;

    @Size(max = 100)
    private String kickoffdone;

    @Size(max = 100)
    private String userrequirementstart;

    @Size(max = 100)
    private String userrequirementdeadline;

    @Size(max = 100)
    private String userrequirementdone;

    @Size(max = 100)
    private String applicationdevelopmentstart;

    @Size(max = 100)
    private String applicationdevelopmentdeadline;

    @Size(max = 100)
    private String applicationdevelopmentdone;

    @Size(max = 100)
    private String sitstart;

    @Size(max = 100)
    private String sitdeadline;

    @Size(max = 100)
    private String sitdone;

    @Size(max = 100)
    private String uatstart;

    @Size(max = 100)
    private String uatdeadline;

    @Size(max = 100)
    private String uatdone;

    @Size(max = 100)
    private String implementationpreparestart;

    @Size(max = 100)
    private String implementationpreparedeadline;

    @Size(max = 100)
    private String implementationpreparedone;

    @Size(max = 100)
    private String implementationmeetingstart;

    @Size(max = 100)
    private String implementationmeetingdeadline;

    @Size(max = 100)
    private String implementationmeetingdone;

    @Size(max = 100)
    private String implementationstart;

    @Size(max = 100)
    private String implementationdeadline;

    @Size(max = 100)
    private String implementationdone;

    @Size(max = 100)
    private String postimplementationreviewstart;

    @Size(max = 100)
    private String postimplementationreviewdeadline;

    @Size(max = 100)
    private String postimplementationreviewdone;

    @Size(max = 100)
    private String status;

    @Size(max = 100)
    private String deadlineproject;

    @Size(max = 100)
    private String projectdone;

    @Size(max = 100)
    private String createdby;
}
