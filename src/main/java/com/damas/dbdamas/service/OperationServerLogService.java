package com.damas.dbdamas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.OperationServerLog;
import com.damas.dbdamas.payload.OperationServerLogResponse;
import com.damas.dbdamas.payload.OperationServerRequest;
import com.damas.dbdamas.repository.OperationServerLogRepository;
import com.damas.dbsecure.service.ValidationSecureService;

import jakarta.transaction.Transactional;

@Service
public class OperationServerLogService {
    
    @Autowired
    private OperationServerLogRepository operationServerLogRepository;

    @Autowired
    private OperationServerService operationServerService;

    @Autowired
    ValidationSecureService validationSecureService;

    @Transactional
     public String createLog(String userid, OperationServerLog request) {
        validationSecureService.validateUsers(userid);

        if (!(validationSecureService.isOperator(userid) || validationSecureService.isServerOperator(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        operationServerLogRepository.save(request);

        return "request submitted";
    }

    @Transactional
    public List<OperationServerLogResponse> findAll(String userid, Long start, Long size) {
        validationSecureService.validateUsers(userid);

        if (!(validationSecureService.isOperator(userid) || validationSecureService.isSupervisor(userid) || validationSecureService.isOperationSupervisor(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        List<OperationServerLog> LogAll = operationServerLogRepository.searchAllOrderByStatus();

        List<OperationServerLogResponse> response = LogAll.stream()
        .skip(start).limit(size)
        .map(item -> new OperationServerLogResponse(
            item.getId(),
            item.getServer_id(),
            item.getSubmitter(),
            item.getAuthorizer(),
            item.getSubmit_at(),
            item.getDeadline_approvement(),
            item.getStatus_approvement(),
            item.getServer_perihal(),
            item.getServer_pic(),
            item.getDepartement(),
            item.getServer_kickoff_start(),
            item.getServer_kickoff_deadline(),
            item.getServer_kickoff_done(),
            item.getServer_peyiapanserver_start(),
            item.getServer_peyiapanserver_deadline(),
            item.getServer_peyiapanserver_done(),
            item.getServer_instalasiaplikasi_start(),
            item.getServer_instalasiaplikasi_deadline(),
            item.getServer_instalasiaplikasi_done(),
            item.getServer_instalcheckpoint_start(),
            item.getServer_instalcheckpoint_deadline(),
            item.getServer_instalcheckpoint_done(),
            item.getServer_testingkoneksi_start(),
            item.getServer_testingkoneksi_deadline(),
            item.getServer_testingkoneksi_done(),
            item.getServer_serahterimaserver_start(),
            item.getServer_serahterimaserver_deadline(),
            item.getServer_serahterimaserver_done(),
            item.getServer_implementasi_start(),
            item.getServer_implementasi_deadline(),
            item.getServer_implementasi_done(),
            item.getServer_status(),
            item.getServer_deadline_project(),
            item.getServer_project_done(),
            item.getCreatedBy(),
            item.getUserdomain(),
            item.getUserdomain_pic(),
            LogAll.size()))
            .collect(Collectors.toList());

        return response;
    }

    @Transactional
    public List<OperationServerLogResponse> findLog(String userid, String input) {
        validationSecureService.validateRequest(userid);
        List<OperationServerLog> logByName = operationServerLogRepository.searchByName(input);

        List<OperationServerLogResponse> response = logByName.stream()
        .map(item -> new OperationServerLogResponse(
            item.getId(),
            item.getServer_id(),
            item.getSubmitter(),
            item.getAuthorizer(),
            item.getSubmit_at(),
            item.getDeadline_approvement(),
            item.getStatus_approvement(),
            item.getServer_perihal(),
            item.getServer_pic(),
            item.getDepartement(),
            item.getServer_kickoff_start(),
            item.getServer_kickoff_deadline(),
            item.getServer_kickoff_done(),
            item.getServer_peyiapanserver_start(),
            item.getServer_peyiapanserver_deadline(),
            item.getServer_peyiapanserver_done(),
            item.getServer_instalasiaplikasi_start(),
            item.getServer_instalasiaplikasi_deadline(),
            item.getServer_instalasiaplikasi_done(),
            item.getServer_instalcheckpoint_start(),
            item.getServer_instalcheckpoint_deadline(),
            item.getServer_instalcheckpoint_done(),
            item.getServer_testingkoneksi_start(),
            item.getServer_testingkoneksi_deadline(),
            item.getServer_testingkoneksi_done(),
            item.getServer_serahterimaserver_start(),
            item.getServer_serahterimaserver_deadline(),
            item.getServer_serahterimaserver_done(),
            item.getServer_implementasi_start(),
            item.getServer_implementasi_deadline(),
            item.getServer_implementasi_done(),
            item.getServer_status(),
            item.getServer_deadline_project(),
            item.getServer_project_done(),
            item.getCreatedBy(),
            item.getUserdomain(),
            item.getUserdomain_pic(),
            logByName.size()))
    .collect((Collectors.toList()));
        return response;
    }

    @Transactional
    public String updateStatusLog(String userid, String id, String server_status) {
        validationSecureService.validateUsers(userid);

        if (!(validationSecureService.isOperator(userid) || validationSecureService.isSupervisor(userid) || validationSecureService.isOperationSupervisor(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        OperationServerLog result = operationServerLogRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "log not found!");
        });

        result.setStatus_approvement(server_status);

        OperationServerRequest inputRequestOperationServer = new OperationServerRequest();
            inputRequestOperationServer.setServer_perihal(result.getServer_perihal());
            inputRequestOperationServer.setServer_pic(result.getServer_pic());
            inputRequestOperationServer.setDepartement(result.getDepartement());
            inputRequestOperationServer.setServer_kickoff_start(result.getServer_kickoff_start());
            inputRequestOperationServer.setServer_kickoff_deadline(result.getServer_kickoff_deadline());
            inputRequestOperationServer.setServer_kickoff_done(result.getServer_kickoff_done());
            inputRequestOperationServer.setServer_peyiapanserver_start(result.getServer_peyiapanserver_start());
            inputRequestOperationServer.setServer_peyiapanserver_deadline(result.getServer_peyiapanserver_deadline());
            inputRequestOperationServer.setServer_peyiapanserver_done(result.getServer_peyiapanserver_done());
            inputRequestOperationServer.setServer_instalasiaplikasi_start(result.getServer_instalasiaplikasi_start());
            inputRequestOperationServer.setServer_instalasiaplikasi_deadline(result.getServer_instalasiaplikasi_deadline());
            inputRequestOperationServer.setServer_instalasiaplikasi_done(result.getServer_instalasiaplikasi_done());
            inputRequestOperationServer.setServer_instalcheckpoint_start(result.getServer_instalcheckpoint_start());
            inputRequestOperationServer.setServer_instalcheckpoint_deadline(result.getServer_instalcheckpoint_deadline());
            inputRequestOperationServer.setServer_instalcheckpoint_done(result.getServer_instalcheckpoint_done());
            inputRequestOperationServer.setServer_testingkoneksi_start(result.getServer_testingkoneksi_start());
            inputRequestOperationServer.setServer_testingkoneksi_deadline(result.getServer_testingkoneksi_deadline());
            inputRequestOperationServer.setServer_testingkoneksi_done(result.getServer_testingkoneksi_done());
            inputRequestOperationServer.setServer_serahterimaserver_start(result.getServer_serahterimaserver_start());
            inputRequestOperationServer.setServer_serahterimaserver_deadline(result.getServer_serahterimaserver_deadline());
            inputRequestOperationServer.setServer_serahterimaserver_done(result.getServer_serahterimaserver_done());
            inputRequestOperationServer.setServer_implementasi_start(result.getServer_implementasi_start());
            inputRequestOperationServer.setServer_implementasi_deadline(result.getServer_implementasi_deadline());
            inputRequestOperationServer.setServer_implementasi_done(result.getServer_implementasi_done());
            inputRequestOperationServer.setServer_status(result.getServer_status());
            inputRequestOperationServer.setServer_deadline_project(result.getServer_deadline_project());
            inputRequestOperationServer.setServer_project_done(result.getServer_project_done());
            inputRequestOperationServer.setCreatedBy(result.getCreatedBy());
            inputRequestOperationServer.setUserdomain(result.getUserdomain());
            inputRequestOperationServer.setUserdomain(result.getUserdomain_pic());

            if (server_status.toUpperCase().equals("APPROVED")) {
                operationServerService.editedServer(userid, inputRequestOperationServer, result.getServer_id());
    }

    operationServerLogRepository.save(result);

    return "Status Update: " + server_status;
}
}   
