package com.damas.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.model.ProjectDev;
import com.damas.model.User;
import com.damas.payload.ProjectDevResponse;
import com.damas.repository.ProjectDevRepository;
import com.damas.repository.UserRepository;

@Service
public class AllProjectService {

@Autowired
private ProjectDevRepository projectDevRepository;

@Autowired
private UserRepository userRepository;

@Autowired
private ValidationService validationService;

@Autowired
private Environment env;

public List<ProjectDevResponse> findAll(String token, Long start, Long size) {
    validationService.validateRequest(token);

    User user = userRepository.findFirstByToken(token)
    .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has not login"));

    if (user.getTokenExpiredAt() < Instant.now().toEpochMilli()) {
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has logout by system");
    }

    if (!user.getStatus().equals(env.getProperty("STATUS_GET_ACTIVE"))) {
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This account is inActive");
    }

    List<ProjectDev> projectDevAll = projectDevRepository.findAll();

    List<ProjectDevResponse> response = projectDevAll.stream()
    .skip(start).limit(size)
    .map(item -> new ProjectDevResponse(
        item.getProjectname(),
        item.getPic(),
        item.getDeadline(),
        item.getStatus(),
        projectDevAll.size()
        ))
    .collect(Collectors.toList());

        return response;

    }
}
