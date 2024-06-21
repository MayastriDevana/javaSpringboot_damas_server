package com.damas.dbdamas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.OperationItsupportLog;
import com.damas.dbdamas.payload.OperationItsupportRequest;
import com.damas.dbdamas.payload.OperationItsupportLogResponse;
import com.damas.dbdamas.repository.OperationItsupportLogRepository;
import com.damas.dbsecure.service.ValidationSecureService;

import jakarta.transaction.Transactional;

@Service
public class OperationItsupportLogService {
     @Autowired
    private OperationItsupportLogRepository operationItsupportLogRepository;

    @Autowired
    private OperationItsupportService operationItsupportService;

    @Autowired
    ValidationSecureService validationSecureService;

    @Transactional
     public String createLog(String userid, OperationItsupportLog request) {
        validationSecureService.validateUsers(userid);

        operationItsupportLogRepository.save(request);

        return "request submitted";
    }

     @Transactional
    public List<OperationItsupportLogResponse> findAll(String userid, Long start, Long size) {
        validationSecureService.validateUsers(userid);

        List<OperationItsupportLog> LogAll = operationItsupportLogRepository.searchAllOrderByStatus();

        List<OperationItsupportLogResponse> response = LogAll.stream()
        .skip(start).limit(size)
        .map(item -> new OperationItsupportLogResponse(
            item.getId(),
            item.getItsupport_id(),
            item.getSubmitter(),
            item.getAuthorizer(),
            item.getSubmit_at(),
            item.getDeadline_approvement(),
            item.getStatus_approvement(),
            item.getItsupport_perihal(),
            item.getItsupport_pic(),
            item.getDepartement(),
            item.getItsupport_phase1(),
            item.getItsupport_phase1_start(),
            item.getItsupport_phase1_deadline(),
            item.getItsupport_phase1_done(),
            item.getItsupport_phase2(),
            item.getItsupport_phase2_start(),
            item.getItsupport_phase2_deadline(),
            item.getItsupport_phase2_done(),
            item.getItsupport_phase3(),
            item.getItsupport_phase3_start(),
            item.getItsupport_phase3_deadline(),
            item.getItsupport_phase3_done(),
            item.getItsupport_phase4(),
            item.getItsupport_phase4_start(),
            item.getItsupport_phase4_deadline(),
            item.getItsupport_phase4_done(),
            item.getItsupport_phase5(),
            item.getItsupport_phase5_start(),
            item.getItsupport_phase5_deadline(),
            item.getItsupport_phase5_done(),
            item.getItsupport_phase6(),
            item.getItsupport_phase6_start(),
            item.getItsupport_phase6_deadline(),
            item.getItsupport_phase6_done(),
            item.getItsupport_phase7(),
            item.getItsupport_phase7_start(),
            item.getItsupport_phase7_deadline(),
            item.getItsupport_phase7_done(),
            item.getItsupport_status(),
            item.getItsupport_deadline_project(),
            item.getItsupport_project_done(),
            LogAll.size()))
            .collect(Collectors.toList());

        return response;
    }

     @Transactional
    public List<OperationItsupportLogResponse> findLog(String userid, String input) {
        validationSecureService.validateRequest(userid);
        List<OperationItsupportLog> logByName = operationItsupportLogRepository.searchByName(input);

        List<OperationItsupportLogResponse> response = logByName.stream()
        .map(item -> new OperationItsupportLogResponse(
            item.getId(),
            item.getItsupport_id(),
            item.getSubmitter(),
            item.getAuthorizer(),
            item.getSubmit_at(),
            item.getDeadline_approvement(),
            item.getStatus_approvement(),
            item.getItsupport_perihal(),
            item.getItsupport_pic(),
            item.getDepartement(),
            item.getItsupport_phase1(),
            item.getItsupport_phase1_start(),
            item.getItsupport_phase1_deadline(),
            item.getItsupport_phase1_done(),
            item.getItsupport_phase2(),
            item.getItsupport_phase2_start(),
            item.getItsupport_phase2_deadline(),
            item.getItsupport_phase2_done(),
            item.getItsupport_phase3(),
            item.getItsupport_phase3_start(),
            item.getItsupport_phase3_deadline(),
            item.getItsupport_phase3_done(),
            item.getItsupport_phase4(),
            item.getItsupport_phase4_start(),
            item.getItsupport_phase4_deadline(),
            item.getItsupport_phase4_done(),
            item.getItsupport_phase5(),
            item.getItsupport_phase5_start(),
            item.getItsupport_phase5_deadline(),
            item.getItsupport_phase5_done(),
            item.getItsupport_phase6(),
            item.getItsupport_phase6_start(),
            item.getItsupport_phase6_deadline(),
            item.getItsupport_phase6_done(),
            item.getItsupport_phase7(),
            item.getItsupport_phase7_start(),
            item.getItsupport_phase7_deadline(),
            item.getItsupport_phase7_done(),
            item.getItsupport_status(),
            item.getItsupport_deadline_project(),
            item.getItsupport_project_done(),
            logByName.size()))
    .collect((Collectors.toList()));
        return response;
    }

