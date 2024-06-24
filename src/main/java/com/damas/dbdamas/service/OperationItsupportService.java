package com.damas.dbdamas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.OperationItsupport;
import com.damas.dbdamas.payload.OperationItsupportRequest;
import com.damas.dbdamas.payload.OperationItsupportResponse;
import com.damas.dbdamas.repository.OperationItsupportRepository;

import jakarta.transaction.Transactional;

@Service
public class OperationItsupportService {
    
    @Autowired
    private OperationItsupportRepository OperationItsupportRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public OperationItsupportResponse newItsupport(OperationItsupportRequest userid, String token) {
        validationService.validateRequest(userid);
        
        OperationItsupport operationItsupport = new OperationItsupport();
        operationItsupport.setItsupport_perihal(userid.getItsupport_perihal());
        operationItsupport.setItsupport_pic(userid.getItsupport_pic());
        operationItsupport.setDepartement(userid.getDepartement());
        operationItsupport.setItsupport_phase1(userid.getItsupport_phase1());
        operationItsupport.setItsupport_phase1_start(userid.getItsupport_phase1_start());
        operationItsupport.setItsupport_phase1_deadline(userid.getItsupport_phase1_deadline());
        operationItsupport.setItsupport_phase1_done(userid.getItsupport_phase1_done());
        operationItsupport.setItsupport_phase2(userid.getItsupport_phase2());
        operationItsupport.setItsupport_phase2_start(userid.getItsupport_phase2_start());
        operationItsupport.setItsupport_phase2_deadline(userid.getItsupport_phase2_deadline());
        operationItsupport.setItsupport_phase2_done(userid.getItsupport_phase2_done());
        operationItsupport.setItsupport_phase3(userid.getItsupport_phase3());
        operationItsupport.setItsupport_phase3_start(userid.getItsupport_phase3_start());
        operationItsupport.setItsupport_phase3_deadline(userid.getItsupport_phase3_deadline());
        operationItsupport.setItsupport_phase3_done(userid.getItsupport_phase3_done());
        operationItsupport.setItsupport_phase4(userid.getItsupport_phase4());
        operationItsupport.setItsupport_phase4_start(userid.getItsupport_phase4_start());
        operationItsupport.setItsupport_phase4_deadline(userid.getItsupport_phase4_deadline());
        operationItsupport.setItsupport_phase4_done(userid.getItsupport_phase4_done());
        operationItsupport.setItsupport_phase5(userid.getItsupport_phase5());
        operationItsupport.setItsupport_phase5_start(userid.getItsupport_phase5_start());
        operationItsupport.setItsupport_phase5_deadline(userid.getItsupport_phase5_deadline());
        operationItsupport.setItsupport_phase5_done(userid.getItsupport_phase5_done());
        operationItsupport.setItsupport_phase6(userid.getItsupport_phase6());
        operationItsupport.setItsupport_phase6_start(userid.getItsupport_phase6_start());
        operationItsupport.setItsupport_phase6_deadline(userid.getItsupport_phase6_deadline());
        operationItsupport.setItsupport_phase6_done(userid.getItsupport_phase6_done());
        operationItsupport.setItsupport_phase7(userid.getItsupport_phase7());
        operationItsupport.setItsupport_phase7_start(userid.getItsupport_phase7_start());
        operationItsupport.setItsupport_phase7_deadline(userid.getItsupport_phase7_deadline());
        operationItsupport.setItsupport_phase7_done(userid.getItsupport_phase7_done());
        operationItsupport.setItsupport_status(userid.getItsupport_status());
        operationItsupport.setItsupport_deadline_project(userid.getItsupport_deadline_project());
        operationItsupport.setItsupport_project_done(userid.getItsupport_project_done());

        OperationItsupportRepository.save(operationItsupport);

        return OperationItsupportResponse.builder()
        .itsupport_perihal(operationItsupport.getItsupport_perihal())
        .itsupport_pic(operationItsupport.getItsupport_pic())
        .departement(operationItsupport.getDepartement())

        .itsupport_phase1(operationItsupport.getItsupport_phase1())
        .itsupport_phase1_start(operationItsupport.getItsupport_phase1_start())
        .itsupport_phase1_deadline(operationItsupport.getItsupport_phase1_deadline())
        .itsupport_phase1_done(operationItsupport.getItsupport_phase1_done())

        .itsupport_phase2(operationItsupport.getItsupport_phase2())
        .itsupport_phase2_start(operationItsupport.getItsupport_phase2_start())
        .itsupport_phase2_deadline(operationItsupport.getItsupport_phase2_deadline())
        .itsupport_phase2_done(operationItsupport.getItsupport_phase2_done())

        .itsupport_phase3(operationItsupport.getItsupport_phase3())
        .itsupport_phase3_start(operationItsupport.getItsupport_phase3_start())
        .itsupport_phase3_deadline(operationItsupport.getItsupport_phase3_deadline())
        .itsupport_phase3_done(operationItsupport.getItsupport_phase3_done())

        .itsupport_phase4(operationItsupport.getItsupport_phase4())
        .itsupport_phase4_start(operationItsupport.getItsupport_phase4_start())
        .itsupport_phase4_deadline(operationItsupport.getItsupport_phase4_deadline())
        .itsupport_phase4_done(operationItsupport.getItsupport_phase4_done())

        .itsupport_phase5(operationItsupport.getItsupport_phase5())
        .itsupport_phase5_start(operationItsupport.getItsupport_phase5_start())
        .itsupport_phase5_deadline(operationItsupport.getItsupport_phase5_deadline())
        .itsupport_phase5_done(operationItsupport.getItsupport_phase5_done())

        .itsupport_phase6(operationItsupport.getItsupport_phase6())
        .itsupport_phase6_start(operationItsupport.getItsupport_phase6_start())
        .itsupport_phase6_deadline(operationItsupport.getItsupport_phase6_deadline())
        .itsupport_phase6_done(operationItsupport.getItsupport_phase6_done())

        .itsupport_phase7(operationItsupport.getItsupport_phase7())
        .itsupport_phase7_start(operationItsupport.getItsupport_phase7_start())
        .itsupport_phase7_deadline(operationItsupport.getItsupport_phase7_deadline())
        .itsupport_phase7_done(operationItsupport.getItsupport_phase7_done())

        .itsupport_status(operationItsupport.getItsupport_status())
        .itsupport_deadline_project(operationItsupport.getItsupport_deadline_project())
        .itsupport_project_done(operationItsupport.getItsupport_project_done())

        .build();
    }

