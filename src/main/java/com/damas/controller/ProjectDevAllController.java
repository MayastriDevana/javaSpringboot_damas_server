package com.damas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.damas.payload.ProjectDevResponse;
import com.damas.payload.WebResponse;
import com.damas.service.AllProjectService;

@RestController
public class ProjectDevAllController {
    @Autowired
    private AllProjectService allProjectService;

    @GetMapping("/api/allproject")
    public WebResponse<List<ProjectDevResponse>> findAll(
        @RequestHeader("X-API-TOKEN") String token,
        @RequestParam("start") Long start,
        @RequestParam("size") Long size) {
    List<ProjectDevResponse> response = allProjectService.findAll(token, start, size); 

    return WebResponse.<List<ProjectDevResponse>>builder().data(response).error(null).build();
    }
}
