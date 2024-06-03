package com.damas.dbbcassdmdev.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbbcassdmdev.model.Users;
import com.damas.dbbcassdmdev.payload.DepartementResponse;
import com.damas.dbbcassdmdev.repository.UsersBcasRepository;


import jakarta.transaction.Transactional;

@Service
public class UsersBcasService {
    @Autowired
    UsersBcasRepository usersBcasRepository;

    @Autowired
    ValidationBcasService validationBcasService;

    @Transactional
    public List<DepartementResponse> findNamaAndDeptInUsers(String userid) {
    validationBcasService.validateUsers(userid);

        List<Users> result = usersBcasRepository.findNamaAndDeptInUsers();

        if (result.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found!");
        }

        List<DepartementResponse> response = result.stream()
                .map(item -> new DepartementResponse(
                   item.getNama(),
                   item.getDepartemen()
                  
                ))
                .collect(Collectors.toList());

        return response;
    }

}
