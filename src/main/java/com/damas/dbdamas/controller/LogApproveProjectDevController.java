package com.damas.dbdamas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.damas.dbdamas.model.LogApproveProjectDev;
import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.service.LogApproveProjectDevService;

@RestController
public class LogApproveProjectDevController {
    
    @Autowired
    private LogApproveProjectDevService logApproveProjectDevService;

    @PostMapping("/api/projectdev/log")
    public WebResponse<String> createLog(
        @RequestHeader("USER-ID") String userid,
        @RequestBody LogApproveProjectDev request) {
            String response = logApproveProjectDevService.createLog(userid, request);

            return WebResponse.<String>builder().data(response).error(null).build();

        }

    @GetMapping("api/projectdev/log")
    public WebResponse<List<LogApproveProjectDev>> getAllLog(
        @RequestHeader("USER-ID") String userid) {
            List<LogApproveProjectDev> response = logApproveProjectDevService.getAllLog(userid);
            return WebResponse.<List<LogApproveProjectDev>>builder().data(response).error(null).build();
        }

     @PutMapping("/api/projectdev/log")
    public WebResponse<String> updateStatusLog(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("id") String id,
            @RequestParam("status") String status
            ) {

         String response = logApproveProjectDevService.updateStatusLog(userid, id, status);

        return WebResponse.<String>builder().data(response).error(null).build();
    }   
    
    
}
