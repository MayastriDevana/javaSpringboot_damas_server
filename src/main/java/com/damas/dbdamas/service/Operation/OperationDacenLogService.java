package com.damas.dbdamas.service.Operation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.Operation.OperationDacenLog;
import com.damas.dbdamas.payload.Operation.OperationDacenLogResponse;
import com.damas.dbdamas.payload.Operation.OperationDacenRequest;
import com.damas.dbdamas.repository.Operation.OperationDacenLogRepository;
import com.damas.dbsecure.service.ValidationSecureService;

import jakarta.transaction.Transactional;

@Service
public class OperationDacenLogService {
    
    @Autowired
    private OperationDacenLogRepository operationDacenLogRepository;

    @Autowired
    private OperationDacenService operationDacenService;

    @Autowired
    ValidationSecureService validationSecureService;

    @Transactional
     public String createLog(String userid, OperationDacenLog request) {
        validationSecureService.validateUsers(userid);

        if (!(validationSecureService.isOperator(userid) || validationSecureService.isDacenOperator(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        operationDacenLogRepository.save(request);

        return "request submitted";
    }

        @Transactional
    public List<OperationDacenLogResponse> findAll(String userid, Long start, Long size) {
        validationSecureService.validateUsers(userid);

        if (!(validationSecureService.isOperator(userid) || validationSecureService.isSupervisor(userid) || validationSecureService.isOperationSupervisor(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        List<OperationDacenLog> LogAll = operationDacenLogRepository.searchAllOrderByStatus();

        List<OperationDacenLogResponse> response = LogAll.stream()
        .skip(start).limit(size)
        .map(item -> new OperationDacenLogResponse(
            item.getId(),
            item.getDacen_id(),
            item.getSubmitter(),
            item.getAuthorizer(),
            item.getSubmit_at(),
            item.getDeadline_approvement(),
            item.getStatus_approvement(),
            item.getDacen_perihal(),
            item.getDacen_pic(),
            item.getDepartement(),
            item.getDacen_phase1(),
            item.getDacen_phase1_start(),
            item.getDacen_phase1_deadline(),
            item.getDacen_phase1_done(),
            item.getDacen_phase2(),
            item.getDacen_phase2_start(),
            item.getDacen_phase2_deadline(),
            item.getDacen_phase2_done(),
            item.getDacen_phase3(),
            item.getDacen_phase3_start(),
            item.getDacen_phase3_deadline(),
            item.getDacen_phase3_done(),
            item.getDacen_phase4(),
            item.getDacen_phase4_start(),
            item.getDacen_phase4_deadline(),
            item.getDacen_phase4_done(),
            item.getDacen_phase5(),
            item.getDacen_phase5_start(),
            item.getDacen_phase5_deadline(),
            item.getDacen_phase5_done(),
            item.getDacen_phase6(),
            item.getDacen_phase6_start(),
            item.getDacen_phase6_deadline(),
            item.getDacen_phase6_done(),
            item.getDacen_phase7(),
            item.getDacen_phase7_start(),
            item.getDacen_phase7_deadline(),
            item.getDacen_phase7_done(),
            item.getDacen_status(),
            item.getDacen_deadline_project(),
            item.getDacen_project_done(),
            item.getCreatedBy(),
            item.getUserdomain(),
            item.getUserdomain_pic(),
            LogAll.size()))
            .collect(Collectors.toList());

        return response;
    }

    @Transactional
    public List<OperationDacenLogResponse> findLog(String userid, String input) {
        validationSecureService.validateRequest(userid);
        List<OperationDacenLog> logByName = operationDacenLogRepository.searchByName(input);

        List<OperationDacenLogResponse> response = logByName.stream()
        .map(item -> new OperationDacenLogResponse(
            item.getId(),
            item.getDacen_id(),
            item.getSubmitter(),
            item.getAuthorizer(),
            item.getSubmit_at(),
            item.getDeadline_approvement(),
            item.getStatus_approvement(),
            item.getDacen_perihal(),
            item.getDacen_pic(),
            item.getDepartement(),
            item.getDacen_phase1(),
            item.getDacen_phase1_start(),
            item.getDacen_phase1_deadline(),
            item.getDacen_phase1_done(),
            item.getDacen_phase2(),
            item.getDacen_phase2_start(),
            item.getDacen_phase2_deadline(),
            item.getDacen_phase2_done(),
            item.getDacen_phase3(),
            item.getDacen_phase3_start(),
            item.getDacen_phase3_deadline(),
            item.getDacen_phase3_done(),
            item.getDacen_phase4(),
            item.getDacen_phase4_start(),
            item.getDacen_phase4_deadline(),
            item.getDacen_phase4_done(),
            item.getDacen_phase5(),
            item.getDacen_phase5_start(),
            item.getDacen_phase5_deadline(),
            item.getDacen_phase5_done(),
            item.getDacen_phase6(),
            item.getDacen_phase6_start(),
            item.getDacen_phase6_deadline(),
            item.getDacen_phase6_done(),
            item.getDacen_phase7(),
            item.getDacen_phase7_start(),
            item.getDacen_phase7_deadline(),
            item.getDacen_phase7_done(),
            item.getDacen_status(),
            item.getDacen_deadline_project(),
            item.getDacen_project_done(),
            item.getCreatedBy(),
            item.getUserdomain(),
            item.getUserdomain_pic(),
            logByName.size()))
    .collect((Collectors.toList()));
        return response;
    }

    @Transactional
    public String updateStatusLog(String userid, String id, String dacen_status) {
        validationSecureService.validateUsers(userid);

        if (!(validationSecureService.isOperator(userid) || validationSecureService.isSupervisor(userid) || validationSecureService.isOperationSupervisor(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        OperationDacenLog result = operationDacenLogRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "log not found!");
        });

        result.setStatus_approvement(dacen_status);

        OperationDacenRequest inputRequestOperationDacen = new OperationDacenRequest();
            inputRequestOperationDacen.setDacen_perihal(result.getDacen_perihal());
            inputRequestOperationDacen.setDacen_pic(result.getDacen_pic());
            inputRequestOperationDacen.setDepartement(result.getDepartement());
            inputRequestOperationDacen.setDacen_phase1(result.getDacen_phase1());
            inputRequestOperationDacen.setDacen_phase1_start(result.getDacen_phase1_start());
            inputRequestOperationDacen.setDacen_phase1_deadline(result.getDacen_phase1_deadline());
            inputRequestOperationDacen.setDacen_phase1_done(result.getDacen_phase1_done());
            inputRequestOperationDacen.setDacen_phase2(result.getDacen_phase2());
            inputRequestOperationDacen.setDacen_phase2_start(result.getDacen_phase2_start());
            inputRequestOperationDacen.setDacen_phase2_deadline(result.getDacen_phase2_deadline());
            inputRequestOperationDacen.setDacen_phase2_done(result.getDacen_phase2_done());
            inputRequestOperationDacen.setDacen_phase3(result.getDacen_phase3());
            inputRequestOperationDacen.setDacen_phase3_start(result.getDacen_phase3_start());
            inputRequestOperationDacen.setDacen_phase3_deadline(result.getDacen_phase3_deadline());
            inputRequestOperationDacen.setDacen_phase3_done(result.getDacen_phase3_done());
            inputRequestOperationDacen.setDacen_phase4(result.getDacen_phase4());
            inputRequestOperationDacen.setDacen_phase4_start(result.getDacen_phase4_start());
            inputRequestOperationDacen.setDacen_phase4_deadline(result.getDacen_phase4_deadline());
            inputRequestOperationDacen.setDacen_phase4_done(result.getDacen_phase4_done());
            inputRequestOperationDacen.setDacen_phase5(result.getDacen_phase5());
            inputRequestOperationDacen.setDacen_phase5_start(result.getDacen_phase5_start());
            inputRequestOperationDacen.setDacen_phase5_deadline(result.getDacen_phase5_deadline());
            inputRequestOperationDacen.setDacen_phase5_done(result.getDacen_phase5_done());
            inputRequestOperationDacen.setDacen_phase6(result.getDacen_phase6());
            inputRequestOperationDacen.setDacen_phase6_start(result.getDacen_phase6_start());
            inputRequestOperationDacen.setDacen_phase6_deadline(result.getDacen_phase6_deadline());
            inputRequestOperationDacen.setDacen_phase6_done(result.getDacen_phase6_done());
            inputRequestOperationDacen.setDacen_phase7(result.getDacen_phase7());
            inputRequestOperationDacen.setDacen_phase7_start(result.getDacen_phase7_start());
            inputRequestOperationDacen.setDacen_phase7_deadline(result.getDacen_phase7_deadline());
            inputRequestOperationDacen.setDacen_phase7_done(result.getDacen_phase7_done());
            inputRequestOperationDacen.setDacen_status(result.getDacen_status());
            inputRequestOperationDacen.setDacen_deadline_project(result.getDacen_deadline_project());
            inputRequestOperationDacen.setDacen_project_done(result.getDacen_project_done());
            inputRequestOperationDacen.setCreatedBy(result.getCreatedBy());
            inputRequestOperationDacen.setUserdomain(result.getUserdomain());
            inputRequestOperationDacen.setUserdomain_pic(result.getUserdomain_pic());

            if (dacen_status.toUpperCase().equals("APPROVED")) {
                operationDacenService.editedDacen(userid, inputRequestOperationDacen, result.getDacen_id());
    }
    operationDacenLogRepository.save(result);

    return "Status Update: " + dacen_status;
}
}
