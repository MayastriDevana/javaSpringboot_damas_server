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

import com.damas.dbdamas.model.OperationNetworkLog;
import com.damas.dbdamas.payload.OperationNetworkLogResponse;
import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.service.OperationNetworkLogService;

@RestController
public class OperationNetworkLogController {
    
    @Autowired
    private OperationNetworkLogService operationNetworkLogService;

    @PostMapping("api/operationnetwork/log")
     public WebResponse<String> createLog(
            @RequestHeader("USER-ID") String userid,
            @RequestBody OperationNetworkLog request) {
        String response = operationNetworkLogService.createLog(userid, request);

        return WebResponse.<String>builder().data(response).error(null).build();

    }

    @GetMapping("api/operationnetworklog")
    public WebResponse<List<OperationNetworkLogResponse>> findAll(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size) {
        List<OperationNetworkLogResponse> response = operationNetworkLogService.findAll(userid, start, size);

        return WebResponse.<List<OperationNetworkLogResponse>>builder().data(response).error(null).build();
    }

    @PutMapping("/api/operationnetwork/log")
    public WebResponse<String> updateStatusLog(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("id") String id,
            @RequestParam("network_status") String network_status) {

        String response = operationNetworkLogService.updateStatusLog(userid, id, network_status);

        return WebResponse.<String>builder().data(response).error(null).build();
    }

    //nyari log
    @GetMapping("api/operationnetwork/getnetworklog")
    public WebResponse<List<OperationNetworkLogResponse>> findLog(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("input") String input) {
        List<OperationNetworkLogResponse> response = operationNetworkLogService.findLog(userid, input);

        return WebResponse.<List<OperationNetworkLogResponse>>builder().data(response).error(null).build();
    }

}
