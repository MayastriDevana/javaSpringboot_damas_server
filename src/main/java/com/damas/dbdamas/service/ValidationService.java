package com.damas.dbdamas.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbsecure.model.Tuser;
import com.damas.dbsecure.payload.UsrAplikasiResponse;
import com.damas.dbsecure.repository.UserSecureRepository;
import com.damas.dbsecure.service.UserSecureService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Service
public class ValidationService {

    @Autowired
    private Validator validator;

    @Autowired
    UserSecureRepository userSecureRepository;

    @Autowired
    UserSecureService userSecureService;

    @Autowired
    private Environment env;

    public void validateRequest(Object request) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(request);

        if (constraintViolations.size() != 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid request");
        }
    }

    public void validateUsers(String userid) {
        if (userid.isEmpty() || userid.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid request!");
        }

        List<Tuser> users = userSecureRepository.findUseridInUsers(userid);

        if (users.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found!");
        }

        if (!(users.getFirst().getStatus().equals(1))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }
    }

    public Boolean isOperator(String userid) {
        UsrAplikasiResponse userAplikasi = userSecureService.findUseridInUsrAplikasi(userid);

        String groupAkses = userAplikasi.getGroupakses();

        if (groupAkses.equals(env.getProperty("USER_OPERATOR"))) {
            return true;
        }

        return false;
    }

    public Boolean isSupervisor(String userid) {
        UsrAplikasiResponse userAplikasi = userSecureService.findUseridInUsrAplikasi(userid);

        String groupAkses = userAplikasi.getGroupakses();

        if (groupAkses.equals(env.getProperty("USER_SUPERVISOR"))) {
            return true;
        }

        return false;
    }

    public Boolean isDevSupervisor(String userid) {
        UsrAplikasiResponse userAplikasi = userSecureService.findUseridInUsrAplikasi(userid);

        String groupAkses = userAplikasi.getGroupakses();

        if (groupAkses.equals(env.getProperty("USER_DEV_SUPERVISOR"))) {
            return true;
        }

        return false;
    }

    public Boolean isPpoSupervisor(String userid) {
        UsrAplikasiResponse userAplikasi = userSecureService.findUseridInUsrAplikasi(userid);

        String groupAkses = userAplikasi.getGroupakses();

        if (groupAkses.equals(env.getProperty("USER_PPO_SUPERVISOR"))) {
            return true;
        }

        return false;
    }

    public Boolean isOperationSupervisor(String userid) {
        UsrAplikasiResponse userAplikasi = userSecureService.findUseridInUsrAplikasi(userid);

        String groupAkses = userAplikasi.getGroupakses();

        if (groupAkses.equals(env.getProperty("USER_OPERATION_SUPERVISOR"))) {
            return true;
        }

        return false;
    }

    public Boolean isLogisticSupervisor(String userid) {
        UsrAplikasiResponse userAplikasi = userSecureService.findUseridInUsrAplikasi(userid);

        String groupAkses = userAplikasi.getGroupakses();

        if (groupAkses.equals(env.getProperty("USER_LOGISTIC_SUPERVISOR"))) {
            return true;
        }

        return false;
    }

    public Boolean isReviewerSupervisor(String userid) {
        UsrAplikasiResponse userAplikasi = userSecureService.findUseridInUsrAplikasi(userid);

        String groupAkses = userAplikasi.getGroupakses();

        if (groupAkses.equals(env.getProperty("USER_REVIEWER_SUPERVISOR"))) {
            return true;
        }

        return false;
    }

    public Boolean isDevOperator(String userid) {
        UsrAplikasiResponse userAplikasi = userSecureService.findUseridInUsrAplikasi(userid);

        String groupAkses = userAplikasi.getGroupakses();

        if (groupAkses.equals(env.getProperty("USER_DEV_OPERATOR"))) {
            return true;
        }

        return false;
    }

    public Boolean isPpoOperator(String userid) {
        UsrAplikasiResponse userAplikasi = userSecureService.findUseridInUsrAplikasi(userid);

        String groupAkses = userAplikasi.getGroupakses();

        if (groupAkses.equals(env.getProperty("USER_PPO_OPERATOR"))) {
            return true;
        }

        return false;
    }

    public Boolean isSkseOperator(String userid) {
        UsrAplikasiResponse userAplikasi = userSecureService.findUseridInUsrAplikasi(userid);

        String groupAkses = userAplikasi.getGroupakses();

        if (groupAkses.equals(env.getProperty("USER_SKSE_OPERATOR"))) {
            return true;
        }

        return false;
    }

    public Boolean isNetworkOperator(String userid) {
        UsrAplikasiResponse userAplikasi = userSecureService.findUseridInUsrAplikasi(userid);

        String groupAkses = userAplikasi.getGroupakses();

        if (groupAkses.equals(env.getProperty("USER_NETWORK_OPERATOR"))) {
            return true;
        }

        return false;
    }

    public Boolean isServerOperator(String userid) {
        UsrAplikasiResponse userAplikasi = userSecureService.findUseridInUsrAplikasi(userid);

        String groupAkses = userAplikasi.getGroupakses();

        if (groupAkses.equals(env.getProperty("USER_SERVER_OPERATOR"))) {
            return true;
        }

        return false;
    }

    public Boolean isDacenOperator(String userid) {
        UsrAplikasiResponse userAplikasi = userSecureService.findUseridInUsrAplikasi(userid);

        String groupAkses = userAplikasi.getGroupakses();

        if (groupAkses.equals(env.getProperty("USER_DACEN_OPERATOR"))) {
            return true;
        }

        return false;
    }

    public Boolean isItsupportOperator(String userid) {
        UsrAplikasiResponse userAplikasi = userSecureService.findUseridInUsrAplikasi(userid);

        String groupAkses = userAplikasi.getGroupakses();

        if (groupAkses.equals(env.getProperty("USER_ITSUPPORT_OPERATOR"))) {
            return true;
        }

        return false;
    }

    public Boolean isItmoOperator(String userid) {
        UsrAplikasiResponse userAplikasi = userSecureService.findUseridInUsrAplikasi(userid);

        String groupAkses = userAplikasi.getGroupakses();

        if (groupAkses.equals(env.getProperty("USER_ITMO_OPERATOR"))) {
            return true;
        }

        return false;
    }

    public Boolean isItsecurityOperator(String userid) {
        UsrAplikasiResponse userAplikasi = userSecureService.findUseridInUsrAplikasi(userid);

        String groupAkses = userAplikasi.getGroupakses();

        if (groupAkses.equals(env.getProperty("USER_ITSECURITY_OPERATOR"))) {
            return true;
        }

        return false;
    }

    public Boolean isLogisticOperator(String userid) {
        UsrAplikasiResponse userAplikasi = userSecureService.findUseridInUsrAplikasi(userid);

        String groupAkses = userAplikasi.getGroupakses();

        if (groupAkses.equals(env.getProperty("USER_LOGISTIC_OPERATOR"))) {
            return true;
        }

        return false;
    }
}
