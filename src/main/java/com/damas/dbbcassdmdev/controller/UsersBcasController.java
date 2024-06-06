package com.damas.dbbcassdmdev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.damas.dbbcassdmdev.payload.UsersBcasResponse;
import com.damas.dbbcassdmdev.service.UsersBcasService;
import com.damas.dbdamas.payload.ProjectDevResponse;
import com.damas.dbsecure.payload.WebResponse;

@RestController
public class UsersBcasController {
    @Autowired
    UsersBcasService usersBcasService;

    @GetMapping("/api/bcas-sdmdev/users")
    public WebResponse<List<UsersBcasResponse>> findNamaAndDeptInUsers( 
        @RequestHeader("USER-ID") String userid) {
        List<UsersBcasResponse> response = usersBcasService.findNamaAndDeptInUsers(userid);

        return WebResponse.<List<UsersBcasResponse>>builder().data(response).errors(null).build();
    }

    

}
