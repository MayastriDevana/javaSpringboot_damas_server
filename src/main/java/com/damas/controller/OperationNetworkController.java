package com.damas.controller;

import org.springframework.http.MediaType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.damas.payload.OperationNetworkRequest;
import com.damas.payload.OperationNetworkResponse;
import com.damas.payload.WebResponse;
import com.damas.service.OperationNetworkService;

@RestController
public class OperationNetworkController {
    
    @Autowired
    private OperationNetworkService operationNetworkService;

    @PostMapping(
        path = "/api/operationnetwork",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<OperationNetworkResponse> newNetwork(@RequestBody OperationNetworkRequest request, @RequestHeader("X-API-TOKEN") String token){
        OperationNetworkResponse operationNetworkResponse = operationNetworkService.newNetwork(request, token);

        return WebResponse.<OperationNetworkResponse>builder().data(operationNetworkResponse).error(null).build();
    }

    @GetMapping("/api/networkshow")
    public WebResponse<List<OperationNetworkResponse>> findAll(
        @RequestHeader("X-API-TOKEN") String token,
        @RequestParam("start") Long start,
        @RequestParam("size") Long size) {
    List<OperationNetworkResponse> response = operationNetworkService.findAll(token, start, size);

    return WebResponse.<List<OperationNetworkResponse>>builder().data(response).error(null).build();
    
    }
}
