package com.damas.dbbcas_sdmdev.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbbcas_sdmdev.model.Users;
import com.damas.dbbcas_sdmdev.payload.DepartementResponse;
import com.damas.dbbcas_sdmdev.repository.UsersBcasRepository;
import com.damas.dbdamas.model.ProjectDev;
import com.damas.dbdamas.payload.ProjectDevResponse;
import com.damas.dbsecure.model.Tuser;
import com.damas.dbsecure.payload.UserResponse;
import com.damas.dbsecure.repository.UserSecureRepository;

import jakarta.transaction.Transactional;

@Service
public class UsersBcasService {
    @Autowired
    UsersBcasRepository usersBcasRepository;

    @Transactional
    public List<DepartementResponse> findNamaAndDeptInUsers(Long start, Long size) {
    
        List<Users> result = usersBcasRepository.findNamaAndDeptInUsers();

        if (result.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found!");
        }

        List<DepartementResponse> response = result.stream()
                .skip(start).limit(size)
                .map(item -> new DepartementResponse(
                   item.getCatapaid(),
                   item.getNama(),
                   item.getDepartement(),
                   result.size() 
                ))
                .collect((Collectors.toList()));

        return response;
    }

}
