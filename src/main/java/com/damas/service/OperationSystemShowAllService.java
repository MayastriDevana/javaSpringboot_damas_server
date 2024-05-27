package com.damas.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.model.OperationSystem;
import com.damas.model.User;
import com.damas.payload.OperationSystemResponse;
import com.damas.repository.OperationSystemRepository;
import com.damas.repository.UserRepository;

@Service
public class OperationSystemShowAllService {

@Autowired
private UserRepository userRepository;

@Autowired
private OperationSystemRepository operationSystemRepository;

@Autowired
private ValidationService validationService;

@Autowired
private Environment env;

public List<OperationSystemResponse> findAll(String token, Long start, Long size) {
        validationService.validateRequest(token);

        User user = userRepository.findFirstByToken(token)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has not login"));

        if (user.getTokenExpiredAt() < Instant.now().toEpochMilli()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has logout by system");
        }

        if (!user.getStatus().equals(env.getProperty("STATUS_GET_ACTIVE"))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This account is inActive");
        }

        List<OperationSystem> operationSystemShowAll = operationSystemRepository.findAll();
        
        List<OperationSystemResponse> response = operationSystemShowAll.stream()
        .skip(start).limit(size)
        .map(item -> new OperationSystemResponse(
            item.getSystem_name(),
            item.getSystem_desc(),
            item.getSystem_threshold_1(),
            item.getSystem_threshold_2(),
            item.getSystem_threshold_3(),
            operationSystemShowAll.size()
        ))
    .collect(Collectors.toList());

        return response;

}
    
}
