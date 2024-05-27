package com.damas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.damas.payload.LogisticMemoRequest;
import com.damas.payload.LogisticMemoResponse;
import com.damas.payload.WebResponse;
import com.damas.service.LogisticMemoService;

@RestController
public class LogisticMemoController {

    @Autowired
    private LogisticMemoService logisticMemoService;


    @PostMapping(path = "/api/logisticmemo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<LogisticMemoResponse> newMemo(@RequestBody LogisticMemoRequest request,
            @RequestHeader("X-API-TOKEN") String token) {
        LogisticMemoResponse logisticMemoResponse = logisticMemoService.newMemo(request, token); // Use the instance
                                                                                                 // method

        return WebResponse.<LogisticMemoResponse>builder().data(logisticMemoResponse).error(null).build(); // Correct
                                                                                                           // generic
                                                                                                           // syntax
    }

    @GetMapping("/api/allmemo")
    public WebResponse<List<LogisticMemoResponse>> findAll(
            @RequestHeader("X-API-TOKEN") String token,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size) {
        List<LogisticMemoResponse> response = logisticMemoService.findAll(token, start, size);

        return WebResponse.<List<LogisticMemoResponse>>builder().data(response).error(null).build();
    }

    @PutMapping("/api/editmemo/{memoId}")
    public WebResponse<LogisticMemoResponse> editMemo(
            @PathVariable("memoId") String memoId,
            @RequestBody LogisticMemoRequest request,
            @RequestHeader("X-API-TOKEN") String token) {
        LogisticMemoResponse logisticMemoResponse = logisticMemoService.editMemo(memoId, request, token);

        return WebResponse.<LogisticMemoResponse>builder().data(logisticMemoResponse).error(null).build();
    }

}
