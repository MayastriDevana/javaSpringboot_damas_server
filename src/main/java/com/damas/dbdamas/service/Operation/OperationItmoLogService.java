package com.damas.dbdamas.service.Operation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.Operation.OperationItmoLog;
import com.damas.dbdamas.payload.Operation.OperationItmoLogResponse;
import com.damas.dbdamas.payload.Operation.OperationItmoRequest;
import com.damas.dbdamas.repository.Operation.OperationItmoLogRepository;
import com.damas.dbsecure.service.ValidationSecureService;

import jakarta.transaction.Transactional;

@Service
public class OperationItmoLogService {
    
    @Autowired
    private OperationItmoLogRepository operationItmoLogRepository;

    @Autowired
    private OperationItmoService operationItmoService;

    @Autowired
    ValidationSecureService validationSecureService;

    @Transactional
     public String createLog(String userid, OperationItmoLog request) {
        validationSecureService.validateUsers(userid);

        if (!(validationSecureService.isOperator(userid) || validationSecureService.isItmoOperator(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }


        operationItmoLogRepository.save(request);

        return "request submitted";
    }

    @Transactional
    public List<OperationItmoLogResponse> findAll(String userid, Long start, Long size) {
        validationSecureService.validateUsers(userid);

        if (!(validationSecureService.isOperator(userid) || validationSecureService.isSupervisor(userid) || validationSecureService.isOperationSupervisor(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        List<OperationItmoLog> LogAll = operationItmoLogRepository.searchAllOrderByStatus();

        List<OperationItmoLogResponse> response = LogAll.stream()
        .skip(start).limit(size)
        .map(item -> new OperationItmoLogResponse(
            item.getId(),
            item.getItmo_id(),
            item.getSubmitter(),
            item.getAuthorizer(),
            item.getSubmit_at(),
            item.getDeadline_approvement(),
            item.getStatus_approvement(),
            item.getItmo_perihal(),
            item.getItmo_pic(),
            item.getDepartement(),
            item.getItmo_phase1(),
            item.getItmo_phase1_start(),
            item.getItmo_phase1_deadline(),
            item.getItmo_phase1_done(),
            item.getItmo_phase2(),
            item.getItmo_phase2_start(),
            item.getItmo_phase2_deadline(),
            item.getItmo_phase2_done(),
            item.getItmo_phase3(),
            item.getItmo_phase3_start(),
            item.getItmo_phase3_deadline(),
            item.getItmo_phase3_done(),
            item.getItmo_phase4(),
            item.getItmo_phase4_start(),
            item.getItmo_phase4_deadline(),
            item.getItmo_phase4_done(),
            item.getItmo_phase5(),
            item.getItmo_phase5_start(),
            item.getItmo_phase5_deadline(),
            item.getItmo_phase5_done(),
            item.getItmo_phase6(),
            item.getItmo_phase6_start(),
            item.getItmo_phase6_deadline(),
            item.getItmo_phase6_done(),
            item.getItmo_phase7(),
            item.getItmo_phase7_start(),
            item.getItmo_phase7_deadline(),
            item.getItmo_phase7_done(),
            item.getItmo_status(),
            item.getItmo_deadline_project(),
            item.getItmo_project_done(),
            item.getCreatedBy(),
            item.getUserdomain(),
            item.getUserdomain_pic(),
            LogAll.size()))
            .collect(Collectors.toList());

        return response;
    }

    @Transactional
    public List<OperationItmoLogResponse> findLog(String userid, String input) {
        validationSecureService.validateRequest(userid);
        List<OperationItmoLog> logByName = operationItmoLogRepository.searchByName(input);

        List<OperationItmoLogResponse> response = logByName.stream()
        .map(item -> new OperationItmoLogResponse(
            item.getId(),
            item.getItmo_id(),
            item.getSubmitter(),
            item.getAuthorizer(),
            item.getSubmit_at(),
            item.getDeadline_approvement(),
            item.getStatus_approvement(),
            item.getItmo_perihal(),
            item.getItmo_pic(),
            item.getDepartement(),
            item.getItmo_phase1(),
            item.getItmo_phase1_start(),
            item.getItmo_phase1_deadline(),
            item.getItmo_phase1_done(),
            item.getItmo_phase2(),
            item.getItmo_phase2_start(),
            item.getItmo_phase2_deadline(),
            item.getItmo_phase2_done(),
            item.getItmo_phase3(),
            item.getItmo_phase3_start(),
            item.getItmo_phase3_deadline(),
            item.getItmo_phase3_done(),
            item.getItmo_phase4(),
            item.getItmo_phase4_start(),
            item.getItmo_phase4_deadline(),
            item.getItmo_phase4_done(),
            item.getItmo_phase5(),
            item.getItmo_phase5_start(),
            item.getItmo_phase5_deadline(),
            item.getItmo_phase5_done(),
            item.getItmo_phase6(),
            item.getItmo_phase6_start(),
            item.getItmo_phase6_deadline(),
            item.getItmo_phase6_done(),
            item.getItmo_phase7(),
            item.getItmo_phase7_start(),
            item.getItmo_phase7_deadline(),
            item.getItmo_phase7_done(),
            item.getItmo_status(),
            item.getItmo_deadline_project(),
            item.getItmo_project_done(),
            item.getCreatedBy(),
            item.getUserdomain(),
            item.getUserdomain_pic(),
            logByName.size()))
    .collect((Collectors.toList()));
        return response;
    }

     @Transactional
    public String updateStatusLog(String userid, String id, String itmo_status) {
        validationSecureService.validateUsers(userid);

        if (!(validationSecureService.isSupervisor(userid) || validationSecureService.isOperationSupervisor(userid) || validationSecureService.isOperator(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        OperationItmoLog result = operationItmoLogRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "log not found!");
        });

        result.setStatus_approvement(itmo_status);

        OperationItmoRequest inputRequestOperationItmo = new OperationItmoRequest();
            inputRequestOperationItmo.setItmo_perihal(result.getItmo_perihal());
            inputRequestOperationItmo.setItmo_pic(result.getItmo_pic());
            inputRequestOperationItmo.setDepartement(result.getDepartement());
            inputRequestOperationItmo.setItmo_phase1(result.getItmo_phase1());
            inputRequestOperationItmo.setItmo_phase1_start(result.getItmo_phase1_start());
            inputRequestOperationItmo.setItmo_phase1_deadline(result.getItmo_phase1_deadline());
            inputRequestOperationItmo.setItmo_phase1_done(result.getItmo_phase1_done());
            inputRequestOperationItmo.setItmo_phase2(result.getItmo_phase2());
            inputRequestOperationItmo.setItmo_phase2_start(result.getItmo_phase2_start());
            inputRequestOperationItmo.setItmo_phase2_deadline(result.getItmo_phase2_deadline());
            inputRequestOperationItmo.setItmo_phase2_done(result.getItmo_phase2_done());
            inputRequestOperationItmo.setItmo_phase3(result.getItmo_phase3());
            inputRequestOperationItmo.setItmo_phase3_start(result.getItmo_phase3_start());
            inputRequestOperationItmo.setItmo_phase3_deadline(result.getItmo_phase3_deadline());
            inputRequestOperationItmo.setItmo_phase3_done(result.getItmo_phase3_done());
            inputRequestOperationItmo.setItmo_phase4(result.getItmo_phase4());
            inputRequestOperationItmo.setItmo_phase4_start(result.getItmo_phase4_start());
            inputRequestOperationItmo.setItmo_phase4_deadline(result.getItmo_phase4_deadline());
            inputRequestOperationItmo.setItmo_phase4_done(result.getItmo_phase4_done());
            inputRequestOperationItmo.setItmo_phase5(result.getItmo_phase5());
            inputRequestOperationItmo.setItmo_phase5_start(result.getItmo_phase5_start());
            inputRequestOperationItmo.setItmo_phase5_deadline(result.getItmo_phase5_deadline());
            inputRequestOperationItmo.setItmo_phase5_done(result.getItmo_phase5_done());
            inputRequestOperationItmo.setItmo_phase6(result.getItmo_phase6());
            inputRequestOperationItmo.setItmo_phase6_start(result.getItmo_phase6_start());
            inputRequestOperationItmo.setItmo_phase6_deadline(result.getItmo_phase6_deadline());
            inputRequestOperationItmo.setItmo_phase6_done(result.getItmo_phase6_done());
            inputRequestOperationItmo.setItmo_phase7(result.getItmo_phase7());
            inputRequestOperationItmo.setItmo_phase7_start(result.getItmo_phase7_start());
            inputRequestOperationItmo.setItmo_phase7_deadline(result.getItmo_phase7_deadline());
            inputRequestOperationItmo.setItmo_phase7_done(result.getItmo_phase7_done());
            inputRequestOperationItmo.setItmo_status(result.getItmo_status());
            inputRequestOperationItmo.setItmo_deadline_project(result.getItmo_deadline_project());
            inputRequestOperationItmo.setItmo_project_done(result.getItmo_project_done());
            inputRequestOperationItmo.setCreatedBy(result.getCreatedBy());
            inputRequestOperationItmo.setUserdomain(result.getUserdomain());
            inputRequestOperationItmo.setUserdomain_pic(result.getUserdomain_pic());

            if (itmo_status.toUpperCase().equals("APPROVED")) {
                operationItmoService.editedItmo(userid, inputRequestOperationItmo, result.getItmo_id());
    }
    operationItmoLogRepository.save(result);

    return "Status Update: " + itmo_status;
}
}
