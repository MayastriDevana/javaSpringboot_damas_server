package com.damas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.damas.payload.OperationNetworkResponse;
import com.damas.payload.WebResponse;
import com.damas.service.OperationNetworkShowAllService;

@RestController
public class OperationNetworkShowAllController {
    @Autowired
    private OperationNetworkShowAllService operationNetworkShowAllService;

    @GetMapping("/api/networkshow")
    public WebResponse<List<OperationNetworkResponse>> findAll(
        @RequestHeader("X-API-TOKEN") String token,
        @RequestParam("start") Long start,
        @RequestParam("size") Long size) {
    List<OperationNetworkResponse> response = operationNetworkShowAllService.findAll(token, start, size);

    return WebResponse.<List<OperationNetworkResponse>>builder().data(response).error(null).build();
    
    }
}
