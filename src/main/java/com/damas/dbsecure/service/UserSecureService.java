package com.damas.dbsecure.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbsecure.model.Tuser;
import com.damas.dbsecure.model.UsrAplikasi;
import com.damas.dbsecure.payload.LoginSecureRequest;
import com.damas.dbsecure.payload.UserResponse;
import com.damas.dbsecure.payload.UsrAplikasiResponse;
import com.damas.dbsecure.repository.UserSecureRepository;
import com.damas.dbsecure.repository.UsrAplikasiRepository;

import jakarta.transaction.Transactional;

@Service
public class UserSecureService {
    @Autowired
    UserSecureRepository userSecureRepository;

    @Autowired
    UsrAplikasiRepository usrAplikasiRepository;

    @Autowired
    private ValidationSecureService validationSecureService;


    @Transactional
    public String login(LoginSecureRequest request) {
        validationSecureService.validateRequest(request);

        List<String> response = userSecureRepository.loginSecure(request.getUserid(), request.getPass());

        if (response.getFirst().equals("20UidApplNotListed")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "userid not registered!");
        }

        if (response.getFirst().equals("30UidNotAktif")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "userid not active!");
        }

        if (response.getFirst().equals("40UidAlreadyInUse")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "userid already in use!");
        }

        if (response.getFirst().equals("50UidExpired")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "userid expired!");
        }

        if (response.getFirst().equals("60UidPassNotMatched")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "password invalid!");
        }

        if (response.getFirst().equals("70UidBlokir")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "userid is blocked!");
        }

        return "login success";
    }

    @Transactional
    public String logout(String userid) {
        if (userid.isEmpty() || userid.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid request!");
        }

        try {
            userSecureRepository.logoutSecure(userid);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Logout failed!");
        }

        return "logout success";
    }

    @Transactional
    public UserResponse findUseridInUsers(String userid) {
        if (userid.isEmpty() || userid.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid request!");
        }

        List<Tuser> result = userSecureRepository.findUseridInUsers(userid);

        if (result.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found!");
        }

        List<UserResponse> response = result.stream()
        .map(item -> new UserResponse(
                item.getUserid(),
                item.getUsername(),
                item.getLevel(),
                item.getLastLogin(),
                item.getExpire(),
                item.getStatus(),
                item.getIsaktif(),
                item.getKaryawan(),
                item.getDomain(),
                item.getBranch(),
                item.getUserdomain())).collect(Collectors.toList());

        return response.getFirst();
    }

    @Transactional
    public UsrAplikasiResponse findUseridInUsrAplikasi(String userid) {
        if (userid.isEmpty() || userid.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid request!");
        }

        List<UsrAplikasi> result = usrAplikasiRepository.findUseridInUsrAplikasi(userid);

        if (result.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found!");
        }

        List<UsrAplikasiResponse> response = result.stream().map(item -> new UsrAplikasiResponse(
                item.getKodeaplikasi(),
                item.getUserid(),
                item.getGroupakses(),
                item.getLocked(),
                item.getSession())).collect(Collectors.toList());

        return response.getFirst();
    }
}
