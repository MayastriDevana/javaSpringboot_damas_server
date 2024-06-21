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

import com.damas.dbdamas.model.OperationItsupportLog;
import com.damas.dbdamas.payload.OperationItsupportLogResponse;
import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.service.OperationItsupportLogService;

@RestController
public class OperationItsupportLogController {
    @Autowired
    private OperationItsupportLogService operationItsupportLogService;

    @PostMapping("api/operationitsupport/log")
    public WebResponse<String> createLog(
         @RequestHeader("USER-ID") String userid,
            @RequestBody OperationItsupportLog request) {
        String response = operationItsupportLogService.createLog(userid, request);

        return WebResponse.<String>builder().data(response).error(null).build();

    }

    @GetMapping("api/operationitsupportlog")
    public WebResponse<List<OperationItsupportLogResponse>> findAll(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size) {
        List<OperationItsupportLogResponse> response = operationItsupportLogService.findAll(userid, start, size);

        return WebResponse.<List<OperationItsupportLogResponse>>builder().data(response).error(null).build();
    }

    @PutMapping("/api/operationitsupport/log")
    public WebResponse<String> updateStatusLog(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("id") String id,
            @RequestParam("itsupport_status") String itsupport_status) {

        String response = operationItsupportLogService.updateStatusLog(userid, id, itsupport_status);

        return WebResponse.<String>builder().data(response).error(null).build();
    }

    //nyari log
    @GetMapping("api/operationitsupport/getitsupportlog")
    public WebResponse<List<OperationItsupportLogResponse>> findLog(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("input") String input) {
        List<OperationItsupportLogResponse> response = operationItsupportLogService.findLog(userid, input);

        return WebResponse.<List<OperationItsupportLogResponse>>builder().data(response).error(null).build();
    }
}
