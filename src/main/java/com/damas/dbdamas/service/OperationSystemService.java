package com.damas.dbdamas.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.OperationSystem;
import com.damas.dbdamas.model.User;
import com.damas.dbdamas.payload.OperationSystemRequest;
import com.damas.dbdamas.payload.OperationSystemResponse;
import com.damas.dbdamas.repository.OperationSystemRepository;
import com.damas.dbdamas.repository.UserRepository;

import jakarta.transaction.Transactional;
@Service
public class OperationSystemService {
    
    @Autowired
    private OperationSystemRepository OperationSystemRepository;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private Environment env;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public OperationSystemResponse newSystem(OperationSystemRequest request, String token) {
        validationService.validateRequest(request);

        User user = userRepository.findFirstByToken(token)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has not login"));

        if (!user.getStatus().equals(env.getProperty("STATUS_GET_ACTIVE"))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This account is inActive");
        }

        OperationSystem operationSystem = new OperationSystem();
        operationSystem.setSystem_name(request.getSystem_name());
        operationSystem.setSystem_desc(request.getSystem_desc());
        operationSystem.setSystem_threshold_1(request.getSystem_threshold_1());
        operationSystem.setSystem_threshold_2(request.getSystem_threshold_2());
        operationSystem.setSystem_threshold_3(request.getSystem_threshold_3());

        OperationSystemRepository.save(operationSystem);

        return OperationSystemResponse.builder()
        .system_name(operationSystem.getSystem_name())
        .system_desc(operationSystem.getSystem_desc())
        .system_threshold_1(operationSystem.getSystem_threshold_1())
        .system_threshold_2(operationSystem.getSystem_threshold_2())
        .system_threshold_3(operationSystem.getSystem_threshold_3())
        .build();

    }
}
