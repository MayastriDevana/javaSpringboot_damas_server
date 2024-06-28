package com.damas.dbdamas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.OperationItmo;
import com.damas.dbdamas.payload.OperationItmoRequest;
import com.damas.dbdamas.payload.OperationItmoResponse;
import com.damas.dbdamas.repository.OperationItmoRepository;

import jakarta.transaction.Transactional;

@Service
public class OperationItmoService {

    @Autowired
    private OperationItmoRepository OperationItmoRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public OperationItmoResponse newItmo(OperationItmoRequest request, String userid) {
        validationService.validateUsers(userid);

        if (!(validationService.isOperator(userid) || validationService.isItmoOperator(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        OperationItmo operationItmo = new OperationItmo();
        operationItmo.setItmo_perihal(request.getItmo_perihal());
        operationItmo.setItmo_pic(request.getItmo_pic());
        operationItmo.setDepartement(request.getDepartement());
        operationItmo.setItmo_phase1(request.getItmo_phase1());
        operationItmo.setItmo_phase1_start(request.getItmo_phase1_start());
        operationItmo.setItmo_phase1_deadline(request.getItmo_phase1_deadline());
        operationItmo.setItmo_phase1_done(request.getItmo_phase1_done());
        operationItmo.setItmo_phase2(request.getItmo_phase2());
        operationItmo.setItmo_phase2_start(request.getItmo_phase2_start());
        operationItmo.setItmo_phase2_deadline(request.getItmo_phase2_deadline());
        operationItmo.setItmo_phase2_done(request.getItmo_phase2_done());
        operationItmo.setItmo_phase3(request.getItmo_phase3());
        operationItmo.setItmo_phase3_start(request.getItmo_phase3_start());
        operationItmo.setItmo_phase3_deadline(request.getItmo_phase3_deadline());
        operationItmo.setItmo_phase3_done(request.getItmo_phase3_done());
        operationItmo.setItmo_phase4(request.getItmo_phase4());
        operationItmo.setItmo_phase4_start(request.getItmo_phase4_start());
        operationItmo.setItmo_phase4_deadline(request.getItmo_phase4_deadline());
        operationItmo.setItmo_phase4_done(request.getItmo_phase4_done());
        operationItmo.setItmo_phase5(request.getItmo_phase5());
        operationItmo.setItmo_phase5_start(request.getItmo_phase5_start());
        operationItmo.setItmo_phase5_deadline(request.getItmo_phase5_deadline());
        operationItmo.setItmo_phase5_done(request.getItmo_phase5_done());
        operationItmo.setItmo_phase6(request.getItmo_phase6());
        operationItmo.setItmo_phase6_start(request.getItmo_phase6_start());
        operationItmo.setItmo_phase6_deadline(request.getItmo_phase6_deadline());
        operationItmo.setItmo_phase6_done(request.getItmo_phase6_done());
        operationItmo.setItmo_phase7(request.getItmo_phase7());
        operationItmo.setItmo_phase7_start(request.getItmo_phase7_start());
        operationItmo.setItmo_phase7_deadline(request.getItmo_phase7_deadline());
        operationItmo.setItmo_phase7_done(request.getItmo_phase7_done());
        operationItmo.setItmo_status(request.getItmo_status());
        operationItmo.setItmo_deadline_project(request.getItmo_deadline_project());
        operationItmo.setItmo_project_done(request.getItmo_project_done());
        operationItmo.setCreatedBy(request.getCreatedBy());
        operationItmo.setUserdomain(request.getUserdomain());
        operationItmo.setUserdomain_pic(request.getUserdomain_pic());

        OperationItmoRepository.save(operationItmo);

        return OperationItmoResponse.builder()
                .itmo_perihal(operationItmo.getItmo_perihal())
                .itmo_pic(operationItmo.getItmo_pic())
                .departement(operationItmo.getDepartement())

                .itmo_phase1(operationItmo.getItmo_phase1())
                .itmo_phase1_start(operationItmo.getItmo_phase1_start())
                .itmo_phase1_deadline(operationItmo.getItmo_phase1_deadline())
                .itmo_phase1_done(operationItmo.getItmo_phase1_done())

                .itmo_phase2(operationItmo.getItmo_phase2())
                .itmo_phase2_start(operationItmo.getItmo_phase2_start())
                .itmo_phase2_deadline(operationItmo.getItmo_phase2_deadline())
                .itmo_phase2_done(operationItmo.getItmo_phase2_done())

                .itmo_phase3(operationItmo.getItmo_phase3())
                .itmo_phase3_start(operationItmo.getItmo_phase3_start())
                .itmo_phase3_deadline(operationItmo.getItmo_phase3_deadline())
                .itmo_phase3_done(operationItmo.getItmo_phase3_done())

                .itmo_phase4(operationItmo.getItmo_phase4())
                .itmo_phase4_start(operationItmo.getItmo_phase4_start())
                .itmo_phase4_deadline(operationItmo.getItmo_phase4_deadline())
                .itmo_phase4_done(operationItmo.getItmo_phase4_done())

                .itmo_phase5(operationItmo.getItmo_phase5())
                .itmo_phase5_start(operationItmo.getItmo_phase5_start())
                .itmo_phase5_deadline(operationItmo.getItmo_phase5_deadline())
                .itmo_phase5_done(operationItmo.getItmo_phase5_done())

                .itmo_phase6(operationItmo.getItmo_phase6())
                .itmo_phase6_start(operationItmo.getItmo_phase6_start())
                .itmo_phase6_deadline(operationItmo.getItmo_phase6_deadline())
                .itmo_phase6_done(operationItmo.getItmo_phase6_done())

                .itmo_phase7(operationItmo.getItmo_phase7())
                .itmo_phase7_start(operationItmo.getItmo_phase7_start())
                .itmo_phase7_deadline(operationItmo.getItmo_phase7_deadline())
                .itmo_phase7_done(operationItmo.getItmo_phase7_done())

                .itmo_status(operationItmo.getItmo_status())
                .itmo_deadline_project(operationItmo.getItmo_deadline_project())
                .itmo_project_done(operationItmo.getItmo_project_done())
                .createdBy(operationItmo.getCreatedBy())
                .userdomain(operationItmo.getUserdomain())
                .userdomain_pic(operationItmo.getUserdomain_pic())

                .build();
    }

    @Transactional
    public List<OperationItmoResponse> findItmo(String userid, String input) {

        validationService.validateRequest(userid);

        List<OperationItmo> itmoByName = OperationItmoRepository.searchByItmo_perihalorItmo_pic(input);

        List<OperationItmoResponse> response = itmoByName.stream()
                .map(item -> new OperationItmoResponse(
                        item.getItmo_id(),
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
                        itmoByName.size()))
                .collect(Collectors.toList());

        return response;

    }

    @Transactional
    public OperationItmoResponse editedItmo(String userid, OperationItmoRequest request, String input) {

        validationService.validateRequest(userid);

        if (!(validationService.isOperator(userid) || validationService.isItmoOperator(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        OperationItmo operationItmo = OperationItmoRepository.findById(input)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found"));

        operationItmo.setItmo_perihal(request.getItmo_perihal());
        operationItmo.setItmo_pic(request.getItmo_pic());
        operationItmo.setDepartement(request.getDepartement());
        operationItmo.setItmo_phase1(request.getItmo_phase1());
        operationItmo.setItmo_phase1_start(request.getItmo_phase1_start());
        operationItmo.setItmo_phase1_deadline(request.getItmo_phase1_deadline());
        operationItmo.setItmo_phase1_done(request.getItmo_phase1_done());
        operationItmo.setItmo_phase2(request.getItmo_phase2());
        operationItmo.setItmo_phase2_start(request.getItmo_phase2_start());
        operationItmo.setItmo_phase2_deadline(request.getItmo_phase2_deadline());
        operationItmo.setItmo_phase2_done(request.getItmo_phase2_done());
        operationItmo.setItmo_phase3(request.getItmo_phase3());
        operationItmo.setItmo_phase3_start(request.getItmo_phase3_start());
        operationItmo.setItmo_phase3_deadline(request.getItmo_phase3_deadline());
        operationItmo.setItmo_phase3_done(request.getItmo_phase3_done());
        operationItmo.setItmo_phase4(request.getItmo_phase4());
        operationItmo.setItmo_phase4_start(request.getItmo_phase4_start());
        operationItmo.setItmo_phase4_deadline(request.getItmo_phase4_deadline());
        operationItmo.setItmo_phase4_done(request.getItmo_phase4_done());
        operationItmo.setItmo_phase5(request.getItmo_phase5());
        operationItmo.setItmo_phase5_start(request.getItmo_phase5_start());
        operationItmo.setItmo_phase5_deadline(request.getItmo_phase5_deadline());
        operationItmo.setItmo_phase5_done(request.getItmo_phase5_done());
        operationItmo.setItmo_phase6(request.getItmo_phase6());
        operationItmo.setItmo_phase6_start(request.getItmo_phase6_start());
        operationItmo.setItmo_phase6_deadline(request.getItmo_phase6_deadline());
        operationItmo.setItmo_phase6_done(request.getItmo_phase6_done());
        operationItmo.setItmo_phase7(request.getItmo_phase7());
        operationItmo.setItmo_phase7_start(request.getItmo_phase7_start());
        operationItmo.setItmo_phase7_deadline(request.getItmo_phase7_deadline());
        operationItmo.setItmo_phase7_done(request.getItmo_phase7_done());
        operationItmo.setItmo_status(request.getItmo_status());
        operationItmo.setItmo_deadline_project(request.getItmo_deadline_project());
        operationItmo.setItmo_project_done(request.getItmo_project_done());
        operationItmo.setCreatedBy(request.getCreatedBy());
        operationItmo.setUserdomain(request.getUserdomain());
        operationItmo.setUserdomain_pic(request.getUserdomain_pic());

        OperationItmoRepository.save(operationItmo);

        return OperationItmoResponse.builder()
                .itmo_perihal(operationItmo.getItmo_perihal())
                .itmo_pic(operationItmo.getItmo_pic())
                .departement(operationItmo.getDepartement())

                .itmo_phase1(operationItmo.getItmo_phase1())
                .itmo_phase1_start(operationItmo.getItmo_phase1_start())
                .itmo_phase1_deadline(operationItmo.getItmo_phase1_deadline())
                .itmo_phase1_done(operationItmo.getItmo_phase1_done())

                .itmo_phase2(operationItmo.getItmo_phase2())
                .itmo_phase2_start(operationItmo.getItmo_phase2_start())
                .itmo_phase2_deadline(operationItmo.getItmo_phase2_deadline())
                .itmo_phase2_done(operationItmo.getItmo_phase2_done())

                .itmo_phase3(operationItmo.getItmo_phase3())
                .itmo_phase3_start(operationItmo.getItmo_phase3_start())
                .itmo_phase3_deadline(operationItmo.getItmo_phase3_deadline())
                .itmo_phase3_done(operationItmo.getItmo_phase3_done())

                .itmo_phase4(operationItmo.getItmo_phase4())
                .itmo_phase4_start(operationItmo.getItmo_phase4_start())
                .itmo_phase4_deadline(operationItmo.getItmo_phase4_deadline())
                .itmo_phase4_done(operationItmo.getItmo_phase4_done())

                .itmo_phase5(operationItmo.getItmo_phase5())
                .itmo_phase5_start(operationItmo.getItmo_phase5_start())
                .itmo_phase5_deadline(operationItmo.getItmo_phase5_deadline())
                .itmo_phase5_done(operationItmo.getItmo_phase5_done())

                .itmo_phase6(operationItmo.getItmo_phase6())
                .itmo_phase6_start(operationItmo.getItmo_phase6_start())
                .itmo_phase6_deadline(operationItmo.getItmo_phase6_deadline())
                .itmo_phase6_done(operationItmo.getItmo_phase6_done())

                .itmo_phase7(operationItmo.getItmo_phase7())
                .itmo_phase7_start(operationItmo.getItmo_phase7_start())
                .itmo_phase7_deadline(operationItmo.getItmo_phase7_deadline())
                .itmo_phase7_done(operationItmo.getItmo_phase7_done())

                .itmo_status(operationItmo.getItmo_status())
                .itmo_deadline_project(operationItmo.getItmo_deadline_project())
                .itmo_project_done(operationItmo.getItmo_project_done())
                .createdBy(operationItmo.getCreatedBy())
                .userdomain(operationItmo.getUserdomain())
                .userdomain_pic(operationItmo.getUserdomain_pic())
                .build();

    }

    @Transactional
    public List<OperationItmoResponse> findAll(String userid, Long start, Long size) {

        validationService.validateRequest(userid);

        if (!(validationService.isOperator(userid) || validationService.isItmoOperator(userid)
                || validationService.isOperationSupervisor(userid)
                || validationService.isSupervisor(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        List<OperationItmo> operationItmoShowAll = OperationItmoRepository.findAll();

        List<OperationItmoResponse> response = operationItmoShowAll.stream()
                .skip(start).limit(size)
                .map(item -> new OperationItmoResponse(
                        item.getItmo_id(),
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
                        operationItmoShowAll.size()))
                .collect(Collectors.toList());

        return response;
    }

    @Transactional
public List<OperationItmoResponse> findByUserdomainOrderByDeadline(String userid, Long start, Long size, String userdomain) {
      
    // Melakukan validasi terhadap user yang sedang login
    validationService.validateRequest(userid);

    if (!(validationService.isOperator(userid) || validationService.isItmoOperator(userid) || validationService.isPpoSupervisor(userid) || validationService.isDevSupervisor(userid) || validationService.isSupervisor(userid) || validationService.isPpoOperator(userid))) {
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
    }

    // Mengambil data proyek berdasarkan userdomain
    List<OperationItmo> operationItmoAll = OperationItmoRepository.findByUserdomainOrderByDeadline(userdomain);

    List<OperationItmoResponse> response = operationItmoAll.stream()
            .skip(start).limit(size)
            .map(item -> new OperationItmoResponse(
                item.getItmo_id(),
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
                operationItmoAll.size()))
            .collect(Collectors.toList());

    return response;
}
}
