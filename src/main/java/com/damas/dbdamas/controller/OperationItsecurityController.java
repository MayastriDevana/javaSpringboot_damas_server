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

import com.damas.dbdamas.payload.OperationItsecurityRequest;
import com.damas.dbdamas.payload.OperationItsecurityResponse;
import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.service.OperationItsecurityService;



@RestController
public class OperationItsecurityController {

    @Autowired
    private OperationItsecurityService operationItsecurityService;

    @PostMapping(
        path = "/api/operationitsecurity",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<OperationItsecurityResponse> newItsecurity(@RequestBody OperationItsecurityRequest request,
        @RequestHeader("USER-ID") String userid){
        OperationItsecurityResponse operationItsecurityResponse = operationItsecurityService.newItsecurity(request, userid);

            return WebResponse.<OperationItsecurityResponse>builder().data(operationItsecurityResponse).error(null).build();
        }
    
        @GetMapping("/api/itsecurityshow")
        public WebResponse<List<OperationItsecurityResponse>> findAll(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size) {
        List<OperationItsecurityResponse> response = operationItsecurityService.findAll(userid, start, size);

        return WebResponse.<List<OperationItsecurityResponse>>builder().data(response).error(null).build();
            }

    @GetMapping("/api/itsecurityshow/getitsecurity")
    public WebResponse<List<OperationItsecurityResponse>> findItsecurity(
        @RequestHeader("USER-ID") String userid,
        @RequestParam ("input") String input) {
            List<OperationItsecurityResponse> response = operationItsecurityService.findItsecurity(userid, input);

            return WebResponse.<List<OperationItsecurityResponse>>builder().data(response).error(null).build();
        }

    @PutMapping("/api/itsecurityshow/editeditsecurity")
    public WebResponse<OperationItsecurityResponse> editedItsecurity(
            @RequestHeader("USER-ID") String userid,
            @RequestBody OperationItsecurityRequest request,
            @RequestParam ("input") String input){
        OperationItsecurityResponse OperationItsecurityResponse = operationItsecurityService.editedItsecurity(userid, request, input);

        return WebResponse.<OperationItsecurityResponse>builder().data(OperationItsecurityResponse).error(null).build();
    }
    
}
