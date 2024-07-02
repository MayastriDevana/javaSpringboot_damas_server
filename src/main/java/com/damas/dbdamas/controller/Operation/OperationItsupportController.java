package com.damas.dbdamas.controller.Operation;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.payload.Operation.OperationItsupportRequest;
import com.damas.dbdamas.payload.Operation.OperationItsupportResponse;
import com.damas.dbdamas.service.Operation.OperationItsupportService;

@RestController
public class OperationItsupportController {

    @Autowired
    private OperationItsupportService operationItsupportService;

    @PostMapping(path = "/api/operationitsupport", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<OperationItsupportResponse> newItsupport(@RequestBody OperationItsupportRequest request,
            @RequestHeader("USER-ID") String userid) {
        OperationItsupportResponse operationItsupportResponse = operationItsupportService.newItsupport(request, userid);

        return WebResponse.<OperationItsupportResponse>builder().data(operationItsupportResponse).error(null).build();
    }

    @GetMapping("/api/itsupportshow")
    public WebResponse<List<OperationItsupportResponse>> findAll(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size) {
        List<OperationItsupportResponse> response = operationItsupportService.findAll(userid, start, size);

        return WebResponse.<List<OperationItsupportResponse>>builder().data(response).error(null).build();
    }

    @GetMapping("/api/itsupportshow/getitsupport")
    public WebResponse<List<OperationItsupportResponse>> findItsupport(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("input") String input) {
        List<OperationItsupportResponse> response = operationItsupportService.findItsupport(userid, input);

        return WebResponse.<List<OperationItsupportResponse>>builder().data(response).error(null).build();
    }

    @PutMapping("/api/itsupportshow/editeditsupport")
    public WebResponse<OperationItsupportResponse> editedItsupport(
            @RequestHeader("USER-ID") String userid,
            @RequestBody OperationItsupportRequest request,
            @RequestParam("input") String input) {
        OperationItsupportResponse OperationItsupportResponse = operationItsupportService.editedItsupport(userid,
                request, input);

        return WebResponse.<OperationItsupportResponse>builder().data(OperationItsupportResponse).error(null).build();
    }

    @GetMapping("/api/itsupportshow/userdomainprojects")
    public WebResponse<List<OperationItsupportResponse>> findByUserdomainOrderByDeadline(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size,
            @RequestParam("userdomain") String userdomain) {
        List<OperationItsupportResponse> response = operationItsupportService.findByUserdomainOrderByDeadline(userid, start, size,
                userdomain);
        return WebResponse.<List<OperationItsupportResponse>>builder().data(response).error(null).build();
    }
}