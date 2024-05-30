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

        // Tuser Tuser = userSecureRepository.findUseridInUsers(userid)
        //         .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has not login"));

        // if (!Tuser.getStatus().equals(env.getProperty("STATUS_GET_ACTIVE"))) {
        //     throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This account is inActive");
        // }

        ProjectDev projectDev = new ProjectDev();
        projectDev.setProjectname(userid.getProjectname());
        projectDev.setPic(userid.getPic());
        projectDev.setDeadline(userid.getDeadline());
        projectDev.setStatus(userid.getStatus());

        projectDevRepository.save(projectDev);

        return ProjectDevResponse.builder().projectname(projectDev.getProjectname()).pic(projectDev.getPic())
                .deadline(projectDev.getDeadline()).status(projectDev.getStatus()).build();
    }

    @Transactional
    public List<ProjectDevResponse> findProject(String userid, String input) {

        validationService.validateRequest(userid);

        // if (input == "" || input == null || Objects.isNull(input) || input.equals("")) {
        //     throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid request");
        // }

        // User user = userSecureRepository.findFirstByToken(token)
        //         .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has not login"));

        // if (user.getTokenExpiredAt() < Instant.now().toEpochMilli()) {
        //     throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has logout by system");
        // }

        // if (!user.getStatus().equals(env.getProperty("STATUS_GET_ACTIVE"))) {
        //     throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This account is inActive");
        // }
        List<ProjectDev> projectByName = projectDevRepository.searchByNameorPic(input);

        List<ProjectDevResponse> response = projectByName.stream()
                .map(item -> new ProjectDevResponse(
                    item.getId(),
                        item.getProjectname(),
                        item.getPic(),
                        item.getDeadline(),
                        item.getStatus(),
                        projectByName.size()))
                .collect((Collectors.toList()));
        return response;
    }

    @Transactional
    public ProjectDevResponse editedProject(String userid, ProjectDevRequest request, String input) {

        validationService.validateRequest(userid);

        // User user = userRepository.findFirstByToken(token)
        //         .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has not login"));

        // if (!user.getStatus().equals(env.getProperty("STATUS_GET_ACTIVE"))) {
        //     throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This account is inActive");
        // }

        ProjectDev projectDev = projectDevRepository.findById(input)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found"));

        projectDev.setProjectname(request.getProjectname());
        projectDev.setPic(request.getPic());
        projectDev.setDeadline(request.getDeadline());
        projectDev.setStatus(request.getStatus());

        projectDevRepository.save(projectDev);

        return ProjectDevResponse.builder()
                .projectname(projectDev.getProjectname())
                .pic(projectDev.getPic())
                .deadline(projectDev.getDeadline())
                .status(projectDev.getStatus())
                .build();
    }

    @Transactional
    public List<ProjectDevResponse> findAll(String userid, Long start, Long size) {
        validationService.validateRequest(userid);

        // User user = userRepository.findFirstByToken(token)
        //         .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has not login"));

        // if (user.getTokenExpiredAt() < Instant.now().toEpochMilli()) {
        //     throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has logout by system");
        // }

        // if (!user.getStatus().equals(env.getProperty("STATUS_GET_ACTIVE"))) {
        //     throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This account is inActive");
        // }

        List<ProjectDev> projectDevAll = projectDevRepository.findAll();

        List<ProjectDevResponse> response = projectDevAll.stream()
                .skip(start).limit(size)
                .map(item -> new ProjectDevResponse(
                        item.getId(),
                        item.getProjectname(),
                        item.getPic(),
                        item.getDeadline(),
                        item.getStatus(),
                        projectDevAll.size()))
                .collect(Collectors.toList());

        return response;

    }

}
