package com.damas.dbdamas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.OperationItsecurityLog;
import com.damas.dbdamas.payload.OperationItsecurityRequest;
import com.damas.dbdamas.payload.OperationItsecurityLogResponse;
import com.damas.dbdamas.repository.OperationItsecurityLogRepository;
import com.damas.dbsecure.service.ValidationSecureService;

import jakarta.transaction.Transactional;

@Service
public class OperationItsecurityLogService {
    @Autowired
    private OperationItsecurityLogRepository operationItsecurityLogRepository;

    @Autowired
    private OperationItsecurityService operationItsecurityService;

    @Autowired
    ValidationSecureService validationSecureService;

    @Transactional
     public String createLog(String userid, OperationItsecurityLog request) {
        validationSecureService.validateUsers(userid);

        if (!(validationSecureService.isOperator(userid) || validationSecureService.isDevOperator(userid) || validationSecureService.isPpoOperator(userid) || validationSecureService. isSkseOperator(userid) || validationSecureService.isDacenOperator(userid) || validationSecureService.isNetworkOperator(userid) || validationSecureService.isServerOperator(userid) || validationSecureService.isItsupportOperator(userid) || validationSecureService.isItmoOperator(userid) || validationSecureService.isItsecurityOperator(userid) || validationSecureService.isLogisticOperator(userid) || validationSecureService.isReviewerSupervisor(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        operationItsecurityLogRepository.save(request);

        return "request submitted";
    }

    @Transactional
    public List<OperationItsecurityLogResponse> findAll(String userid, Long start, Long size) {
        validationSecureService.validateUsers(userid);

        if (!(validationSecureService.isOperator(userid) || validationSecureService.isSupervisor(userid) || validationSecureService.isDevSupervisor(userid) || validationSecureService.isPpoSupervisor(userid) || validationSecureService.isOperationSupervisor(userid) || validationSecureService.isLogisticSupervisor(userid) || validationSecureService.isReviewerSupervisor(userid) || validationSecureService.isDevOperator(userid) || validationSecureService.isPpoOperator(userid) || validationSecureService. isSkseOperator(userid) || validationSecureService.isNetworkOperator(userid) || validationSecureService.isServerOperator(userid) || validationSecureService.isDacenOperator(userid) || validationSecureService.isItsupportOperator(userid) || validationSecureService.isItmoOperator(userid) || validationSecureService.isItsecurityOperator(userid) || validationSecureService.isLogisticOperator(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        List<OperationItsecurityLog> LogAll = operationItsecurityLogRepository.searchAllOrderByStatus();

        List<OperationItsecurityLogResponse> response = LogAll.stream()
        .skip(start).limit(size)
        .map(item -> new OperationItsecurityLogResponse(
            item.getId(),
            item.getItsecurity_id(),
            item.getSubmitter(),
            item.getAuthorizer(),
            item.getSubmit_at(),
            item.getDeadline_approvement(),
            item.getStatus_approvement(),
            item.getItsecurity_perihal(),
            item.getItsecurity_pic(),
            item.getDepartement(),
            item.getItsecurity_phase1(),
            item.getItsecurity_phase1_start(),
            item.getItsecurity_phase1_deadline(),
            item.getItsecurity_phase1_done(),
            item.getItsecurity_phase2(),
            item.getItsecurity_phase2_start(),
            item.getItsecurity_phase2_deadline(),
            item.getItsecurity_phase2_done(),
            item.getItsecurity_phase3(),
            item.getItsecurity_phase3_start(),
            item.getItsecurity_phase3_deadline(),
            item.getItsecurity_phase3_done(),
            item.getItsecurity_phase4(),
            item.getItsecurity_phase4_start(),
            item.getItsecurity_phase4_deadline(),
            item.getItsecurity_phase4_done(),
            item.getItsecurity_phase5(),
            item.getItsecurity_phase5_start(),
            item.getItsecurity_phase5_deadline(),
            item.getItsecurity_phase5_done(),
            item.getItsecurity_phase6(),
            item.getItsecurity_phase6_start(),
            item.getItsecurity_phase6_deadline(),
            item.getItsecurity_phase6_done(),
            item.getItsecurity_phase7(),
            item.getItsecurity_phase7_start(),
            item.getItsecurity_phase7_deadline(),
            item.getItsecurity_phase7_done(),
            item.getItsecurity_status(),
            item.getItsecurity_deadline_project(),
            item.getItsecurity_project_done(),
            LogAll.size()))
            .collect(Collectors.toList());

        return response;
    }

    @Transactional
    public List<OperationItsecurityLogResponse> findLog(String userid, String input) {
        validationSecureService.validateRequest(userid);
        List<OperationItsecurityLog> logByName = operationItsecurityLogRepository.searchByName(input);

        List<OperationItsecurityLogResponse> response = logByName.stream()
        .map(item -> new OperationItsecurityLogResponse(
            item.getId(),
            item.getItsecurity_id(),
            item.getSubmitter(),
            item.getAuthorizer(),
            item.getSubmit_at(),
            item.getDeadline_approvement(),
            item.getStatus_approvement(),
            item.getItsecurity_perihal(),
            item.getItsecurity_pic(),
            item.getDepartement(),
            item.getItsecurity_phase1(),
            item.getItsecurity_phase1_start(),
            item.getItsecurity_phase1_deadline(),
            item.getItsecurity_phase1_done(),
            item.getItsecurity_phase2(),
            item.getItsecurity_phase2_start(),
            item.getItsecurity_phase2_deadline(),
            item.getItsecurity_phase2_done(),
            item.getItsecurity_phase3(),
            item.getItsecurity_phase3_start(),
            item.getItsecurity_phase3_deadline(),
            item.getItsecurity_phase3_done(),
            item.getItsecurity_phase4(),
            item.getItsecurity_phase4_start(),
            item.getItsecurity_phase4_deadline(),
            item.getItsecurity_phase4_done(),
            item.getItsecurity_phase5(),
            item.getItsecurity_phase5_start(),
            item.getItsecurity_phase5_deadline(),
            item.getItsecurity_phase5_done(),
            item.getItsecurity_phase6(),
            item.getItsecurity_phase6_start(),
            item.getItsecurity_phase6_deadline(),
            item.getItsecurity_phase6_done(),
            item.getItsecurity_phase7(),
            item.getItsecurity_phase7_start(),
            item.getItsecurity_phase7_deadline(),
            item.getItsecurity_phase7_done(),
            item.getItsecurity_status(),
            item.getItsecurity_deadline_project(),
            item.getItsecurity_project_done(),
            logByName.size()))
    .collect((Collectors.toList()));
        return response;
    }

    @Transactional
    public String updateStatusLog(String userid, String id, String itsecurity_status) {
        validationSecureService.validateUsers(userid);

        if (!(validationSecureService.isSupervisor(userid) || validationSecureService.isSupervisor(userid) || validationSecureService.isDevSupervisor(userid) || validationSecureService.isPpoSupervisor(userid) || validationSecureService.isOperationSupervisor(userid) || validationSecureService.isLogisticSupervisor(userid) || validationSecureService.isReviewerSupervisor(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        OperationItsecurityLog result = operationItsecurityLogRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "log not found!");
        });

        result.setStatus_approvement(itsecurity_status);

        OperationItsecurityRequest inputRequestOperationItsecurity = new OperationItsecurityRequest();
            inputRequestOperationItsecurity.setItsecurity_perihal(result.getItsecurity_perihal());
            inputRequestOperationItsecurity.setItsecurity_pic(result.getItsecurity_pic());
            inputRequestOperationItsecurity.setDepartement(result.getDepartement());
            inputRequestOperationItsecurity.setItsecurity_phase1(result.getItsecurity_phase1());
            inputRequestOperationItsecurity.setItsecurity_phase1_start(result.getItsecurity_phase1_start());
            inputRequestOperationItsecurity.setItsecurity_phase1_deadline(result.getItsecurity_phase1_deadline());
            inputRequestOperationItsecurity.setItsecurity_phase1_done(result.getItsecurity_phase1_done());
            inputRequestOperationItsecurity.setItsecurity_phase2(result.getItsecurity_phase2());
            inputRequestOperationItsecurity.setItsecurity_phase2_start(result.getItsecurity_phase2_start());
            inputRequestOperationItsecurity.setItsecurity_phase2_deadline(result.getItsecurity_phase2_deadline());
            inputRequestOperationItsecurity.setItsecurity_phase2_done(result.getItsecurity_phase2_done());
            inputRequestOperationItsecurity.setItsecurity_phase3(result.getItsecurity_phase3());
            inputRequestOperationItsecurity.setItsecurity_phase3_start(result.getItsecurity_phase3_start());
            inputRequestOperationItsecurity.setItsecurity_phase3_deadline(result.getItsecurity_phase3_deadline());
            inputRequestOperationItsecurity.setItsecurity_phase3_done(result.getItsecurity_phase3_done());
            inputRequestOperationItsecurity.setItsecurity_phase4(result.getItsecurity_phase4());
            inputRequestOperationItsecurity.setItsecurity_phase4_start(result.getItsecurity_phase4_start());
            inputRequestOperationItsecurity.setItsecurity_phase4_deadline(result.getItsecurity_phase4_deadline());
            inputRequestOperationItsecurity.setItsecurity_phase4_done(result.getItsecurity_phase4_done());
            inputRequestOperationItsecurity.setItsecurity_phase5(result.getItsecurity_phase5());
            inputRequestOperationItsecurity.setItsecurity_phase5_start(result.getItsecurity_phase5_start());
            inputRequestOperationItsecurity.setItsecurity_phase5_deadline(result.getItsecurity_phase5_deadline());
            inputRequestOperationItsecurity.setItsecurity_phase5_done(result.getItsecurity_phase5_done());
            inputRequestOperationItsecurity.setItsecurity_phase6(result.getItsecurity_phase6());
            inputRequestOperationItsecurity.setItsecurity_phase6_start(result.getItsecurity_phase6_start());
            inputRequestOperationItsecurity.setItsecurity_phase6_deadline(result.getItsecurity_phase6_deadline());
            inputRequestOperationItsecurity.setItsecurity_phase6_done(result.getItsecurity_phase6_done());
            inputRequestOperationItsecurity.setItsecurity_phase7(result.getItsecurity_phase7());
            inputRequestOperationItsecurity.setItsecurity_phase7_start(result.getItsecurity_phase7_start());
            inputRequestOperationItsecurity.setItsecurity_phase7_deadline(result.getItsecurity_phase7_deadline());
            inputRequestOperationItsecurity.setItsecurity_phase7_done(result.getItsecurity_phase7_done());
            inputRequestOperationItsecurity.setItsecurity_status(result.getItsecurity_status());
            inputRequestOperationItsecurity.setItsecurity_deadline_project(result.getItsecurity_deadline_project());
            inputRequestOperationItsecurity.setItsecurity_project_done(result.getItsecurity_project_done());

            if (itsecurity_status.toUpperCase().equals("APPROVED")) {
                operationItsecurityService.editedItsecurity(userid, inputRequestOperationItsecurity, result.getItsecurity_id());
    }
    operationItsecurityLogRepository.save(result);

    return "Status Update: " + itsecurity_status;
}
}
