package com.damas.dbdamas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.LogApproveProjectDev;
import com.damas.dbdamas.payload.LogApproveProjectDevResponse;
import com.damas.dbdamas.payload.ProjectDevRequest;
import com.damas.dbdamas.repository.LogApproveProjectDevRepository;
import com.damas.dbsecure.service.ValidationSecureService;

import jakarta.transaction.Transactional;

@Service
public class LogApproveProjectDevService {

    @Autowired
    private LogApproveProjectDevRepository logApproveProjectDevRepository;

    @Autowired
    private ProjectDevService projectDevService;

    @Autowired
    ValidationSecureService validationSecureService;

    @Transactional
    public String createLog(String userid, LogApproveProjectDev request) {
        validationSecureService.validateUsers(userid);

        if (!(validationSecureService.isOperator(userid) || validationSecureService.isDevOperator(userid) || validationSecureService.isPpoOperator(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        logApproveProjectDevRepository.save(request);

        return "request submitted";
    }

    @Transactional
    public List<LogApproveProjectDevResponse> findAll(String userid, Long start, Long size) {
        validationSecureService.validateUsers(userid);

        if (!(validationSecureService.isOperator(userid) || validationSecureService.isSupervisor(userid) || validationSecureService.isDevSupervisor(userid) || validationSecureService.isPpoSupervisor(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        List<LogApproveProjectDev> LogAll = logApproveProjectDevRepository.searchAllOrderByStatus();

        List<LogApproveProjectDevResponse> response = LogAll.stream()
        .skip(start).limit(size)
        .map(item -> new LogApproveProjectDevResponse(
            item.getId(),
            item.getIdproject(),
            item.getSubmitter(),
            item.getAuthorizer(),
            item.getSubmitAt(),
            item.getDeadlineApprovement(),
            item.getStatusApprovement(),
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
            LogAll.size()))
            .collect(Collectors.toList());
    
        return response;
    }

    @Transactional
    public List<LogApproveProjectDevResponse> findLog(String userid, String input) {
        validationSecureService.validateRequest(userid);
        List<LogApproveProjectDev> logByName = logApproveProjectDevRepository.searchByName(input);

        List<LogApproveProjectDevResponse> response = logByName.stream()
        .map(item -> new LogApproveProjectDevResponse(
            item.getId(),
            item.getIdproject(),
            item.getSubmitter(),
            item.getAuthorizer(),
            item.getSubmitAt(),
            item.getDeadlineApprovement(),
            item.getStatusApprovement(),
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
            logByName.size()))
    .collect((Collectors.toList()));
       return response;
    }

    @Transactional
    public String updateStatusLog(String userid, String id, String status) {
        validationSecureService.validateUsers(userid);

        if (!(validationSecureService.isSupervisor(userid) || validationSecureService.isDevSupervisor(userid) || validationSecureService.isPpoSupervisor(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        LogApproveProjectDev result = logApproveProjectDevRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "log not found!");
        });

        result.setStatusApprovement(status);

        ProjectDevRequest inputRequestProjectDev = new ProjectDevRequest();
        inputRequestProjectDev.setProjectname(result.getProjectname());
        inputRequestProjectDev.setPic(result.getPic());
        inputRequestProjectDev.setDepartement(result.getDepartement());
        inputRequestProjectDev.setKickoffstart(result.getKickoffstart());
        inputRequestProjectDev.setKickoffdeadline(result.getKickoffdeadline());
        inputRequestProjectDev.setKickoffdone(result.getKickoffdone());
        inputRequestProjectDev.setUserrequirementstart(result.getUserrequirementstart());
        inputRequestProjectDev.setUserrequirementdeadline(result.getUserrequirementdeadline());
        inputRequestProjectDev.setUserrequirementdone(result.getUserrequirementdone());
        inputRequestProjectDev.setApplicationdevelopmentstart(result.getApplicationdevelopmentstart());
        inputRequestProjectDev.setApplicationdevelopmentdeadline(result.getApplicationdevelopmentdeadline());
        inputRequestProjectDev.setApplicationdevelopmentdone(result.getApplicationdevelopmentdone());
        inputRequestProjectDev.setSitstart(result.getSitstart());
        inputRequestProjectDev.setSitdeadline(result.getSitdeadline());
        inputRequestProjectDev.setSitdone(result.getSitdone());
        inputRequestProjectDev.setUatstart(result.getUatstart());
        inputRequestProjectDev.setUatdeadline(result.getUatdeadline());
        inputRequestProjectDev.setUatdone(result.getUatdone());
        inputRequestProjectDev.setImplementationpreparestart(result.getImplementationpreparestart());
        inputRequestProjectDev.setImplementationpreparedeadline(result.getImplementationpreparedeadline());
        inputRequestProjectDev.setImplementationpreparedone(result.getImplementationpreparedone());
        inputRequestProjectDev.setImplementationmeetingstart(result.getImplementationmeetingstart());
        inputRequestProjectDev.setImplementationmeetingdeadline(result.getImplementationmeetingdeadline());
        inputRequestProjectDev.setImplementationmeetingdone(result.getImplementationmeetingdone());
        inputRequestProjectDev.setImplementationstart(result.getImplementationstart());
        inputRequestProjectDev.setImplementationdeadline(result.getImplementationdeadline());
        inputRequestProjectDev.setImplementationdone(result.getImplementationdone());
        inputRequestProjectDev.setPostimplementationreviewstart(result.getPostimplementationreviewstart());
        inputRequestProjectDev.setPostimplementationreviewdeadline(result.getPostimplementationreviewdeadline());
        inputRequestProjectDev.setPostimplementationreviewdone(result.getPostimplementationreviewdone());
        inputRequestProjectDev.setStatus(result.getStatus());
        inputRequestProjectDev.setDeadlineproject(result.getDeadlineproject());
        inputRequestProjectDev.setProjectdone(result.getProjectdone());

        if (status.toUpperCase().equals("APPROVED")) {
            projectDevService.editedProject(userid, inputRequestProjectDev, result.getIdproject());

        }

        logApproveProjectDevRepository.save(result);

        return "Status Update: " + status;

    }

}
