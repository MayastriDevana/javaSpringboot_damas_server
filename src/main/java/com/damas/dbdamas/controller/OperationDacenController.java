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

import com.damas.dbdamas.payload.OperationDacenRequest;
import com.damas.dbdamas.payload.OperationDacenResponse;
import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.service.OperationDacenService;

@RestController
public class OperationDacenController {
    
    @Autowired
    private OperationDacenService operationDacenService;

    @PostMapping(
        path = "/api/operationdacen",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<OperationDacenResponse> newDacen(@RequestBody OperationDacenRequest request,
        @RequestHeader("USER-ID") String userid){
        OperationDacenResponse operationDacenResponse = operationDacenService.newDacen(request, userid);

            return WebResponse.<OperationDacenResponse>builder().data(operationDacenResponse).error(null).build();
        }
    
        @GetMapping("/api/dacenshow")
        public WebResponse<List<OperationDacenResponse>> findAll(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size) {
        List<OperationDacenResponse> response = operationDacenService.findAll(userid, start, size);

        return WebResponse.<List<OperationDacenResponse>>builder().data(response).error(null).build();
            }

    @GetMapping("/api/dacenshow/getdacen")
    public WebResponse<List<OperationDacenResponse>> findDacen(
        @RequestHeader("USER-ID") String userid,
        @RequestParam ("input") String input) {
            List<OperationDacenResponse> response = operationDacenService.findDacen(userid, input);

            return WebResponse.<List<OperationDacenResponse>>builder().data(response).error(null).build();
        }

    @PutMapping("/api/dacenshow/editeddacen")
    public WebResponse<OperationDacenResponse> editedDacen(
            @RequestHeader("USER-ID") String userid,
            @RequestBody OperationDacenRequest request,
            @RequestParam ("input") String input){
        OperationDacenResponse OperationDacenResponse = operationDacenService.editedDacen(userid, request, input);

        return WebResponse.<OperationDacenResponse>builder().data(OperationDacenResponse).error(null).build();
    }
}
