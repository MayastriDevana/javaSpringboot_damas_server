package com.damas.dbdamas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.OperationItsecurity;
import com.damas.dbdamas.payload.OperationItsecurityRequest;
import com.damas.dbdamas.payload.OperationItsecurityResponse;
import com.damas.dbdamas.repository.OperationItsecurityRepository;

import jakarta.transaction.Transactional;

@Service
public class OperationItsecurityService {
    
    @Autowired
    private OperationItsecurityRepository OperationItsecurityRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public OperationItsecurityResponse newItsecurity(OperationItsecurityRequest userid, String token) {
        validationService.validateRequest(userid);

        OperationItsecurity operationItsecurity = new OperationItsecurity();
        operationItsecurity.setItsecurity_pic(userid.getItsecurity_pic());
        operationItsecurity.setItsecurity_perihal(userid.getItsecurity_perihal());
        operationItsecurity.setDepartement(userid.getDepartement());
        operationItsecurity.setItsecurity_phase1(userid.getItsecurity_phase1());
        operationItsecurity.setItsecurity_phase1_start(userid.getItsecurity_phase1_start());
        operationItsecurity.setItsecurity_phase1_deadline(userid.getItsecurity_phase1_deadline());
        operationItsecurity.setItsecurity_phase1_done(userid.getItsecurity_phase1_done());
        operationItsecurity.setItsecurity_phase2(userid.getItsecurity_phase2());
        operationItsecurity.setItsecurity_phase2_start(userid.getItsecurity_phase2_start());
        operationItsecurity.setItsecurity_phase2_deadline(userid.getItsecurity_phase2_deadline());
        operationItsecurity.setItsecurity_phase2_done(userid.getItsecurity_phase2_done());
        operationItsecurity.setItsecurity_phase3(userid.getItsecurity_phase3());
        operationItsecurity.setItsecurity_phase3_start(userid.getItsecurity_phase3_start());
        operationItsecurity.setItsecurity_phase3_deadline(userid.getItsecurity_phase3_deadline());
        operationItsecurity.setItsecurity_phase3_done(userid.getItsecurity_phase3_done());
        operationItsecurity.setItsecurity_phase4(userid.getItsecurity_phase4());
        operationItsecurity.setItsecurity_phase4_start(userid.getItsecurity_phase4_start());
        operationItsecurity.setItsecurity_phase4_deadline(userid.getItsecurity_phase4_deadline());
        operationItsecurity.setItsecurity_phase4_done(userid.getItsecurity_phase4_done());
        operationItsecurity.setItsecurity_phase5(userid.getItsecurity_phase5());
        operationItsecurity.setItsecurity_phase5_start(userid.getItsecurity_phase5_start());
        operationItsecurity.setItsecurity_phase5_deadline(userid.getItsecurity_phase5_deadline());
        operationItsecurity.setItsecurity_phase5_done(userid.getItsecurity_phase5_done());
        operationItsecurity.setItsecurity_phase6(userid.getItsecurity_phase6());
        operationItsecurity.setItsecurity_phase6_start(userid.getItsecurity_phase6_start());
        operationItsecurity.setItsecurity_phase6_deadline(userid.getItsecurity_phase6_deadline());
        operationItsecurity.setItsecurity_phase6_done(userid.getItsecurity_phase6_done());
        operationItsecurity.setItsecurity_phase7(userid.getItsecurity_phase7());
        operationItsecurity.setItsecurity_phase7_start(userid.getItsecurity_phase7_start());
        operationItsecurity.setItsecurity_phase7_deadline(userid.getItsecurity_phase7_deadline());
        operationItsecurity.setItsecurity_phase7_done(userid.getItsecurity_phase7_done());
        operationItsecurity.setItsecurity_status(userid.getItsecurity_status());
        operationItsecurity.setItsecurity_deadline_project(userid.getItsecurity_deadline_project());

        OperationItsecurityRepository.save(operationItsecurity);

        return OperationItsecurityResponse.builder()
        .itsecurity_perihal(operationItsecurity.getItsecurity_perihal())
        .itsecurity_pic(operationItsecurity.getItsecurity_pic())
        .departement(operationItsecurity.getDepartement())

        .itsecurity_phase1(operationItsecurity.getItsecurity_phase1())
        .itsecurity_phase1_start(operationItsecurity.getItsecurity_phase1_start())
        .itsecurity_phase1_deadline(operationItsecurity.getItsecurity_phase1_deadline())
        .itsecurity_phase1_done(operationItsecurity.getItsecurity_phase1_done())

        .itsecurity_phase2(operationItsecurity.getItsecurity_phase2())
        .itsecurity_phase2_start(operationItsecurity.getItsecurity_phase2_start())
        .itsecurity_phase2_deadline(operationItsecurity.getItsecurity_phase2_deadline())
        .itsecurity_phase2_done(operationItsecurity.getItsecurity_phase2_done())

        .itsecurity_phase3(operationItsecurity.getItsecurity_phase3())
        .itsecurity_phase3_start(operationItsecurity.getItsecurity_phase3_start())
        .itsecurity_phase3_deadline(operationItsecurity.getItsecurity_phase3_deadline())
        .itsecurity_phase3_done(operationItsecurity.getItsecurity_phase3_done())

        .itsecurity_phase4(operationItsecurity.getItsecurity_phase4())
        .itsecurity_phase4_start(operationItsecurity.getItsecurity_phase4_start())
        .itsecurity_phase4_deadline(operationItsecurity.getItsecurity_phase4_deadline())
        .itsecurity_phase4_done(operationItsecurity.getItsecurity_phase4_done())

        .itsecurity_phase5(operationItsecurity.getItsecurity_phase5())
        .itsecurity_phase5_start(operationItsecurity.getItsecurity_phase5_start())
        .itsecurity_phase5_deadline(operationItsecurity.getItsecurity_phase5_deadline())
        .itsecurity_phase5_done(operationItsecurity.getItsecurity_phase5_done())

        .itsecurity_phase6(operationItsecurity.getItsecurity_phase6())
        .itsecurity_phase6_start(operationItsecurity.getItsecurity_phase6_start())
        .itsecurity_phase6_deadline(operationItsecurity.getItsecurity_phase6_deadline())
        .itsecurity_phase6_done(operationItsecurity.getItsecurity_phase6_done())

        .itsecurity_phase7(operationItsecurity.getItsecurity_phase7())
        .itsecurity_phase7_start(operationItsecurity.getItsecurity_phase7_start())
        .itsecurity_phase7_deadline(operationItsecurity.getItsecurity_phase7_deadline())
        .itsecurity_phase7_done(operationItsecurity.getItsecurity_phase7_done())

        .itsecurity_status(operationItsecurity.getItsecurity_status())
        .itsecurity_deadline_project(operationItsecurity.getItsecurity_deadline_project())

        .build();

    }

