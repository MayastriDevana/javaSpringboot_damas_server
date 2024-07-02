package com.damas.dbdamas.controller.Operation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.damas.dbdamas.model.Operation.OperationItsecurityLog;
import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.payload.Operation.OperationItsecurityLogResponse;
import com.damas.dbdamas.service.Operation.OperationItsecurityLogService;

@RestController
public class OperationItsecurityLogController {
    @Autowired
    private OperationItsecurityLogService operationItsecurityLogService;

    @PostMapping("api/operationitsecurity/log")
    public WebResponse<String> createLog(
         @RequestHeader("USER-ID") String userid,
            @RequestBody OperationItsecurityLog request) {
        String response = operationItsecurityLogService.createLog(userid, request);

        return WebResponse.<String>builder().data(response).error(null).build();

    }

    @GetMapping("api/operationitsecuritylog")
    public WebResponse<List<OperationItsecurityLogResponse>> findAll(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size) {
        List<OperationItsecurityLogResponse> response = operationItsecurityLogService.findAll(userid, start, size);

        return WebResponse.<List<OperationItsecurityLogResponse>>builder().data(response).error(null).build();
    }

    @PutMapping("/api/operationitsecurity/log")
    public WebResponse<String> updateStatusLog(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("id") String id,
            @RequestParam("itsecurity_status") String itsecurity_status) {

        String response = operationItsecurityLogService.updateStatusLog(userid, id, itsecurity_status);

        return WebResponse.<String>builder().data(response).error(null).build();
    }

    //nyari log
    @GetMapping("api/operationitsecurity/getitsecuritylog")
    public WebResponse<List<OperationItsecurityLogResponse>> findLog(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("input") String input) {
        List<OperationItsecurityLogResponse> response = operationItsecurityLogService.findLog(userid, input);

        return WebResponse.<List<OperationItsecurityLogResponse>>builder().data(response).error(null).build();
    }
}
