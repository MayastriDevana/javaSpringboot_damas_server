package com.damas.dbdamas.controller;

import org.springframework.http.MediaType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.damas.dbdamas.payload.OperationServerRequest;
import com.damas.dbdamas.payload.OperationServerResponse;
import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.service.OperationServerService;

@RestController
public class OperationServerController {

    @Autowired
    private OperationServerService operationServerService;

    @PostMapping(
        path = "/api/operationserver",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<OperationServerResponse> newServer(@RequestBody OperationServerRequest request,
        @RequestHeader("USER-ID") String userid){
        OperationServerResponse operationServerResponse = operationServerService.newServer(request, userid);

            return WebResponse.<OperationServerResponse>builder().data(operationServerResponse).error(null).build();
        }
    
        @GetMapping("/api/servershow")
        public WebResponse<List<OperationServerResponse>> findAll(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size) {
        List<OperationServerResponse> response = operationServerService.findAll(userid, start, size);

        return WebResponse.<List<OperationServerResponse>>builder().data(response).error(null).build();
            }

    @GetMapping("/api/servershow/getserver")
    public WebResponse<List<OperationServerResponse>> findServer(
        @RequestHeader("USER-ID") String userid,
        @RequestParam ("input") String input) {
            List<OperationServerResponse> response = operationServerService.findServer(userid, input);

            return WebResponse.<List<OperationServerResponse>>builder().data(response).error(null).build();
        }

    @PutMapping("/api/servershow/editedserver")
    public WebResponse<OperationServerResponse> editedServer(
            @RequestHeader("USER-ID") String userid,
            @RequestBody OperationServerRequest request,
            @RequestParam ("input") String input){
        OperationServerResponse OperationServerResponse = operationServerService.editedServer(userid, request, input);

        return WebResponse.<OperationServerResponse>builder().data(OperationServerResponse).error(null).build();
    }
    
}