    @Transactional
    public String updateStatusLog(String userid, String id, String itsupport_status) {
        validationSecureService.validateUsers(userid);

        OperationItsupportLog result = operationItsupportLogRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "log not found!");
        });

        result.setStatus_approvement(itsupport_status);

        OperationItsupportRequest inputRequestOperationItsupport = new OperationItsupportRequest();
            inputRequestOperationItsupport.setItsupport_perihal(result.getItsupport_perihal());
            inputRequestOperationItsupport.setItsupport_pic(result.getItsupport_pic());
            inputRequestOperationItsupport.setDepartement(result.getDepartement());
            inputRequestOperationItsupport.setItsupport_phase1(result.getItsupport_phase1());
            inputRequestOperationItsupport.setItsupport_phase1_start(result.getItsupport_phase1_start());
            inputRequestOperationItsupport.setItsupport_phase1_deadline(result.getItsupport_phase1_deadline());
            inputRequestOperationItsupport.setItsupport_phase1_done(result.getItsupport_phase1_done());
            inputRequestOperationItsupport.setItsupport_phase2(result.getItsupport_phase2());
            inputRequestOperationItsupport.setItsupport_phase2_start(result.getItsupport_phase2_start());
            inputRequestOperationItsupport.setItsupport_phase2_deadline(result.getItsupport_phase2_deadline());
            inputRequestOperationItsupport.setItsupport_phase2_done(result.getItsupport_phase2_done());
            inputRequestOperationItsupport.setItsupport_phase3(result.getItsupport_phase3());
            inputRequestOperationItsupport.setItsupport_phase3_start(result.getItsupport_phase3_start());
            inputRequestOperationItsupport.setItsupport_phase3_deadline(result.getItsupport_phase3_deadline());
            inputRequestOperationItsupport.setItsupport_phase3_done(result.getItsupport_phase3_done());
            inputRequestOperationItsupport.setItsupport_phase4(result.getItsupport_phase4());
            inputRequestOperationItsupport.setItsupport_phase4_start(result.getItsupport_phase4_start());
            inputRequestOperationItsupport.setItsupport_phase4_deadline(result.getItsupport_phase4_deadline());
            inputRequestOperationItsupport.setItsupport_phase4_done(result.getItsupport_phase4_done());
            inputRequestOperationItsupport.setItsupport_phase5(result.getItsupport_phase5());
            inputRequestOperationItsupport.setItsupport_phase5_start(result.getItsupport_phase5_start());
            inputRequestOperationItsupport.setItsupport_phase5_deadline(result.getItsupport_phase5_deadline());
            inputRequestOperationItsupport.setItsupport_phase5_done(result.getItsupport_phase5_done());
            inputRequestOperationItsupport.setItsupport_phase6(result.getItsupport_phase6());
            inputRequestOperationItsupport.setItsupport_phase6_start(result.getItsupport_phase6_start());
            inputRequestOperationItsupport.setItsupport_phase6_deadline(result.getItsupport_phase6_deadline());
            inputRequestOperationItsupport.setItsupport_phase6_done(result.getItsupport_phase6_done());
            inputRequestOperationItsupport.setItsupport_phase7(result.getItsupport_phase7());
            inputRequestOperationItsupport.setItsupport_phase7_start(result.getItsupport_phase7_start());
            inputRequestOperationItsupport.setItsupport_phase7_deadline(result.getItsupport_phase7_deadline());
            inputRequestOperationItsupport.setItsupport_phase7_done(result.getItsupport_phase7_done());
            inputRequestOperationItsupport.setItsupport_status(result.getItsupport_status());
            inputRequestOperationItsupport.setItsupport_deadline_project(result.getItsupport_deadline_project());
            inputRequestOperationItsupport.setItsupport_project_done(result.getItsupport_project_done());

            if (itsupport_status.toUpperCase().equals("APPROVED")) {
                operationItsupportService.editedItsupport(userid, inputRequestOperationItsupport, result.getItsupport_id());
    }
    operationItsupportLogRepository.save(result);

    return "Status Update: " + itsupport_status;
}
}
