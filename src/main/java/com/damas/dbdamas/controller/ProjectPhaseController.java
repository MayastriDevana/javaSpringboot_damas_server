package com.damas.dbdamas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


import com.damas.dbdamas.payload.ProjectPhaseRequest;
import com.damas.dbdamas.payload.ProjectPhaseResponse;
import com.damas.dbdamas.payload.WebResponse;

import com.damas.dbdamas.service.ProjectPhaseService;

@RestController
public class ProjectPhaseController {
    @Autowired
    private ProjectPhaseService projectPhaseService;

    @PostMapping(path = "/api/projectphase", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public WebResponse<ProjectPhaseResponse> newPhase(@RequestBody ProjectPhaseRequest request,
            @RequestHeader("USER-ID") String userid) {
        ProjectPhaseResponse projectPhaseResponse = projectPhaseService.newPhase(request, userid);

        return WebResponse.<ProjectPhaseResponse>builder().data(projectPhaseResponse).error(null).build();
    }
}
