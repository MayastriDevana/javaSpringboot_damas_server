package com.damas.dbdamas.model;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "log_approve_project")
public class LogApproveProjectDev {

    @Id
    @UuidGenerator
    private String id;

    @Column(name = "id_project") 
    private String idproject;

    private String submitter;

    private String authorizer;

    @Column(name = "submit_at") 
    private String submitAt;
    
    @Column(name = "deadline_approvement") 
    private String deadlineApprovement;
    
    @Column(name = "status_approvement") 
    private String statusApprovement;

    private String projectname;

    private String pic;

    private String departement;

    @Column(name = "kick_off_start")
    private String kickoffstart;

    @Column(name = "kick_off_deadline")
    private String kickoffdeadline;

    @Column(name = "kick_off_acctual_done")
    private String kickoffdone;

    @Column(name = "user_requirement_start")
    private String userrequirementstart;

    @Column(name = "user_requirement_deadline")
    private String userrequirementdeadline;

    @Column(name = "user_requirement_done")
    private String userrequirementdone;

    @Column(name = "application_development_start")
    private String applicationdevelopmentstart;

    @Column(name = "application_development_deadline")
    private String applicationdevelopmentdeadline;

    @Column(name = "application_development_done")
    private String applicationdevelopmentdone;

    @Column(name = "sit_start")
    private String sitstart;

    @Column(name = "sit_deadline")
    private String sitdeadline;

    @Column(name = "sit_done")
    private String sitdone;

    @Column(name = "uat_start")
    private String uatstart;

    @Column(name = "uat_deadline")
    private String uatdeadline;

    @Column(name = "uat_done")
    private String uatdone;

    @Column(name = "implementation_prepare_start")
    private String implementationpreparestart;

    @Column(name = "implementation_prepare_deadline")
    private String implementationpreparedeadline;

    @Column(name = "implementation_prepare_done")
    private String implementationpreparedone;

    @Column(name = "implementation_meeting_start")
    private String implementationmeetingstart;

    @Column(name = "implementation_meeting_deadline")
    private String implementationmeetingdeadline;

    @Column(name = "implementation_meeting_done")
    private String implementationmeetingdone;
    
    @Column(name = "implementation_start")
    private String implementationstart;

    @Column(name = "implementation_deadline")
    private String implementationdeadline;

    @Column(name = "implementation_done")
    private String implementationdone;

    @Column(name = "post_implementation_review_start")
    private String 	postimplementationreviewstart;

    @Column(name = "post_implementation_review_deadline")
    private String 	postimplementationreviewdeadline;

    @Column(name = "post_implementation_review_done")
    private String 	postimplementationreviewdone;

    private String status;

    @Column(name = "deadline_project")
    private String deadlineproject;

    @Column(name = "project_done")
    private String projectdone;

}
