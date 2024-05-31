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
        projectPhase.setNopmo(userid.getNopmo());
        projectPhase.setProjectname(userid.getProjectname());
        projectPhase.setPhase(userid.getPhase());
        projectPhase.setPic(userid.getPic());
        projectPhase.setDepartement(userid.getDepartement());
        projectPhase.setTeam(userid.getTeam());
        projectPhase.setDeadline(userid.getDeadline());
        projectPhase.setStatus(userid.getStatus());

        projectPhaseRepository.save(projectPhase);

        return ProjectPhaseResponse.builder().nopmo(projectPhase.getNopmo()).projectname(projectPhase.getProjectname()).phase(projectPhase.getPhase()).pic(projectPhase.getPic()).departement(projectPhase.getDepartement()).team(projectPhase.getTeam()).deadline(projectPhase.getDeadline()).status(projectPhase.getStatus()).build();
    }

    // @Transactional
    // public List<ProjectDevResponse> findProject(String userid, String input) {

    //     validationService.validateRequest(userid);
    //     List<ProjectDev> projectByName = projectDevRepository.searchByNameorPic(input);

    //     List<ProjectDevResponse> response = projectByName.stream()
    //             .map(item -> new ProjectDevResponse(
    //                 item.getId(),
    //                     item.getProjectname(),
    //                     item.getPic(),
    //                     item.getDeadline(),
    //                     item.getStatus(),
    //                     projectByName.size()))
    //             .collect((Collectors.toList()));
    //     return response;
    // }

    // @Transactional
    // public ProjectDevResponse editedProject(String userid, ProjectDevRequest request, String input) {

    //     validationService.validateRequest(userid);


    //     ProjectDev projectDev = projectDevRepository.findById(input)
    //             .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found"));

    //     projectDev.setProjectname(request.getProjectname());
    //     projectDev.setPic(request.getPic());
    //     projectDev.setDeadline(request.getDeadline());
    //     projectDev.setStatus(request.getStatus());

    //     projectDevRepository.save(projectDev);

    //     return ProjectDevResponse.builder()
    //             .projectname(projectDev.getProjectname())
    //             .pic(projectDev.getPic())
    //             .deadline(projectDev.getDeadline())
    //             .status(projectDev.getStatus())
    //             .build();
    // }

    // @Transactional
    // public List<ProjectDevResponse> findAll(String userid, Long start, Long size) {
    //     validationService.validateRequest(userid);

     

    //     List<ProjectDev> projectDevAll = projectDevRepository.findAll();

    //     List<ProjectDevResponse> response = projectDevAll.stream()
    //             .skip(start).limit(size)
    //             .map(item -> new ProjectDevResponse(
    //                     item.getId(),
    //                     item.getProjectname(),
    //                     item.getPic(),
    //                     item.getDeadline(),
    //                     item.getStatus(),
    //                     projectDevAll.size()))
    //             .collect(Collectors.toList());

    //     return response;

    // }

}
