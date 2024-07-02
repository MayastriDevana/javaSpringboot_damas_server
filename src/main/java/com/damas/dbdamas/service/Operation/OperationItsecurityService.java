package com.damas.dbdamas.service.Operation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.Operation.OperationItsecurity;
import com.damas.dbdamas.payload.Operation.OperationItsecurityRequest;
import com.damas.dbdamas.payload.Operation.OperationItsecurityResponse;
import com.damas.dbdamas.repository.Operation.OperationItsecurityRepository;
import com.damas.dbdamas.service.ValidationService;

import jakarta.transaction.Transactional;

@Service
public class OperationItsecurityService {

    @Autowired
    private OperationItsecurityRepository OperationItsecurityRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public OperationItsecurityResponse newItsecurity(OperationItsecurityRequest request, String userid) {
        validationService.validateRequest(userid);

        if (!(validationService.isOperator(userid) || validationService.isItsecurityOperator(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        OperationItsecurity operationItsecurity = new OperationItsecurity();
        operationItsecurity.setItsecurity_pic(request.getItsecurity_pic());
        operationItsecurity.setItsecurity_perihal(request.getItsecurity_perihal());
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
        operationItsecurity.setItsecurity_project_done(request.getItsecurity_project_done());
        operationItsecurity.setCreatedBy(request.getCreatedBy());
        operationItsecurity.setUserdomain(request.getUserdomain());
        operationItsecurity.setUserdomain_pic(request.getUserdomain_pic());

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
                .itsecurity_project_done(operationItsecurity.getItsecurity_project_done())
                .createdBy(operationItsecurity.getCreatedBy())
                .userdomain(operationItsecurity.getUserdomain())
                .userdomain_pic(operationItsecurity.getUserdomain_pic())

                .build();

    }

    @Transactional
    public List<OperationItsecurityResponse> findItsecurity(String userid, String input) {

        validationService.validateRequest(userid);

        List<OperationItsecurity> itsecurityByName = OperationItsecurityRepository
                .searchByItsecurity_perihalorItsecurity_pic(input);

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
                        item.getItsecurity_project_done(),
                        item.getCreatedBy(),
                        item.getUserdomain(),
                        item.getUserdomain_pic(),
                        itsecurityByName.size()))
                .collect(Collectors.toList());

        return response;
    }

    @Transactional
    public OperationItsecurityResponse editedItsecurity(String userid, OperationItsecurityRequest request,
            String input) {

        validationService.validateRequest(userid);

        if (!(validationService.isOperator(userid) || validationService.isItsecurityOperator(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

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
        operationItsecurity.setItsecurity_project_done(request.getItsecurity_project_done());
        operationItsecurity.setCreatedBy(request.getCreatedBy());
        operationItsecurity.setUserdomain(request.getUserdomain());
        operationItsecurity.setUserdomain_pic(request.getUserdomain_pic());

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
                .itsecurity_project_done(operationItsecurity.getItsecurity_project_done())
                .createdBy(operationItsecurity.getCreatedBy())
                .userdomain(operationItsecurity.getUserdomain())
                .userdomain_pic(operationItsecurity.getUserdomain_pic())
                .build();

    }

    @Transactional
    public List<OperationItsecurityResponse> findAll(String userid, Long start, Long size) {

        validationService.validateRequest(userid);

        if (!(validationService.isOperator(userid) || validationService.isItsecurityOperator(userid)
                || validationService.isOperationSupervisor(userid)
                || validationService.isSupervisor(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

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
                        item.getItsecurity_project_done(),
                        item.getCreatedBy(),
                        item.getUserdomain(),
                        item.getUserdomain_pic(),
                        operationItsecurityShowAll.size()))
                .collect(Collectors.toList());

        return response;
    }

        @Transactional
public List<OperationItsecurityResponse> findByUserdomainOrderByDeadline(String userid, Long start, Long size, String userdomain) {
      
    // Melakukan validasi terhadap user yang sedang login
    validationService.validateRequest(userid);

    if (!(validationService.isOperator(userid) || validationService.isItsecurityOperator(userid) || validationService.isPpoSupervisor(userid) || validationService.isDevSupervisor(userid) || validationService.isSupervisor(userid) || validationService.isPpoOperator(userid))) {
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
    }

    // Mengambil data proyek berdasarkan userdomain
    List<OperationItsecurity> operationItsecurityAll = OperationItsecurityRepository.findByUserdomainOrderByDeadline(userdomain);

    List<OperationItsecurityResponse> response = operationItsecurityAll.stream()
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
                        item.getItsecurity_project_done(),
                        item.getCreatedBy(),
                        item.getUserdomain(),
                        item.getUserdomain_pic(),
                operationItsecurityAll.size()))
            .collect(Collectors.toList());

    return response;
}
}