    @Transactional
    public List<OperationItsupportResponse> findItsupport(String userid, String input) {
        
        validationService.validateRequest(userid);

        List<OperationItsupport> itsupportByName = OperationItsupportRepository.searchByItsupport_perihalorItsupport_pic(input);

        List<OperationItsupportResponse> response = itsupportByName.stream()
        .map(item -> new OperationItsupportResponse(
            item.getItsupport_id(),
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
            itsupportByName.size()))
            .collect(Collectors.toList());

            return response;
    }

    @Transactional
    public OperationItsupportResponse editedItsupport(String userid, OperationItsupportRequest request, String input) {

        validationService.validateRequest(userid);

        OperationItsupport operationItsupport = OperationItsupportRepository.findById(input)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not Found"));

            operationItsupport.setItsupport_perihal(request.getItsupport_perihal());
            operationItsupport.setItsupport_pic(request.getItsupport_pic());
            operationItsupport.setDepartement(request.getDepartement());
            operationItsupport.setItsupport_phase1(request.getItsupport_phase1());
            operationItsupport.setItsupport_phase1_start(request.getItsupport_phase1_start());
            operationItsupport.setItsupport_phase1_deadline(request.getItsupport_phase1_deadline());
            operationItsupport.setItsupport_phase1_done(request.getItsupport_phase1_done());
            operationItsupport.setItsupport_phase2(request.getItsupport_phase2());
            operationItsupport.setItsupport_phase2_start(request.getItsupport_phase2_start());
            operationItsupport.setItsupport_phase2_deadline(request.getItsupport_phase2_deadline());
            operationItsupport.setItsupport_phase2_done(request.getItsupport_phase2_done());
            operationItsupport.setItsupport_phase3(request.getItsupport_phase3());
            operationItsupport.setItsupport_phase3_start(request.getItsupport_phase3_start());
            operationItsupport.setItsupport_phase3_deadline(request.getItsupport_phase3_deadline());
            operationItsupport.setItsupport_phase3_done(request.getItsupport_phase3_done());
            operationItsupport.setItsupport_phase4(request.getItsupport_phase4());
            operationItsupport.setItsupport_phase4_start(request.getItsupport_phase4_start());
            operationItsupport.setItsupport_phase4_deadline(request.getItsupport_phase4_deadline());
            operationItsupport.setItsupport_phase4_done(request.getItsupport_phase4_done());
            operationItsupport.setItsupport_phase5(request.getItsupport_phase5());
            operationItsupport.setItsupport_phase5_start(request.getItsupport_phase5_start());
            operationItsupport.setItsupport_phase5_deadline(request.getItsupport_phase5_deadline());
            operationItsupport.setItsupport_phase5_done(request.getItsupport_phase5_done());
            operationItsupport.setItsupport_phase6(request.getItsupport_phase6());
            operationItsupport.setItsupport_phase6_start(request.getItsupport_phase6_start());
            operationItsupport.setItsupport_phase6_deadline(request.getItsupport_phase6_deadline());
            operationItsupport.setItsupport_phase6_done(request.getItsupport_phase6_done());
            operationItsupport.setItsupport_phase7(request.getItsupport_phase7());
            operationItsupport.setItsupport_phase7_start(request.getItsupport_phase7_start());
            operationItsupport.setItsupport_phase7_deadline(request.getItsupport_phase7_deadline());
            operationItsupport.setItsupport_phase7_done(request.getItsupport_phase7_done());
            operationItsupport.setItsupport_status(request.getItsupport_status());
            operationItsupport.setItsupport_deadline_project(request.getItsupport_deadline_project());
            operationItsupport.setItsupport_project_done(request.getItsupport_project_done());

        OperationItsupportRepository.save(operationItsupport);

            return OperationItsupportResponse.builder()
            .itsupport_perihal(operationItsupport.getItsupport_perihal())
            .itsupport_pic(operationItsupport.getItsupport_pic())
            .departement(operationItsupport.getDepartement())

            .itsupport_phase1(operationItsupport.getItsupport_phase1())
            .itsupport_phase1_start(operationItsupport.getItsupport_phase1_start())
            .itsupport_phase1_deadline(operationItsupport.getItsupport_phase1_deadline())
            .itsupport_phase1_done(operationItsupport.getItsupport_phase1_done())

            .itsupport_phase2(operationItsupport.getItsupport_phase2())
            .itsupport_phase2_start(operationItsupport.getItsupport_phase2_start())
            .itsupport_phase2_deadline(operationItsupport.getItsupport_phase2_deadline())
            .itsupport_phase2_done(operationItsupport.getItsupport_phase2_done())

            .itsupport_phase3(operationItsupport.getItsupport_phase3())
            .itsupport_phase3_start(operationItsupport.getItsupport_phase3_start())
            .itsupport_phase3_deadline(operationItsupport.getItsupport_phase3_deadline())
            .itsupport_phase3_done(operationItsupport.getItsupport_phase3_done())

            .itsupport_phase4(operationItsupport.getItsupport_phase4())
            .itsupport_phase4_start(operationItsupport.getItsupport_phase4_start())
            .itsupport_phase4_deadline(operationItsupport.getItsupport_phase4_deadline())
            .itsupport_phase4_done(operationItsupport.getItsupport_phase4_done())

            .itsupport_phase5(operationItsupport.getItsupport_phase5())
            .itsupport_phase5_start(operationItsupport.getItsupport_phase5_start())
            .itsupport_phase5_deadline(operationItsupport.getItsupport_phase5_deadline())
            .itsupport_phase5_done(operationItsupport.getItsupport_phase5_done())

            .itsupport_phase6(operationItsupport.getItsupport_phase6())
            .itsupport_phase6_start(operationItsupport.getItsupport_phase6_start())
            .itsupport_phase6_deadline(operationItsupport.getItsupport_phase6_deadline())
            .itsupport_phase6_done(operationItsupport.getItsupport_phase6_done())

            .itsupport_phase7(operationItsupport.getItsupport_phase7())
            .itsupport_phase7_start(operationItsupport.getItsupport_phase7_start())
            .itsupport_phase7_deadline(operationItsupport.getItsupport_phase7_deadline())
            .itsupport_phase7_done(operationItsupport.getItsupport_phase7_done())

            .itsupport_status(operationItsupport.getItsupport_status())
            .itsupport_deadline_project(operationItsupport.getItsupport_deadline_project())
            .itsupport_project_done(operationItsupport.getItsupport_project_done())
            .build();
    }

    @Transactional
    public List<OperationItsupportResponse> findAll(String userid, Long start, Long size) {

        validationService.validateRequest(userid);

        List<OperationItsupport> operationItsupportShowAll = OperationItsupportRepository.findAll();

        List<OperationItsupportResponse> response = operationItsupportShowAll.stream()
        .skip(start).limit(size)
        .map(item -> new OperationItsupportResponse(
            item.getItsupport_id(),
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
            operationItsupportShowAll.size()))
            .collect(Collectors.toList());

            return response;
    }
}
