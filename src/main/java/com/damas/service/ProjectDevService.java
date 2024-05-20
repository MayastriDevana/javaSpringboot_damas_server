package com.damas.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.model.ProjectDev;
import com.damas.model.User;
import com.damas.payload.ProjectDevRequest;
import com.damas.payload.ProjectDevResponse;
import com.damas.repository.ProjectDevRepository;
import com.damas.repository.UserRepository;

import jakarta.transaction.Transactional;
@Service
public class ProjectDevService {

    @Autowired 
    private ProjectDevRepository projectDevRepository;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private Environment env;

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public ProjectDevResponse newProject(ProjectDevRequest request, String token) {
        validationService.validateRequest(request);

        User user = userRepository.findFirstByToken(token)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has not login"));

        if (!user.getStatus().equals(env.getProperty("STATUS_GET_ACTIVE"))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This account is inActive");
        }

        ProjectDev projectDev = new ProjectDev();
        projectDev.setProjectname(request.getProjectname());
        projectDev.setPic(request.getPic());
        projectDev.setDeadline(request.getDeadline());
        projectDev.setStatus(request.getStatus());

        projectDevRepository.save(projectDev);

        return ProjectDevResponse.builder().projectname(projectDev.getProjectname()).pic(projectDev.getPic()).deadline(projectDev.getDeadline()).status(projectDev.getStatus()).build();
    }
}
