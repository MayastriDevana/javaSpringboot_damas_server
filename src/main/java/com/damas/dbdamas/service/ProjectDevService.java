package com.damas.dbdamas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.ProjectDev;
import com.damas.dbdamas.payload.ProjectDevRequest;
import com.damas.dbdamas.payload.ProjectDevResponse;
import com.damas.dbdamas.repository.ProjectDevRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjectDevService {

    @Autowired
    private ProjectDevRepository projectDevRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public ProjectDevResponse newProject(ProjectDevRequest userid, String token) {
        validationService.validateRequest(userid);

        ProjectDev projectDev = new ProjectDev();
        projectDev.setProjectname(userid.getProjectname());
        projectDev.setPic(userid.getPic());
        projectDev.setDepartement(userid.getDepartement());
        projectDev.setKickoffstart(userid.getKickoffstart());
        projectDev.setKickoffdeadline(userid.getKickoffdeadline());
        projectDev.setKickoffdone(userid.getKickoffdone());
        projectDev.setUserrequirementstart(userid.getUserrequirementstart());
        projectDev.setUserrequirementdeadline(userid.getUserrequirementdeadline());
        projectDev.setUserrequirementdone(userid.getUserrequirementdone());
        projectDev.setApplicationdevelopmentstart(userid.getApplicationdevelopmentstart());
        projectDev.setApplicationdevelopmentdeadline(userid.getApplicationdevelopmentdeadline());
        projectDev.setApplicationdevelopmentdone(userid.getApplicationdevelopmentdone());
        projectDev.setSitstart(userid.getSitstart());
        projectDev.setSitdeadline(userid.getSitdeadline());
        projectDev.setSitdone(userid.getSitdone());
        projectDev.setUatstart(userid.getUatstart());
        projectDev.setUatdeadline(userid.getUatdeadline());
        projectDev.setUatdone(userid.getUatdone());
        projectDev.setImplementationpreparestart(userid.getImplementationpreparestart());
        projectDev.setImplementationpreparedeadline(userid.getImplementationpreparedeadline());
        projectDev.setImplementationpreparedone(userid.getImplementationpreparedone());
        projectDev.setImplementationmeetingstart(userid.getImplementationmeetingstart());
        projectDev.setImplementationmeetingdeadline(userid.getImplementationmeetingdeadline());
        projectDev.setImplementationmeetingdone(userid.getImplementationmeetingdone());
        projectDev.setImplementationstart(userid.getImplementationstart());
        projectDev.setImplementationdeadline(userid.getImplementationdeadline());
        projectDev.setImplementationdone(userid.getImplementationdone());
        projectDev.setPostimplementationreviewstart(userid.getPostimplementationreviewstart());
        projectDev.setPostimplementationreviewdeadline(userid.getPostimplementationreviewdeadline());
        projectDev.setPostimplementationreviewdone(userid.getPostimplementationreviewdone());
        projectDev.setStatus(userid.getStatus());
        projectDev.setDeadlineproject(userid.getDeadlineproject());
        projectDev.setProjectdone(userid.getProjectdone());

        projectDevRepository.save(projectDev);

        return ProjectDevResponse.builder().projectname(projectDev.getProjectname()).pic(projectDev.getPic())
                .departement(projectDev.getDepartement())

                .kickoffstart((projectDev.getKickoffstart()))
                .kickoffdeadline((projectDev.getKickoffdeadline())).kickoffdone((projectDev.getKickoffdone()))

                .userrequirementstart(projectDev.getUserrequirementstart())
                .userrequirementdeadline((projectDev.getUserrequirementdeadline()))
                .userrequirementdone((projectDev.getUserrequirementdone()))

                .applicationdevelopmentstart(projectDev.getApplicationdevelopmentstart())
                .applicationdevelopmentdeadline((projectDev.getApplicationdevelopmentdeadline()))
                .applicationdevelopmentdone((projectDev.getApplicationdevelopmentdone()))

                .sitstart(projectDev.getSitstart()).sitdeadline((projectDev.getSitdeadline()))
                .sitdone((projectDev.getSitdone()))

                .uatstart(projectDev.getUatstart()).uatdeadline((projectDev.getUatdeadline()))
                .uatdone((projectDev.getUatdone()))

                .implementationpreparestart(projectDev.getImplementationpreparestart())
                .implementationpreparedeadline((projectDev.getImplementationpreparedeadline()))
                .implementationpreparedone((projectDev.getImplementationpreparedone()))

                .implementationmeetingstart(projectDev.getImplementationmeetingstart())
                .implementationmeetingdeadline((projectDev.getImplementationmeetingdeadline()))
                .implementationmeetingdone((projectDev.getImplementationmeetingdone()))

                .implementationstart(projectDev.getImplementationstart())
                .implementationdeadline((projectDev.getImplementationdeadline()))
                .implementationdone((projectDev.getImplementationdone()))

                .postimplementationreviewstart(projectDev.getPostimplementationreviewstart())
                .postimplementationreviewdeadline((projectDev.getPostimplementationreviewdeadline()))
                .postimplementationreviewdone((projectDev.getPostimplementationreviewdone()))

                .status(projectDev.getStatus()).deadlineproject((projectDev.getDeadlineproject())).projectdone(projectDev.getProjectdone())
                .build();
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
                        item.getKickoffstart(),
                        item.getKickoffdeadline(),
                        item.getKickoffdone(),
                        item.getUserrequirementstart(),
                        item.getUserrequirementdeadline(),
                        item.getUserrequirementdone(),
                        item.getApplicationdevelopmentstart(),
                        item.getApplicationdevelopmentdeadline(),
                        item.getApplicationdevelopmentdone(),
                        item.getSitstart(),
                        item.getSitdeadline(),
                        item.getSitdone(),
                        item.getUatstart(),
                        item.getUatdeadline(),
                        item.getUatdone(),
                        item.getImplementationpreparestart(),
                        item.getImplementationpreparedeadline(),
                        item.getImplementationpreparedone(),
                        item.getImplementationmeetingstart(),
                        item.getImplementationmeetingdeadline(),
                        item.getImplementationmeetingdone(),
                        item.getImplementationstart(),
                        item.getImplementationdeadline(),
                        item.getImplementationdone(),
                        item.getPostimplementationreviewstart(),
                        item.getPostimplementationreviewdeadline(),
                        item.getPostimplementationreviewdone(),
                        item.getStatus(),
                        item.getDeadlineproject(),
                        item.getProjectdone(),
                        projectByName.size()))
                .collect((Collectors.toList()));
        return response;
    }

    @Transactional
    public ProjectDevResponse editedProject(String userid, ProjectDevRequest request, String input) {
        validationService.validateRequest(request);
        ProjectDev projectDev = projectDevRepository.findById(input)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found"));

        projectDev.setProjectname(request.getProjectname());
        projectDev.setPic(request.getPic());
        projectDev.setDepartement(request.getDepartement());
        projectDev.setKickoffstart(request.getKickoffstart());
        projectDev.setKickoffdeadline(request.getKickoffdeadline());
        projectDev.setKickoffdone(request.getKickoffdone());
        projectDev.setUserrequirementstart(request.getUserrequirementstart());
        projectDev.setUserrequirementdeadline(request.getUserrequirementdeadline());
        projectDev.setUserrequirementdone(request.getUserrequirementdone());
        projectDev.setApplicationdevelopmentstart(request.getApplicationdevelopmentstart());
        projectDev.setApplicationdevelopmentdeadline(request.getApplicationdevelopmentdeadline());
        projectDev.setApplicationdevelopmentdone(request.getApplicationdevelopmentdone());
        projectDev.setSitstart(request.getSitstart());
        projectDev.setSitdeadline(request.getSitdeadline());
        projectDev.setSitdone(request.getSitdone());
        projectDev.setUatstart(request.getUatstart());
        projectDev.setUatdeadline(request.getUatdeadline());
        projectDev.setUatdone(request.getUatdone());
        projectDev.setImplementationpreparestart(request.getImplementationpreparestart());
        projectDev.setImplementationpreparedeadline(request.getImplementationpreparedeadline());
        projectDev.setImplementationpreparedone(request.getImplementationpreparedone());
        projectDev.setImplementationmeetingstart(request.getImplementationmeetingstart());
        projectDev.setImplementationmeetingdeadline(request.getImplementationmeetingdeadline());
        projectDev.setImplementationmeetingdone(request.getImplementationmeetingdone());
        projectDev.setImplementationstart(request.getImplementationstart());
        projectDev.setImplementationdeadline(request.getImplementationdeadline());
        projectDev.setImplementationdone(request.getImplementationdone());
        projectDev.setPostimplementationreviewstart(request.getPostimplementationreviewstart());
        projectDev.setPostimplementationreviewdeadline(request.getPostimplementationreviewdeadline());
        projectDev.setPostimplementationreviewdone(request.getPostimplementationreviewdone());
        projectDev.setStatus(request.getStatus());
        projectDev.setDeadlineproject(request.getDeadlineproject());
        projectDev.setProjectdone(request.getProjectdone());

        projectDevRepository.save(projectDev);

        return ProjectDevResponse.builder()
                .projectname(projectDev.getProjectname())
                .pic(projectDev.getPic())
                .departement(projectDev.getDepartement())
                .kickoffstart(projectDev.getKickoffstart())
                .kickoffdeadline(projectDev.getKickoffdeadline())
                .kickoffdone(projectDev.getKickoffdone())
                .userrequirementstart(projectDev.getUserrequirementstart())
                .userrequirementdeadline(projectDev.getUserrequirementdeadline())
                .userrequirementdone(projectDev.getUserrequirementdone())
                .applicationdevelopmentstart(projectDev.getApplicationdevelopmentstart())
                .applicationdevelopmentdeadline(projectDev.getApplicationdevelopmentdeadline())
                .applicationdevelopmentdone(projectDev.getApplicationdevelopmentdone())
                .sitstart(projectDev.getSitstart())
                .sitdeadline(projectDev.getSitdeadline())
                .sitdone(projectDev.getSitdone())
                .uatstart(projectDev.getUatstart())
                .uatdeadline(projectDev.getUatdeadline())
                .uatdone(projectDev.getUatdone())
                .implementationpreparestart(projectDev.getImplementationpreparestart())
                .implementationpreparedeadline(projectDev.getImplementationpreparedeadline())
                .implementationpreparedone(projectDev.getImplementationpreparedone())
                .implementationmeetingstart(projectDev.getImplementationmeetingstart())
                .implementationmeetingdeadline(projectDev.getImplementationmeetingdeadline())
                .implementationmeetingdone(projectDev.getImplementationmeetingdone())
                .implementationstart(projectDev.getImplementationstart())
                .implementationdeadline(projectDev.getImplementationdeadline())
                .implementationdone(projectDev.getImplementationdone())
                .postimplementationreviewstart(projectDev.getPostimplementationreviewstart())
                .postimplementationreviewdeadline(projectDev.getPostimplementationreviewdeadline())
                .postimplementationreviewdone(projectDev.getPostimplementationreviewdone())
                .status(projectDev.getStatus())
                .deadlineproject(projectDev.getDeadlineproject())
                .projectdone(projectDev.getProjectdone())
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
                        item.getKickoffstart(),
                        item.getKickoffdeadline(),
                        item.getKickoffdone(),
                        item.getUserrequirementstart(),
                        item.getUserrequirementdeadline(),
                        item.getUserrequirementdone(),
                        item.getApplicationdevelopmentstart(),
                        item.getApplicationdevelopmentdeadline(),
                        item.getApplicationdevelopmentdone(),
                        item.getSitstart(),
                        item.getSitdeadline(),
                        item.getSitdone(),
                        item.getUatstart(),
                        item.getUatdeadline(),
                        item.getUatdone(),
                        item.getImplementationpreparestart(),
                        item.getImplementationpreparedeadline(),
                        item.getImplementationpreparedone(),
                        item.getImplementationmeetingstart(),
                        item.getImplementationmeetingdeadline(),
                        item.getImplementationmeetingdone(),
                        item.getImplementationstart(),
                        item.getImplementationdeadline(),
                        item.getImplementationdone(),
                        item.getPostimplementationreviewstart(),
                        item.getPostimplementationreviewdeadline(),
                        item.getPostimplementationreviewdone(),
                        item.getStatus(),
                        item.getDeadlineproject(),
                        item.getProjectdone(),
                        projectDevAll.size()))
                .collect(Collectors.toList());

        return response;

    }

}
