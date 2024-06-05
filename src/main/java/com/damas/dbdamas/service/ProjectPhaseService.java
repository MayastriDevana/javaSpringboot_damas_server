package com.damas.dbdamas.service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.ProjectPhase;
import com.damas.dbdamas.payload.ProjectPhaseRequest;
import com.damas.dbdamas.payload.ProjectPhaseResponse;
import com.damas.dbdamas.repository.ProjectDevRepository;
import com.damas.dbdamas.repository.ProjectPhaseRepository;

import com.damas.dbsecure.repository.UserSecureRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjectPhaseService {

    @Autowired
    private ProjectPhaseRepository projectPhaseRepository;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private Environment env;

    @Autowired
    private UserSecureRepository userSecureRepository;

    @Transactional
    public ProjectPhaseResponse newPhase(ProjectPhaseRequest userid, String token) {
        validationService.validateRequest(userid);

        ProjectPhase projectPhase = new ProjectPhase();
        projectPhase.setKickoff(userid.getKickoff());
        projectPhase.setUserrequirement(userid.getUserrequirement());
        projectPhase.setApplicationdevelopment(userid.getApplicationdevelopment());
        projectPhase.setSit(userid.getSit());
        projectPhase.setUat(userid.getUat());
        projectPhase.setImplementationprepare(userid.getImplementationprepare());
        projectPhase.setImplementationmeeting(userid.getImplementationmeeting());
        projectPhase.setImplementation(userid.getImplementation());
        projectPhase.setPostimplementationreview(userid.getPostimplementationreview());
        projectPhaseRepository.save(projectPhase);

        return ProjectPhaseResponse.builder().kickoff(projectPhase.getKickoff()).userrequirement(projectPhase.getUserrequirement()).applicationdevelopment(projectPhase.getApplicationdevelopment()).sit(projectPhase.getSit()).uat(projectPhase.getUat()).implementationprepare(projectPhase.getImplementationprepare()).implementationmeeting(projectPhase.getImplementationmeeting()).implementation(projectPhase.getImplementation()).postimplementationreview(projectPhase.getPostimplementationreview()).build();
    }

  
}
