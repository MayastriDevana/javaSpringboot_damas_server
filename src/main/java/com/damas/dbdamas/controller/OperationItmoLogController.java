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

import com.damas.dbdamas.model.OperationItmoLog;
import com.damas.dbdamas.payload.OperationItmoLogResponse;
import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.service.OperationItmoLogService;

@RestController
public class OperationItmoLogController {
    
    @Autowired
    private OperationItmoLogService operationItmoLogService;

    @PostMapping("api/operationitmo/log")
    public WebResponse<String> createLog(
         @RequestHeader("USER-ID") String userid,
            @RequestBody OperationItmoLog request) {
        String response = operationItmoLogService.createLog(userid, request);

        return WebResponse.<String>builder().data(response).error(null).build();

    }

    @GetMapping("api/operationitmolog")
    public WebResponse<List<OperationItmoLogResponse>> findAll(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size) {
        List<OperationItmoLogResponse> response = operationItmoLogService.findAll(userid, start, size);

        return WebResponse.<List<OperationItmoLogResponse>>builder().data(response).error(null).build();
    }

    @PutMapping("/api/operationitmo/log")
    public WebResponse<String> updateStatusLog(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("id") String id,
            @RequestParam("itmo_status") String itmo_status) {

        String response = operationItmoLogService.updateStatusLog(userid, id, itmo_status);

        return WebResponse.<String>builder().data(response).error(null).build();
    }

    //nyari log
    @GetMapping("api/operationitmo/getitmolog")
    public WebResponse<List<OperationItmoLogResponse>> findLog(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("input") String input) {
        List<OperationItmoLogResponse> response = operationItmoLogService.findLog(userid, input);

        return WebResponse.<List<OperationItmoLogResponse>>builder().data(response).error(null).build();
    }
}
