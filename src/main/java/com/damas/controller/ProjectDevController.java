package com.damas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.damas.payload.ProjectDevRequest;
import com.damas.payload.ProjectDevResponse;
import com.damas.payload.WebResponse;
import com.damas.service.ProjectDevService;

@RestController
public class ProjectDevController {

    @Autowired
    private ProjectDevService projectDevService;

    @PostMapping(
    path = "/api/projectdev",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
    )

    public WebResponse<ProjectDevResponse> newProject(@RequestBody ProjectDevRequest request, @RequestHeader("X-API-TOKEN") String token){
        ProjectDevResponse projectDevResponse = projectDevService.newProject(request, token);
    
    return WebResponse.<ProjectDevResponse>builder().data(projectDevResponse).error(null).build();
    }
}
