package com.damas.dbdamas.controller.Operation;

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

import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.payload.Operation.OperationNetworkRequest;
import com.damas.dbdamas.payload.Operation.OperationNetworkResponse;
import com.damas.dbdamas.service.Operation.OperationNetworkService;

@RestController
public class OperationNetworkController {
    
    @Autowired
    private OperationNetworkService operationNetworkService;

    @PostMapping(
        path = "/api/operationnetwork",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<OperationNetworkResponse> newNetwork(@RequestBody OperationNetworkRequest request, 
        @RequestHeader("USER-ID") String userid){
        OperationNetworkResponse operationNetworkResponse = operationNetworkService.newNetwork(request, userid);

        return WebResponse.<OperationNetworkResponse>builder().data(operationNetworkResponse).error(null).build();
    }

    @GetMapping("/api/networkshow")
    public WebResponse<List<OperationNetworkResponse>> findAll(
        @RequestHeader("USER-ID") String userid,
        @RequestParam("start") Long start,
        @RequestParam("size") Long size) {
    List<OperationNetworkResponse> response = operationNetworkService.findAll(userid, start, size);

    return WebResponse.<List<OperationNetworkResponse>>builder().data(response).error(null).build();
    
    }

    @GetMapping("/api/networkshow/getnetwork")
    public WebResponse<List<OperationNetworkResponse>> findNetwork(
        @RequestHeader("USER-ID") String userid,
        @RequestParam ("input") String input) {
            List<OperationNetworkResponse> response = operationNetworkService.findNetwork(userid, input);

            return WebResponse.<List<OperationNetworkResponse>>builder().data(response).error(null).build();
        }

    @PutMapping("/api/networkshow/editednetwork")
    public WebResponse<OperationNetworkResponse> editedNetwork(
            @RequestHeader("USER-ID") String userid,
            @RequestBody OperationNetworkRequest request,
            @RequestParam ("input") String input){
        OperationNetworkResponse OperationNetworkResponse = operationNetworkService.editedNetwork(userid, request, input);

        return WebResponse.<OperationNetworkResponse>builder().data(OperationNetworkResponse).error(null).build();
    }

     @GetMapping("/api/networkshow/userdomainprojects")
    public WebResponse<List<OperationNetworkResponse>> findByUserdomainOrderByDeadline(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size,
           @RequestParam("userdomain") String userdomain) {
        List<OperationNetworkResponse> response = operationNetworkService.findByUserdomainOrderByDeadline(userid, start, size,
                userdomain);
        return WebResponse.<List<OperationNetworkResponse>>builder().data(response).error(null).build();
    }
}