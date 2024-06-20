package com.damas.dbdamas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.OperationNetworkLog;
import com.damas.dbdamas.payload.OperationNetworkLogResponse;
import com.damas.dbdamas.payload.OperationNetworkRequest;
import com.damas.dbdamas.repository.OperationNetworkLogRepository;
import com.damas.dbsecure.service.ValidationSecureService;

import jakarta.transaction.Transactional;

@Service
public class OperationNetworkLogService {
    
    @Autowired
    private OperationNetworkLogRepository operationNetworkLogRepository;

    @Autowired
    private OperationNetworkService operationNetworkService;

    @Autowired
    ValidationSecureService validationSecureService;

    @Transactional
    public String createLog(String userid, OperationNetworkLog request) {
        validationSecureService.validateUsers(userid);

        operationNetworkLogRepository.save(request);

        return "request submitted";
    }

     @Transactional
    public List<OperationNetworkLogResponse> findAll(String userid, Long start, Long size) {
        validationSecureService.validateUsers(userid);

        List<OperationNetworkLog> LogAll = operationNetworkLogRepository.searchAllOrderByStatus();

        List<OperationNetworkLogResponse> response = LogAll.stream()
        .skip(start).limit(size)
        .map(item -> new OperationNetworkLogResponse(
            item.getId(),
            item.getNetwork_id(),
            item.getSubmitter(),
            item.getAuthorizer(),
            item.getSubmit_at(),
            item.getDeadline_approvement(),
            item.getStatus_approvement(),
            item.getNetwork_perihal(),
            item.getNetwork_pic(),
            item.getDepartement(),
            item.getNetwork_kickoff_start(),
            item.getNetwork_kickoff_deadline(),
            item.getNetwork_kickoff_done(),
            item.getNetwork_mop_start(),
            item.getNetwork_mop_deadline(),
            item.getNetwork_mop_done(),
            item.getNetwork_demomop_start(),
            item.getNetwork_demomop_deadline(),
            item.getNetwork_demomop_done(),
            item.getNetwork_implementasi_start(),
            item.getNetwork_implementasi_deadline(),
            item.getNetwork_implementasi_done(),
            item.getNetwork_skse_start(),
            item.getNetwork_skse_deadline(),
            item.getNetwork_skse_done(),
            item.getNetwork_uat_start(),
            item.getNetwork_uat_deadline(),
            item.getNetwork_uat_done(),
            item.getNetwork_status(),
            item.getNetwork_deadline_project(),
            item.getNetwork_project_done(),
            LogAll.size()))
            .collect(Collectors.toList());
    
        return response;
    }

    @Transactional
    public List<OperationNetworkLogResponse> findLog(String userid, String input) {
        validationSecureService.validateRequest(userid);
        List<OperationNetworkLog> logByName = operationNetworkLogRepository.searchByName(input);

        List<OperationNetworkLogResponse> response = logByName.stream()
        .map(item -> new OperationNetworkLogResponse(
            item.getId(),
            item.getNetwork_id(),
            item.getSubmitter(),
            item.getAuthorizer(),
            item.getSubmit_at(),
            item.getDeadline_approvement(),
            item.getStatus_approvement(),
            item.getNetwork_perihal(),
            item.getNetwork_pic(),
            item.getDepartement(),
            item.getNetwork_kickoff_start(),
            item.getNetwork_kickoff_deadline(),
            item.getNetwork_kickoff_done(),
            item.getNetwork_mop_start(),
            item.getNetwork_mop_deadline(),
            item.getNetwork_mop_done(),
            item.getNetwork_demomop_start(),
            item.getNetwork_demomop_deadline(),
            item.getNetwork_demomop_done(),
            item.getNetwork_implementasi_start(),
            item.getNetwork_implementasi_deadline(),
            item.getNetwork_implementasi_done(),
            item.getNetwork_skse_start(),
            item.getNetwork_skse_deadline(),
            item.getNetwork_skse_done(),
            item.getNetwork_uat_start(),
            item.getNetwork_uat_deadline(),
            item.getNetwork_uat_done(),
            item.getNetwork_status(),
            item.getNetwork_deadline_project(),
            item.getNetwork_project_done(),
            logByName.size()))
    .collect((Collectors.toList()));
       return response;
    }

    @Transactional
    public String updateStatusLog(String userid, String id, String status) {
        validationSecureService.validateUsers(userid);

        OperationNetworkLog result = operationNetworkLogRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "log not found!");
        });

        result.setStatus_approvement(status);

        OperationNetworkRequest inputRequestOperationNetwork = new OperationNetworkRequest();
        inputRequestOperationNetwork.setNetwork_perihal(result.getNetwork_perihal());
        inputRequestOperationNetwork.setNetwork_pic(result.getNetwork_pic());
        inputRequestOperationNetwork.setDepartement(result.getDepartement());
        inputRequestOperationNetwork.setNetwork_kickoff_start(result.getNetwork_kickoff_start());
        inputRequestOperationNetwork.setNetwork_kickoff_deadline(result.getNetwork_kickoff_deadline());
        inputRequestOperationNetwork.setNetwork_kickoff_done(result.getNetwork_kickoff_done());
        inputRequestOperationNetwork.setNetwork_mop_start(result.getNetwork_mop_start());
        inputRequestOperationNetwork.setNetwork_mop_deadline(result.getNetwork_mop_deadline());
        inputRequestOperationNetwork.setNetwork_mop_done(result.getNetwork_mop_done());
        inputRequestOperationNetwork.setNetwork_demomop_start(result.getNetwork_demomop_start());
        inputRequestOperationNetwork.setNetwork_demomop_deadline(result.getNetwork_demomop_deadline());
        inputRequestOperationNetwork.setNetwork_demomop_done(result.getNetwork_demomop_done());
        inputRequestOperationNetwork.setNetwork_implementasi_start(result.getNetwork_implementasi_start());
        inputRequestOperationNetwork.setNetwork_implementasi_deadline(result.getNetwork_implementasi_deadline());
        inputRequestOperationNetwork.setNetwork_implementasi_done(result.getNetwork_implementasi_done());
        inputRequestOperationNetwork.setNetwork_skse_start(result.getNetwork_skse_start());
        inputRequestOperationNetwork.setNetwork_skse_deadline(result.getNetwork_skse_deadline());
        inputRequestOperationNetwork.setNetwork_skse_done(result.getNetwork_skse_done());
        inputRequestOperationNetwork.setNetwork_uat_start(result.getNetwork_uat_start());
        inputRequestOperationNetwork.setNetwork_uat_deadline(result.getNetwork_uat_deadline());
        inputRequestOperationNetwork.setNetwork_uat_done(result.getNetwork_uat_done());
        inputRequestOperationNetwork.setNetwork_status(result.getNetwork_status());
        inputRequestOperationNetwork.setNetwork_deadline_project(result.getNetwork_deadline_project());
        inputRequestOperationNetwork.setNetwork_project_done(result.getNetwork_project_done());


        if (status.toUpperCase().equals("APPROVED")) {
            operationNetworkService.editedNetwork(userid, inputRequestOperationNetwork, result.getNetwork_id());

        }

        operationNetworkLogRepository.save(result);

        return "Status Update: " + status;

    }
}
