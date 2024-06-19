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


import com.damas.dbdamas.payload.SkseRequest;
import com.damas.dbdamas.payload.SkseResponse;
import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.service.SkseService;

@RestController
public class SkseController {
    @Autowired
    private SkseService skseService;


    @PostMapping(
    path = "/api/newskse",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
    )

    public WebResponse<SkseResponse> newSkse(@RequestBody SkseRequest request, @RequestHeader("USER-ID") String userid){
        SkseResponse skseResponse = skseService.newSkse(request, userid);
    
    return WebResponse.<SkseResponse>builder().data(skseResponse).error(null).build();
    }

    @GetMapping("/api/allskse")
    public WebResponse<List<SkseResponse>> findAll(
        @RequestHeader("USER-ID") String userid,
        @RequestParam("start") Long start,
        @RequestParam("size") Long size) {
    List<SkseResponse> response = skseService.findAll(userid, start, size); 

    return WebResponse.<List<SkseResponse>>builder().data(response).error(null).build();
    }

     @GetMapping("api/allskse/getskse")
    public WebResponse<List<SkseResponse>> findSkse(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("input") String input) {
        List<SkseResponse> response = skseService.findSkse(userid, input);

        return WebResponse.<List<SkseResponse>>builder().data(response).error(null).build();
    }

     @PutMapping("/api/allskse/editedskse")
    public WebResponse<SkseResponse> editedSkse(
            @RequestHeader("USER-ID") String userid,
            @RequestBody SkseRequest request,
            @RequestParam("input") String input) {
        SkseResponse skseResponse = skseService.editedSkse(userid, request, input);

        return WebResponse.<SkseResponse>builder().data(skseResponse).error(null).build();
    }
}
