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

import com.damas.dbdamas.payload.OperationItmoRequest;
import com.damas.dbdamas.payload.OperationItmoResponse;
import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.service.OperationItmoService;

@RestController
public class OperationItmoController {
    
    @Autowired
    private OperationItmoService operationItmoService;

    @PostMapping(
        path = "/api/operationitmo",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<OperationItmoResponse> newItmo(@RequestBody OperationItmoRequest request,
        @RequestHeader("USER-ID") String userid){
        OperationItmoResponse operationItmoResponse = operationItmoService.newItmo(request, userid);

            return WebResponse.<OperationItmoResponse>builder().data(operationItmoResponse).error(null).build();
        }
    
        @GetMapping("/api/itmoshow")
        public WebResponse<List<OperationItmoResponse>> findAll(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size) {
        List<OperationItmoResponse> response = operationItmoService.findAll(userid, start, size);

        return WebResponse.<List<OperationItmoResponse>>builder().data(response).error(null).build();
            }

    @GetMapping("/api/itmoshow/getitmo")
    public WebResponse<List<OperationItmoResponse>> findItmo(
        @RequestHeader("USER-ID") String userid,
        @RequestParam ("input") String input) {
            List<OperationItmoResponse> response = operationItmoService.findItmo(userid, input);

            return WebResponse.<List<OperationItmoResponse>>builder().data(response).error(null).build();
        }

    @PutMapping("/api/itmoshow/editeditmo")
    public WebResponse<OperationItmoResponse> editedItmo(
            @RequestHeader("USER-ID") String userid,
            @RequestBody OperationItmoRequest request,
            @RequestParam ("input") String input){
        OperationItmoResponse OperationItmoResponse = operationItmoService.editedItmo(userid, request, input);
                
        return WebResponse.<OperationItmoResponse>builder().data(OperationItmoResponse).error(null).build();
    }

     @GetMapping("/api/itmoshow/userdomainprojects")
    public WebResponse<List<OperationItmoResponse>> findByUserdomainOrderByDeadline(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size,
           @RequestParam("userdomain") String userdomain) {
        List<OperationItmoResponse> response = operationItmoService.findByUserdomainOrderByDeadline(userid, start, size,
                userdomain);
        return WebResponse.<List<OperationItmoResponse>>builder().data(response).error(null).build();
    }
}
