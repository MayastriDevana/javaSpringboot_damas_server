package com.damas.dbdamas.controller.Projectdev;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.damas.dbdamas.model.Projectdev.LogApproveProjectDev;
import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.payload.Projectdev.LogApproveProjectDevResponse;
import com.damas.dbdamas.service.Projectdev.LogApproveProjectDevService;

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

    @GetMapping("api/projectdevlog")
    public WebResponse<List<LogApproveProjectDevResponse>> findAll(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size) {
        List<LogApproveProjectDevResponse> response = logApproveProjectDevService.findAll(userid, start, size);

        return WebResponse.<List<LogApproveProjectDevResponse>>builder().data(response).error(null).build();
    }

    @PutMapping("/api/projectdev/log")
    public WebResponse<String> updateStatusLog(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("id") String id,
            @RequestParam("status") String status) {

        String response = logApproveProjectDevService.updateStatusLog(userid, id, status);

        return WebResponse.<String>builder().data(response).error(null).build();
    }

    //nyari log
    @GetMapping("api/projectdev/getprojectlog")
    public WebResponse<List<LogApproveProjectDevResponse>> findLog(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("input") String input) {
        List<LogApproveProjectDevResponse> response = logApproveProjectDevService.findLog(userid, input);

        return WebResponse.<List<LogApproveProjectDevResponse>>builder().data(response).error(null).build();
    }

}
