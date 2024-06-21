package com.damas.dbdamas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.damas.dbdamas.model.OperationServerLog;
import com.damas.dbdamas.payload.OperationServerLogResponse;
import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.service.OperationServerLogService;

@RestController
public class OperationServerLogController {
    
    @Autowired
    private OperationServerLogService operationServerLogService;

    @PostMapping("/api/operationserver/log")
    public WebResponse<String> createLog(
         @RequestHeader("USER-ID") String userid,
            @RequestBody OperationServerLog request) {
        String response = operationServerLogService.createLog(userid, request);

        return WebResponse.<String>builder().data(response).error(null).build();

    }

    @GetMapping("api/operationserverlog")
    public WebResponse<List<OperationServerLogResponse>> findAll(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size) {
        List<OperationServerLogResponse> response = operationServerLogService.findAll(userid, start, size);

        return WebResponse.<List<OperationServerLogResponse>>builder().data(response).error(null).build();
    }

    @PutMapping("/api/operationserver/log")
    public WebResponse<String> updateStatusLog(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("id") String id,
            @RequestParam("server_status") String server_status) {

        String response = operationServerLogService.updateStatusLog(userid, id, server_status);

        return WebResponse.<String>builder().data(response).error(null).build();
    }

    //nyari log
    @GetMapping("api/operationserver/getserverlog")
    public WebResponse<List<OperationServerLogResponse>> findLog(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("input") String input) {
        List<OperationServerLogResponse> response = operationServerLogService.findLog(userid, input);

        return WebResponse.<List<OperationServerLogResponse>>builder().data(response).error(null).build();
    }

    
}
