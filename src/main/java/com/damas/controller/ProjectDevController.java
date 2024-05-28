package com.damas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/api/allproject")
    public WebResponse<List<ProjectDevResponse>> findAll(
        @RequestHeader("X-API-TOKEN") String token,
        @RequestParam("start") Long start,
        @RequestParam("size") Long size) {
    List<ProjectDevResponse> response = projectDevService.findAll(token, start, size); 

    return WebResponse.<List<ProjectDevResponse>>builder().data(response).error(null).build();
    }

    @GetMapping("api/allproject/getproject")
    public WebResponse<List<ProjectDevResponse>> findProject(
        @RequestHeader("X-API-TOKEN") String token,
        @RequestParam ("input") String input) {
            List<ProjectDevResponse> response = projectDevService.findProject(token, input);

            return WebResponse.<List<ProjectDevResponse>>builder().data(response).error(null).build();
        }
    
    // @PutMapping("/api/allproject/editedproject")
    // public WebResponse<ProjectDevResponse> editProject(
    //         @PathVariable("memoId") String memoId,
    //         @RequestBody LogisticMemoRequest request,
    //         @RequestHeader("X-API-TOKEN") String token) {
    //     LogisticMemoResponse logisticMemoResponse = logisticMemoService.editMemo(memoId, request, token);

    //     return WebResponse.<LogisticMemoResponse>builder().data(logisticMemoResponse).error(null).build();
    // }
    
}
