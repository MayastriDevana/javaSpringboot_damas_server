package com.damas.dbdamas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.LogApproveProjectDev;
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
    public String createLog(String userid, LogApproveProjectDev request){
        validationSecureService.validateUsers(userid);

        logApproveProjectDevRepository.save(request);

        return "request submitted";
    }

    @Transactional
    public List<LogApproveProjectDev> getAllLog(String userid){
        validationSecureService.validateUsers(userid);

        List<LogApproveProjectDev> response = logApproveProjectDevRepository.findAll();

        return response;
    }

    @Transactional
    public String updateStatusLog(String userid, String id, String status){
        validationSecureService.validateUsers(userid);

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

        if (status.toUpperCase().equals("APPROVED")) {
            projectDevService.editedProject(userid, inputRequestProjectDev, result.getId());
        }

        logApproveProjectDevRepository.save(result);

        return "Status Update: " + status;


    }
    
}
