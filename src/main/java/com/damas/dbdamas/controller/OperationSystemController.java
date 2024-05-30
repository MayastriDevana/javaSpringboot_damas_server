package com.damas.dbdamas.controller;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.damas.dbdamas.payload.OperationSystemRequest;
import com.damas.dbdamas.payload.OperationSystemResponse;
import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.service.OperationSystemService;

@RestController
public class OperationSystemController {
    
    @Autowired
    private OperationSystemService operationSystemService;

    @PostMapping(
        path = "/api/operationsystem",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<OperationSystemResponse> newSystem(@RequestBody OperationSystemRequest request, @RequestHeader("X-API-TOKEN") String token){
        OperationSystemResponse operationSystemResponse = operationSystemService.newSystem(request, token);

        return WebResponse.<OperationSystemResponse>builder().data(operationSystemResponse).error(null).build();
    }
}
