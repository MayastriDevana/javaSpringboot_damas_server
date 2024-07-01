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
    public ProjectDevResponse newProject(ProjectDevRequest request, String userid) {
        validationService.validateUsers(userid);

        if (!(validationService.isOperator(userid) || validationService.isDevOperator(userid) || validationService.isPpoOperator(userid))) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
            }

        ProjectDev projectDev = new ProjectDev();
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
        projectDev.setCreatedby(request.getCreatedby());
        projectDev.setUserdomain(request.getUserdomain());
        projectDev.setUserdomainpic(request.getUserdomainpic());

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
                .createdby(projectDev.getCreatedby()).userdomain(projectDev.getUserdomain()).userdomainpic(projectDev.getUserdomainpic())
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
                        item.getCreatedby(),
                        item.getUserdomain(),
                        item.getUserdomainpic(),
                        projectByName.size()))
                .collect((Collectors.toList()));
        return response;
    }

    @Transactional
    public ProjectDevResponse editedProject(String userid, ProjectDevRequest request, String input) {
        validationService.validateRequest(request);

        if (!(validationService.isOperator(userid) || validationService.isDevOperator(userid) || validationService.isPpoOperator(userid) || validationService.isDevSupervisor(userid) || validationService.isPpoSupervisor(userid))) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
            }
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
        projectDev.setCreatedby(request.getCreatedby());
        projectDev.setUserdomain(request.getUserdomain());
        projectDev.setUserdomainpic(request.getUserdomainpic());

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
                .createdby(projectDev.getCreatedby())
                .userdomain(projectDev.getUserdomain())
                .userdomainpic(projectDev.getUserdomainpic())
                .build();
    }

    @Transactional
    public List<ProjectDevResponse> findAll(String userid, Long start, Long size) {
        validationService.validateRequest(userid);

        if (!(validationService.isOperator(userid) || validationService.isDevOperator(userid) || validationService.isPpoSupervisor(userid) || validationService.isDevSupervisor(userid) || validationService.isSupervisor(userid) || validationService.isPpoOperator(userid))) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
            }

        List<ProjectDev> projectDevAll = projectDevRepository.searchAllOrderByDeadline();

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
                        item.getCreatedby(),
                        item.getUserdomain(),
                        item.getUserdomainpic(),
                        projectDevAll.size()))
                .collect(Collectors.toList());

        return response;

    }

    @Transactional
public List<ProjectDevResponse> findByUserdomainOrderByDeadline(String userid, Long start, Long size, String userdomain) {
      
    // Melakukan validasi terhadap user yang sedang login
    validationService.validateRequest(userid);

    if (!(validationService.isOperator(userid) || validationService.isDevOperator(userid) || validationService.isPpoSupervisor(userid) || validationService.isDevSupervisor(userid) || validationService.isSupervisor(userid) || validationService.isPpoOperator(userid))) {
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
    }

    // Mengambil data proyek berdasarkan userdomain
    List<ProjectDev> projectDevAll = projectDevRepository.findByUserdomainOrderByDeadline(userdomain);

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
                item.getCreatedby(),
                item.getUserdomain(),
                item.getUserdomainpic(),
                projectDevAll.size()))
            .collect(Collectors.toList());

    return response;
}

}
