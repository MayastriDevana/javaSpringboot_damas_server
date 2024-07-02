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

import com.damas.dbdamas.model.Operation.OperationDacenLog;
import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.payload.Operation.OperationDacenLogResponse;
import com.damas.dbdamas.service.Operation.OperationDacenLogService;

@RestController
public class OperationDacenLogController {
    
    @Autowired
    private OperationDacenLogService operationDacenLogService;

    @PostMapping("api/operationdacen/log")
    public WebResponse<String> createLog(
         @RequestHeader("USER-ID") String userid,
            @RequestBody OperationDacenLog request) {
        String response = operationDacenLogService.createLog(userid, request);

        return WebResponse.<String>builder().data(response).error(null).build();

    }

    @GetMapping("api/operationdacenlog")
    public WebResponse<List<OperationDacenLogResponse>> findAll(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size) {
        List<OperationDacenLogResponse> response = operationDacenLogService.findAll(userid, start, size);

        return WebResponse.<List<OperationDacenLogResponse>>builder().data(response).error(null).build();
    }

    @PutMapping("/api/operationdacen/log")
    public WebResponse<String> updateStatusLog(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("id") String id,
            @RequestParam("dacen_status") String dacen_status) {

        String response = operationDacenLogService.updateStatusLog(userid, id, dacen_status);

        return WebResponse.<String>builder().data(response).error(null).build();
    }

    //nyari log
    @GetMapping("api/operationdacen/getdacenlog")
    public WebResponse<List<OperationDacenLogResponse>> findLog(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("input") String input) {
        List<OperationDacenLogResponse> response = operationDacenLogService.findLog(userid, input);

        return WebResponse.<List<OperationDacenLogResponse>>builder().data(response).error(null).build();
    }
}
