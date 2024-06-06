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

import com.damas.dbdamas.model.ProjectDev;
import com.damas.dbdamas.payload.ProjectDevRequest;
import com.damas.dbdamas.payload.ProjectDevResponse;
import com.damas.dbdamas.repository.ProjectDevRepository;
import com.damas.dbdamas.repository.UserRepository;
import com.damas.dbsecure.model.Tuser;
import com.damas.dbsecure.repository.UserSecureRepository;

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
    private UserSecureRepository userSecureRepository;

    @Transactional
    public ProjectDevResponse newProject(ProjectDevRequest userid, String token) {
        validationService.validateRequest(userid);

        ProjectDev projectDev = new ProjectDev();
        projectDev.setProjectname(userid.getProjectname());
        projectDev.setPic(userid.getPic());
        projectDev.setDepartement(userid.getDepartement());
        projectDev.setKickoff(userid.getKickoff());
        projectDev.setUserrequirement(userid.getUserrequirement());
        projectDev.setApplicationdevelopment(userid.getApplicationdevelopment());
        projectDev.setSit(userid.getSit());
        projectDev.setUat(userid.getUat());
        projectDev.setImplementationprepare(userid.getImplementationprepare());
        projectDev.setImplementationmeeting(userid.getImplementationmeeting());
        projectDev.setImplementation(userid.getImplementation());
        projectDev.setPostimplementationreview(userid.getPostimplementationreview());
        projectDev.setStatus(userid.getStatus());

        projectDevRepository.save(projectDev);

        return ProjectDevResponse.builder().projectname(projectDev.getProjectname()).pic(projectDev.getPic()).departement(projectDev.getDepartement()).kickoff((projectDev.getKickoff())).userrequirement(projectDev.getUserrequirement()).applicationdevelopment(projectDev.getApplicationdevelopment()).sit(projectDev.getSit()).uat(projectDev.getUat()).implementationprepare(projectDev.getImplementationprepare()).implementationmeeting(projectDev.getImplementationmeeting()).implementation(projectDev.getImplementation()).postimplementationreview(projectDev.getPostimplementationreview()).status(projectDev.getStatus()).build();
    }

    @Transactional
    public List<ProjectDevResponse> findProject(String userid, String input) {

        validationService.validateRequest(userid);

        List<ProjectDev> projectByName = projectDevRepository.searchByNameorPic(input);

        List<ProjectDevResponse> response = projectByName.stream()
                .map(item -> new ProjectDevResponse(
                    item.getId(),
                        item.getProjectname(),
                        item.getPic(),
                        item.getDepartement(),
                        item.getKickoff(),
                        item.getUserrequirement(),
                        item.getApplicationdevelopment(),
                        item.getSit(),
                        item.getUat(),
                        item.getImplementationprepare(),
                        item.getImplementationmeeting(),
                        item.getImplementation(),
                        item.getPostimplementationreview(),
                        item.getStatus(),
                        projectByName.size()))
                .collect((Collectors.toList()));
        return response;
    }

    @Transactional
    public ProjectDevResponse editedProject(String userid, ProjectDevRequest request, String input) {

        validationService.validateRequest(userid);


        ProjectDev projectDev = projectDevRepository.findById(input)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found"));

        projectDev.setProjectname(request.getProjectname());
        projectDev.setPic(request.getPic());
        projectDev.setDepartement(request.getDepartement());
        projectDev.setKickoff(request.getKickoff());
        projectDev.setUserrequirement(request.getUserrequirement());
        projectDev.setApplicationdevelopment(request.getApplicationdevelopment());
        projectDev.setSit(request.getSit());
        projectDev.setUat(request.getUat());
        projectDev.setImplementationprepare(request.getImplementationprepare());
        projectDev.setImplementationmeeting(request.getImplementationmeeting());
        projectDev.setImplementation(request.getImplementation());
        projectDev.setPostimplementationreview(request.getPostimplementationreview());
        projectDev.setStatus(request.getStatus());

        projectDevRepository.save(projectDev);

        return ProjectDevResponse.builder()
                .projectname(projectDev.getProjectname())
                .pic(projectDev.getPic())
                .departement(projectDev.getDepartement())
                .kickoff(projectDev.getKickoff())
                .userrequirement(projectDev.getUserrequirement())
                .applicationdevelopment(projectDev.getApplicationdevelopment())
                .sit(projectDev.getSit())
                .uat(projectDev.getUat())
                .implementationprepare(projectDev.getImplementationprepare())
                .implementationmeeting(projectDev.getImplementationmeeting())
                .implementation(projectDev.getImplementation())
                .postimplementationreview(projectDev.getPostimplementationreview())
                .status(projectDev.getStatus())
                .build();
    }

    @Transactional
    public List<ProjectDevResponse> findAll(String userid, Long start, Long size) {
        validationService.validateRequest(userid);

        List<ProjectDev> projectDevAll = projectDevRepository.findAll();

        List<ProjectDevResponse> response = projectDevAll.stream()
                .skip(start).limit(size)
                .map(item -> new ProjectDevResponse(
                        item.getId(),
                        item.getProjectname(),
                        item.getPic(),
                        item.getDepartement(),
                        item.getKickoff(),
                        item.getUserrequirement(),
                        item.getApplicationdevelopment(),
                        item.getSit(),
                        item.getUat(),
                        item.getImplementationprepare(),
                        item.getImplementationmeeting(),
                        item.getImplementation(),
                        item.getPostimplementationreview(),
                        item.getStatus(),
                        projectDevAll.size()))
                .collect(Collectors.toList());

        return response;

    }

}
