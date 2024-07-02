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

import com.damas.dbdamas.model.Projectdev.LogApproveSkse;
import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.payload.Projectdev.LogApproveSkseResponse;
import com.damas.dbdamas.service.Projectdev.LogApproveSkseService;

@RestController
public class LogApproveSkseController {
    
    @Autowired
    private LogApproveSkseService logApproveSkseService;

    @PostMapping("/api/skse/log")
    public WebResponse<String> createLog(
        @RequestHeader("USER-ID") String userid,
        @RequestBody LogApproveSkse request) {
            String response = logApproveSkseService.createLog(userid, request);

            return WebResponse.<String>builder().data(response).error(null).build();

        }

    @GetMapping("api/skselog")
    public WebResponse<List<LogApproveSkseResponse>> findAll(
        @RequestHeader("USER-ID") String userid,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size) {
            List<LogApproveSkseResponse> response = logApproveSkseService.findAll(userid, start, size);
            return WebResponse.<List<LogApproveSkseResponse>>builder().data(response).error(null).build();
        }

     @PutMapping("/api/skse/log")
    public WebResponse<String> updateStatusLog(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("id") String id,
            @RequestParam("status") String status
            ) {

         String response = logApproveSkseService.updateStatusLog(userid, id, status);

        return WebResponse.<String>builder().data(response).error(null).build();
    }   

     //nyari log skse
    @GetMapping("api/skse/getskselog")
    public WebResponse<List<LogApproveSkseResponse>> findLog(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("input") String input) {
        List<LogApproveSkseResponse> response = logApproveSkseService.findLog(userid, input);

        return WebResponse.<List<LogApproveSkseResponse>>builder().data(response).error(null).build();
    }
    
    
}
