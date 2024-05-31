package com.damas.dbdamas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.damas.dbdamas.payload.ProjectDevRequest;
import com.damas.dbdamas.payload.ProjectDevResponse;
import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.service.ProjectDevService;

@RestController
public class ProjectDevController {

    @Autowired
    private ProjectDevService projectDevService;

    @PostMapping(path = "/api/projectdev", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)

    public WebResponse<ProjectDevResponse> newProject(@RequestBody ProjectDevRequest request,
        @RequestHeader("USER-ID") String userid) {
        ProjectDevResponse projectDevResponse = projectDevService.newProject(request, userid);

        return WebResponse.<ProjectDevResponse>builder().data(projectDevResponse).error(null).build();
    }

    @GetMapping("/api/allproject")
    public WebResponse<List<ProjectDevResponse>> findAll(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size) {
        List<ProjectDevResponse> response = projectDevService.findAll(userid, start, size);

        return WebResponse.<List<ProjectDevResponse>>builder().data(response).error(null).build();
    }

    @GetMapping("api/allproject/getproject")
    public WebResponse<List<ProjectDevResponse>> findProject(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("input") String input) {
        List<ProjectDevResponse> response = projectDevService.findProject(userid, input);

        return WebResponse.<List<ProjectDevResponse>>builder().data(response).error(null).build();
    }

    @PutMapping("/api/allproject/editedproject")
    public WebResponse<ProjectDevResponse> editedProject(
            @RequestHeader("USER-ID") String userid,
            @RequestBody ProjectDevRequest request,
            @RequestParam("input") String input) {
        ProjectDevResponse ProjectDevResponse = projectDevService.editedProject(userid, request, input);

        return WebResponse.<ProjectDevResponse>builder().data(ProjectDevResponse).error(null).build();
    }

}
