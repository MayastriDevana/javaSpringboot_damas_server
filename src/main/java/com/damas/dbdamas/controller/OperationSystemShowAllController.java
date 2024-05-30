package com.damas.dbdamas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.damas.dbdamas.payload.OperationSystemResponse;
import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.service.OperationSystemShowAllService;

@RestController
public class OperationSystemShowAllController {
    @Autowired
    private OperationSystemShowAllService operationSystemShowAllService;

    @GetMapping("/api/systemshow")
    public WebResponse<List<OperationSystemResponse>> findAll(
        @RequestHeader("X-API-TOKEN") String token,
        @RequestParam("start") Long start,
        @RequestParam("size") Long size) {
    List<OperationSystemResponse> response = operationSystemShowAllService.findAll(token, start, size);

    return WebResponse.<List<OperationSystemResponse>>builder().data(response).error(null).build();

        }
    
}
