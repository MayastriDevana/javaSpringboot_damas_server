package com.damas.dbbcassdmdev.service;

import java.util.Set;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbbcassdmdev.repository.UsersBcasRepository;
import com.damas.dbsecure.model.Tuser;
import com.damas.dbsecure.repository.UserSecureRepository;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Service
public class ValidationBcasService {

    @Autowired
    private Validator validator;

    @Autowired
    UsersBcasRepository usersBcasRepository;

    @Autowired
    UserSecureRepository userSecureRepository;

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

}
