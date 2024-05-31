package com.damas.dbdamas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.damas.dbdamas.payload.LogisticMemoRequest;
import com.damas.dbdamas.payload.LogisticMemoResponse;
import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.service.LogisticMemoService;

import java.util.List;

@RestController
public class LogisticMemoController {

    @Autowired
    private LogisticMemoService logisticMemoService;

    @PostMapping(path = "/api/logisticmemo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<LogisticMemoResponse> newMemo(@RequestBody LogisticMemoRequest request,
            @RequestHeader("USER-ID") String userId) {
        LogisticMemoResponse logisticMemoResponse = logisticMemoService.newMemo(request, userId);
        return WebResponse.<LogisticMemoResponse>builder().data(logisticMemoResponse).error(null).build();
    }

    @GetMapping("/api/allmemo")
    public WebResponse<List<LogisticMemoResponse>> findAll(@RequestHeader("USER-ID") String userId,
            @RequestParam("start") Long start, @RequestParam("size") Long size) {
        List<LogisticMemoResponse> response = logisticMemoService.findAll(userId, start, size);
        return WebResponse.<List<LogisticMemoResponse>>builder().data(response).error(null).build();
    }

    @PutMapping("/api/editmemo")
    public WebResponse<LogisticMemoResponse> editMemo(@RequestParam("memoId") String memoId,
            @RequestHeader("USER-ID") String userId, @RequestBody LogisticMemoRequest request) {
        LogisticMemoResponse logisticMemoResponse = logisticMemoService.editMemo(memoId, request, userId);
        return WebResponse.<LogisticMemoResponse>builder().data(logisticMemoResponse).error(null).build();
    }

    @GetMapping("api/getMemoByID/{memoId}")
    public WebResponse<LogisticMemoResponse> getMemoById(@PathVariable("memoId") String memoId) {
        LogisticMemoResponse response = logisticMemoService.getMemoById(memoId);
        return WebResponse.<LogisticMemoResponse>builder().data(response).error(null).build();
    }

    @GetMapping("api/allmemo/getmemo")
    public WebResponse<List<LogisticMemoResponse>> findMemo(@RequestHeader("USER-ID") String userId,
            @RequestParam("input") String input) {
        List<LogisticMemoResponse> response = logisticMemoService.findMemo(userId, input);
        return WebResponse.<List<LogisticMemoResponse>>builder().data(response).error(null).build();
    }
}
