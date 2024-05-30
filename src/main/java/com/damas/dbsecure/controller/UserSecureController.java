package com.damas.dbsecure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.damas.dbsecure.payload.LoginSecureRequest;
import com.damas.dbsecure.payload.UserResponse;
import com.damas.dbsecure.payload.UsrAplikasiResponse;
import com.damas.dbsecure.payload.WebResponse;
import com.damas.dbsecure.service.UserSecureService;

@RestController
public class UserSecureController {
    @Autowired
    UserSecureService userSecureService;

    @PostMapping("/api/secure/login")
    public WebResponse<String> login(@RequestBody LoginSecureRequest request) {
        String response = userSecureService.login(request);

        return WebResponse.<String>builder().data(response).errors(null).build();
    }

    @PostMapping("/api/secure/logout")
    public WebResponse<String> logout(@RequestParam("userid") String userid) {
        String response = userSecureService.logout(userid);

        return WebResponse.<String>builder().data(response).errors(null).build();
    }

    @GetMapping("/api/secure/users")
    public WebResponse<UserResponse> findUseridInUsers( @RequestHeader("USER-ID") String userid) {
        UserResponse response = userSecureService.findUseridInUsers(userid);

        return WebResponse.<UserResponse>builder().data(response).errors(null).build();
    }
    
    @GetMapping("/api/secure/usraplikasi")
    public WebResponse<UsrAplikasiResponse> findUseridInUsrAplikasi( @RequestHeader("USER-ID") String userid) {
        UsrAplikasiResponse response = userSecureService.findUseridInUsrAplikasi(userid);

        return WebResponse.<UsrAplikasiResponse>builder().data(response).errors(null).build();
    }
}
