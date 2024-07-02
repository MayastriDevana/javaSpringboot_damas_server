package com.damas.dbdamas.service.Operation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.Operation.OperationDacen;
import com.damas.dbdamas.payload.Operation.OperationDacenRequest;
import com.damas.dbdamas.payload.Operation.OperationDacenResponse;
import com.damas.dbdamas.repository.Operation.OperationDacenRepository;
import com.damas.dbdamas.service.ValidationService;

import jakarta.transaction.Transactional;

@Service
public class OperationDacenService {
    
    @Autowired
    private OperationDacenRepository OperationDacenRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public OperationDacenResponse newDacen(OperationDacenRequest request, String userid) {
        validationService.validateUsers(userid);

        if (!(validationService.isOperator(userid) || validationService.isDacenOperator(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }
        
        OperationDacen operationDacen = new OperationDacen();
        operationDacen.setDacen_perihal(request.getDacen_perihal());
        operationDacen.setDacen_pic(request.getDacen_pic());
        operationDacen.setDepartement(request.getDepartement());
        operationDacen.setDacen_phase1(request.getDacen_phase1());
        operationDacen.setDacen_phase1_start(request.getDacen_phase1_start());
        operationDacen.setDacen_phase1_deadline(request.getDacen_phase1_deadline());
        operationDacen.setDacen_phase1_done(request.getDacen_phase1_done());
        operationDacen.setDacen_phase2(request.getDacen_phase2());
        operationDacen.setDacen_phase2_start(request.getDacen_phase2_start());
        operationDacen.setDacen_phase2_deadline(request.getDacen_phase2_deadline());
        operationDacen.setDacen_phase2_done(request.getDacen_phase2_done());
        operationDacen.setDacen_phase3(request.getDacen_phase3());
        operationDacen.setDacen_phase3_start(request.getDacen_phase3_start());
        operationDacen.setDacen_phase3_deadline(request.getDacen_phase3_deadline());
        operationDacen.setDacen_phase3_done(request.getDacen_phase3_done());
        operationDacen.setDacen_phase4(request.getDacen_phase4());
        operationDacen.setDacen_phase4_start(request.getDacen_phase4_start());
        operationDacen.setDacen_phase4_deadline(request.getDacen_phase4_deadline());
        operationDacen.setDacen_phase4_done(request.getDacen_phase4_done());
        operationDacen.setDacen_phase5(request.getDacen_phase5());
        operationDacen.setDacen_phase5_start(request.getDacen_phase5_start());
        operationDacen.setDacen_phase5_deadline(request.getDacen_phase5_deadline());
        operationDacen.setDacen_phase5_done(request.getDacen_phase5_done());
        operationDacen.setDacen_phase6(request.getDacen_phase6());
        operationDacen.setDacen_phase6_start(request.getDacen_phase6_start());
        operationDacen.setDacen_phase6_deadline(request.getDacen_phase6_deadline());
        operationDacen.setDacen_phase6_done(request.getDacen_phase6_done());
        operationDacen.setDacen_phase7(request.getDacen_phase7());
        operationDacen.setDacen_phase7_start(request.getDacen_phase7_start());
        operationDacen.setDacen_phase7_deadline(request.getDacen_phase7_deadline());
        operationDacen.setDacen_phase7_done(request.getDacen_phase7_done());
        operationDacen.setDacen_status(request.getDacen_status());
        operationDacen.setDacen_deadline_project(request.getDacen_deadline_project());
        operationDacen.setDacen_project_done(request.getDacen_project_done());
        operationDacen.setCreatedBy(request.getCreatedBy());
        operationDacen.setUserdomain(request.getUserdomain());
        operationDacen.setUserdomain_pic(request.getUserdomain_pic());

        OperationDacenRepository.save(operationDacen);

        return OperationDacenResponse.builder()
        .dacen_perihal(operationDacen.getDacen_perihal())
        .dacen_pic(operationDacen.getDacen_pic())
        .departement(operationDacen.getDepartement())

        .dacen_phase1(operationDacen.getDacen_phase1())
        .dacen_phase1_start(operationDacen.getDacen_phase1_start())
        .dacen_phase1_deadline(operationDacen.getDacen_phase1_deadline())
        .dacen_phase1_done(operationDacen.getDacen_phase1_done())

        .dacen_phase2(operationDacen.getDacen_phase2())
        .dacen_phase2_start(operationDacen.getDacen_phase2_start())
        .dacen_phase2_deadline(operationDacen.getDacen_phase2_deadline())
        .dacen_phase2_done(operationDacen.getDacen_phase2_done())

        .dacen_phase3(operationDacen.getDacen_phase3())
        .dacen_phase3_start(operationDacen.getDacen_phase3_start())
        .dacen_phase3_deadline(operationDacen.getDacen_phase3_deadline())
        .dacen_phase3_done(operationDacen.getDacen_phase3_done())

        .dacen_phase4(operationDacen.getDacen_phase4())
        .dacen_phase4_start(operationDacen.getDacen_phase4_start())
        .dacen_phase4_deadline(operationDacen.getDacen_phase4_deadline())
        .dacen_phase4_done(operationDacen.getDacen_phase4_done())

        .dacen_phase5(operationDacen.getDacen_phase5())
        .dacen_phase5_start(operationDacen.getDacen_phase5_start())
        .dacen_phase5_deadline(operationDacen.getDacen_phase5_deadline())
        .dacen_phase5_done(operationDacen.getDacen_phase5_done())

        .dacen_phase6(operationDacen.getDacen_phase6())
        .dacen_phase6_start(operationDacen.getDacen_phase6_start())
        .dacen_phase6_deadline(operationDacen.getDacen_phase6_deadline())
        .dacen_phase6_done(operationDacen.getDacen_phase6_done())

        .dacen_phase7(operationDacen.getDacen_phase7())
        .dacen_phase7_start(operationDacen.getDacen_phase7_start())
        .dacen_phase7_deadline(operationDacen.getDacen_phase7_deadline())
        .dacen_phase7_done(operationDacen.getDacen_phase7_done())

        .dacen_status(operationDacen.getDacen_status())
        .dacen_deadline_project(operationDacen.getDacen_deadline_project())
        .dacen_project_done(operationDacen.getDacen_project_done())
        .createdBy(operationDacen.getCreatedBy())
        .userdomain(operationDacen.getUserdomain())
        .userdomain_pic(operationDacen.getUserdomain_pic())

        .build();
    }

    @Transactional
    public List<OperationDacenResponse> findDacen(String userid, String input) {
        
        validationService.validateRequest(userid);

        List<OperationDacen> dacenByName = OperationDacenRepository.searchByDacen_perihalorDacen_pic(input);

        List<OperationDacenResponse> response = dacenByName.stream()
        .map(item -> new OperationDacenResponse(
            item.getDacen_id(),
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
            dacenByName.size()))
            .collect(Collectors.toList());

            return response;

    }

    @Transactional
    public OperationDacenResponse editedDacen(String userid, OperationDacenRequest request, String input) {

        validationService.validateRequest(userid);

        if (!(validationService.isOperator(userid) || validationService.isDacenOperator(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        OperationDacen operationDacen = OperationDacenRepository.findById(input)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found"));

        operationDacen.setDacen_perihal(request.getDacen_perihal());
        operationDacen.setDacen_pic(request.getDacen_pic());
        operationDacen.setDepartement(request.getDepartement());
        operationDacen.setDacen_phase1(request.getDacen_phase1());
        operationDacen.setDacen_phase1_start(request.getDacen_phase1_start());
        operationDacen.setDacen_phase1_deadline(request.getDacen_phase1_deadline());
        operationDacen.setDacen_phase1_done(request.getDacen_phase1_done());
        operationDacen.setDacen_phase2(request.getDacen_phase2());
        operationDacen.setDacen_phase2_start(request.getDacen_phase2_start());
        operationDacen.setDacen_phase2_deadline(request.getDacen_phase2_deadline());
        operationDacen.setDacen_phase2_done(request.getDacen_phase2_done());
        operationDacen.setDacen_phase3(request.getDacen_phase3());
        operationDacen.setDacen_phase3_start(request.getDacen_phase3_start());
        operationDacen.setDacen_phase3_deadline(request.getDacen_phase3_deadline());
        operationDacen.setDacen_phase3_done(request.getDacen_phase3_done());
        operationDacen.setDacen_phase4(request.getDacen_phase4());
        operationDacen.setDacen_phase4_start(request.getDacen_phase4_start());
        operationDacen.setDacen_phase4_deadline(request.getDacen_phase4_deadline());
        operationDacen.setDacen_phase4_done(request.getDacen_phase4_done());
        operationDacen.setDacen_phase5(request.getDacen_phase5());
        operationDacen.setDacen_phase5_start(request.getDacen_phase5_start());
        operationDacen.setDacen_phase5_deadline(request.getDacen_phase5_deadline());
        operationDacen.setDacen_phase5_done(request.getDacen_phase5_done());
        operationDacen.setDacen_phase6(request.getDacen_phase6());
        operationDacen.setDacen_phase6_start(request.getDacen_phase6_start());
        operationDacen.setDacen_phase6_deadline(request.getDacen_phase6_deadline());
        operationDacen.setDacen_phase6_done(request.getDacen_phase6_done());
        operationDacen.setDacen_phase7(request.getDacen_phase7());
        operationDacen.setDacen_phase7_start(request.getDacen_phase7_start());
        operationDacen.setDacen_phase7_deadline(request.getDacen_phase7_deadline());
        operationDacen.setDacen_phase7_done(request.getDacen_phase7_done());
        operationDacen.setDacen_status(request.getDacen_status());
        operationDacen.setDacen_deadline_project(request.getDacen_deadline_project());
        operationDacen.setDacen_project_done(request.getDacen_project_done());
        operationDacen.setCreatedBy(request.getCreatedBy());
        operationDacen.setUserdomain(request.getUserdomain());
        operationDacen.setUserdomain_pic(request.getUserdomain_pic());

    OperationDacenRepository.save(operationDacen);

        return OperationDacenResponse.builder()
        .dacen_perihal(operationDacen.getDacen_perihal())
        .dacen_pic(operationDacen.getDacen_pic())
        .departement(operationDacen.getDepartement())

        .dacen_phase1(operationDacen.getDacen_phase1())
        .dacen_phase1_start(operationDacen.getDacen_phase1_start())
        .dacen_phase1_deadline(operationDacen.getDacen_phase1_deadline())
        .dacen_phase1_done(operationDacen.getDacen_phase1_done())

        .dacen_phase2(operationDacen.getDacen_phase2())
        .dacen_phase2_start(operationDacen.getDacen_phase2_start())
        .dacen_phase2_deadline(operationDacen.getDacen_phase2_deadline())
        .dacen_phase2_done(operationDacen.getDacen_phase2_done())

        .dacen_phase3(operationDacen.getDacen_phase3())
        .dacen_phase3_start(operationDacen.getDacen_phase3_start())
        .dacen_phase3_deadline(operationDacen.getDacen_phase3_deadline())
        .dacen_phase3_done(operationDacen.getDacen_phase3_done())

        .dacen_phase4(operationDacen.getDacen_phase4())
        .dacen_phase4_start(operationDacen.getDacen_phase4_start())
        .dacen_phase4_deadline(operationDacen.getDacen_phase4_deadline())
        .dacen_phase4_done(operationDacen.getDacen_phase4_done())

        .dacen_phase5(operationDacen.getDacen_phase5())
        .dacen_phase5_start(operationDacen.getDacen_phase5_start())
        .dacen_phase5_deadline(operationDacen.getDacen_phase5_deadline())
        .dacen_phase5_done(operationDacen.getDacen_phase5_done())

        .dacen_phase6(operationDacen.getDacen_phase6())
        .dacen_phase6_start(operationDacen.getDacen_phase6_start())
        .dacen_phase6_deadline(operationDacen.getDacen_phase6_deadline())
        .dacen_phase6_done(operationDacen.getDacen_phase6_done())

        .dacen_phase7(operationDacen.getDacen_phase7())
        .dacen_phase7_start(operationDacen.getDacen_phase7_start())
        .dacen_phase7_deadline(operationDacen.getDacen_phase7_deadline())
        .dacen_phase7_done(operationDacen.getDacen_phase7_done())

        .dacen_status(operationDacen.getDacen_status())
        .dacen_deadline_project(operationDacen.getDacen_deadline_project())
        .dacen_project_done(operationDacen.getDacen_project_done())
        .createdBy(operationDacen.getCreatedBy())
        .userdomain(operationDacen.getUserdomain())
        .userdomain_pic(operationDacen.getUserdomain_pic())
        .build();

    }

    @Transactional
    public List<OperationDacenResponse> findAll(String userid, Long start, Long size) {

        validationService.validateRequest(userid);

        if (!(validationService.isOperator(userid) || validationService.isSupervisor(userid) || validationService.isOperationSupervisor(userid) || validationService.isDacenOperator(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        List<OperationDacen> operationDacenShowAll = OperationDacenRepository.findAll();

        List<OperationDacenResponse> response = operationDacenShowAll.stream()
        .skip(start).limit(size)
        .map(item -> new OperationDacenResponse(
            item.getDacen_id(),
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
            operationDacenShowAll.size()))
            .collect(Collectors.toList());

            return response;
    }

    @Transactional
public List<OperationDacenResponse> findByUserdomainOrderByDeadline(String userid, Long start, Long size, String userdomain) {
      
    // Melakukan validasi terhadap user yang sedang login
    validationService.validateRequest(userid);

    if (!(validationService.isOperator(userid) || validationService.isDacenOperator(userid) || validationService.isPpoSupervisor(userid) || validationService.isDevSupervisor(userid) || validationService.isSupervisor(userid) || validationService.isPpoOperator(userid))) {
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
    }

    // Mengambil data proyek berdasarkan userdomain
    List<OperationDacen> projectDacenAll = OperationDacenRepository.findByUserdomainOrderByDeadline(userdomain);

    List<OperationDacenResponse> response = projectDacenAll.stream()
            .skip(start).limit(size)
            .map(item -> new OperationDacenResponse(
                item.getDacen_id(),
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
                projectDacenAll.size()))
            .collect(Collectors.toList());

    return response;
}
}
