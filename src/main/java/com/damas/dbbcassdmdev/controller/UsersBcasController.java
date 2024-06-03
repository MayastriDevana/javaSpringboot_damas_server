package com.damas.dbbcassdmdev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.damas.dbbcassdmdev.payload.DepartementResponse;
import com.damas.dbbcassdmdev.service.UsersBcasService;
import com.damas.dbsecure.payload.WebResponse;

@RestController
public class UsersBcasController {
    @Autowired
    UsersBcasService usersBcasService;

    @GetMapping("/api/bcas-sdmdev/users")
    public WebResponse<List<DepartementResponse>> findNamaAndDeptInUsers( 
        @RequestHeader("USER-ID") String userid) {
        List<DepartementResponse> response = usersBcasService.findNamaAndDeptInUsers(userid);

        return WebResponse.<List<DepartementResponse>>builder().data(response).errors(null).build();
    }
}