    @Transactional
    public List<OperationItsecurityResponse> findItsecurity(String userid, String input) {
        
        validationService.validateRequest(userid);

        List<OperationItsecurity> itsecurityByName = OperationItsecurityRepository.searchByItsecurity_perihalorItsecurity_pic(input);

        List<OperationItsecurityResponse> response = itsecurityByName.stream()
        .map(item -> new OperationItsecurityResponse(
            item.getItsecurity_id(),
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
            itsecurityByName.size()))
            .collect(Collectors.toList());

            return response;
    }

     @Transactional
    public OperationItsecurityResponse editedItsecurity(String userid, OperationItsecurityRequest request, String input) {

        validationService.validateRequest(userid);

        OperationItsecurity operationItsecurity = OperationItsecurityRepository.findById(input)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found"));

            operationItsecurity.setItsecurity_perihal(request.getItsecurity_perihal());
            operationItsecurity.setItsecurity_pic(request.getItsecurity_pic());
            operationItsecurity.setDepartement(request.getDepartement());
            operationItsecurity.setItsecurity_phase1(request.getItsecurity_phase1());
            operationItsecurity.setItsecurity_phase1_start(request.getItsecurity_phase1_start());
            operationItsecurity.setItsecurity_phase1_deadline(request.getItsecurity_phase1_deadline());
            operationItsecurity.setItsecurity_phase1_done(request.getItsecurity_phase1_done());
            operationItsecurity.setItsecurity_phase2(request.getItsecurity_phase2());
            operationItsecurity.setItsecurity_phase2_start(request.getItsecurity_phase2_start());
            operationItsecurity.setItsecurity_phase2_deadline(request.getItsecurity_phase2_deadline());
            operationItsecurity.setItsecurity_phase2_done(request.getItsecurity_phase2_done());
            operationItsecurity.setItsecurity_phase3(request.getItsecurity_phase3());
            operationItsecurity.setItsecurity_phase3_start(request.getItsecurity_phase3_start());
            operationItsecurity.setItsecurity_phase3_deadline(request.getItsecurity_phase3_deadline());
            operationItsecurity.setItsecurity_phase3_done(request.getItsecurity_phase3_done());
            operationItsecurity.setItsecurity_phase4(request.getItsecurity_phase4());
            operationItsecurity.setItsecurity_phase4_start(request.getItsecurity_phase4_start());
            operationItsecurity.setItsecurity_phase4_deadline(request.getItsecurity_phase4_deadline());
            operationItsecurity.setItsecurity_phase4_done(request.getItsecurity_phase4_done());
            operationItsecurity.setItsecurity_phase5(request.getItsecurity_phase5());
            operationItsecurity.setItsecurity_phase5_start(request.getItsecurity_phase5_start());
            operationItsecurity.setItsecurity_phase5_deadline(request.getItsecurity_phase5_deadline());
            operationItsecurity.setItsecurity_phase5_done(request.getItsecurity_phase5_done());
            operationItsecurity.setItsecurity_phase6(request.getItsecurity_phase6());
            operationItsecurity.setItsecurity_phase6_start(request.getItsecurity_phase6_start());
            operationItsecurity.setItsecurity_phase6_deadline(request.getItsecurity_phase6_deadline());
            operationItsecurity.setItsecurity_phase6_done(request.getItsecurity_phase6_done());
            operationItsecurity.setItsecurity_phase7(request.getItsecurity_phase7());
            operationItsecurity.setItsecurity_phase7_start(request.getItsecurity_phase7_start());
            operationItsecurity.setItsecurity_phase7_deadline(request.getItsecurity_phase7_deadline());
            operationItsecurity.setItsecurity_phase7_done(request.getItsecurity_phase7_done());
            operationItsecurity.setItsecurity_status(request.getItsecurity_status());
            operationItsecurity.setItsecurity_deadline_project(request.getItsecurity_deadline_project());
    
        OperationItsecurityRepository.save(operationItsecurity);

        return OperationItsecurityResponse.builder()
        .itsecurity_perihal(operationItsecurity.getItsecurity_perihal())
        .itsecurity_pic(operationItsecurity.getItsecurity_pic())
        .departement(operationItsecurity.getDepartement())

        .itsecurity_phase1(operationItsecurity.getItsecurity_phase1())
        .itsecurity_phase1_start(operationItsecurity.getItsecurity_phase1_start())
        .itsecurity_phase1_deadline(operationItsecurity.getItsecurity_phase1_deadline())
        .itsecurity_phase1_done(operationItsecurity.getItsecurity_phase1_done())

        .itsecurity_phase2(operationItsecurity.getItsecurity_phase2())
        .itsecurity_phase2_start(operationItsecurity.getItsecurity_phase2_start())
        .itsecurity_phase2_deadline(operationItsecurity.getItsecurity_phase2_deadline())
        .itsecurity_phase2_done(operationItsecurity.getItsecurity_phase2_done())

        .itsecurity_phase3(operationItsecurity.getItsecurity_phase3())
        .itsecurity_phase3_start(operationItsecurity.getItsecurity_phase3_start())
        .itsecurity_phase3_deadline(operationItsecurity.getItsecurity_phase3_deadline())
        .itsecurity_phase3_done(operationItsecurity.getItsecurity_phase3_done())

        .itsecurity_phase4(operationItsecurity.getItsecurity_phase4())
        .itsecurity_phase4_start(operationItsecurity.getItsecurity_phase4_start())
        .itsecurity_phase4_deadline(operationItsecurity.getItsecurity_phase4_deadline())
        .itsecurity_phase4_done(operationItsecurity.getItsecurity_phase4_done())

        .itsecurity_phase5(operationItsecurity.getItsecurity_phase5())
        .itsecurity_phase5_start(operationItsecurity.getItsecurity_phase5_start())
        .itsecurity_phase5_deadline(operationItsecurity.getItsecurity_phase5_deadline())
        .itsecurity_phase5_done(operationItsecurity.getItsecurity_phase5_done())

        .itsecurity_phase6(operationItsecurity.getItsecurity_phase6())
        .itsecurity_phase6_start(operationItsecurity.getItsecurity_phase6_start())
        .itsecurity_phase6_deadline(operationItsecurity.getItsecurity_phase6_deadline())
        .itsecurity_phase6_done(operationItsecurity.getItsecurity_phase6_done())

        .itsecurity_phase7(operationItsecurity.getItsecurity_phase7())
        .itsecurity_phase7_start(operationItsecurity.getItsecurity_phase7_start())
        .itsecurity_phase7_deadline(operationItsecurity.getItsecurity_phase7_deadline())
        .itsecurity_phase7_done(operationItsecurity.getItsecurity_phase7_done())

        .itsecurity_status(operationItsecurity.getItsecurity_status())
        .itsecurity_deadline_project(operationItsecurity.getItsecurity_deadline_project())
        .build();
        
    }

    @Transactional
    public List<OperationItsecurityResponse> findAll(String userid, Long start, Long size) {

        validationService.validateRequest(userid);

        List<OperationItsecurity> operationItsecurityShowAll = OperationItsecurityRepository.findAll();

        List<OperationItsecurityResponse> response = operationItsecurityShowAll.stream()
        .skip(start).limit(size)
        .map(item -> new OperationItsecurityResponse(
            item.getItsecurity_id(),
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
            operationItsecurityShowAll.size()))
            .collect(Collectors.toList());

            return response;
    }
}
