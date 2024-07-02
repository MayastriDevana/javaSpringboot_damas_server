package com.damas.dbdamas.service.Projectdev;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.Projectdev.LogApproveSkse;
import com.damas.dbdamas.payload.Projectdev.LogApproveSkseResponse;
import com.damas.dbdamas.payload.Projectdev.SkseRequest;
import com.damas.dbdamas.repository.Projectdev.LogApproveSkseRepository;
import com.damas.dbsecure.service.ValidationSecureService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class LogApproveSkseService {

    @Autowired
    private LogApproveSkseRepository logApproveSkseRepository;

    @Autowired
    private SkseService skseService;

    @Autowired
    ValidationSecureService validationSecureService;

    @Transactional
    public String createLog(String userid, LogApproveSkse request){
        validationSecureService.validateUsers(userid);

        if (!(validationSecureService.isOperator(userid) || validationSecureService. isSkseOperator(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        logApproveSkseRepository.save(request);

        return "request submitted";
    }

    @Transactional
    public List<LogApproveSkseResponse> findAll(String userid, Long start, Long size){
        validationSecureService.validateUsers(userid);

        if (!(validationSecureService.isOperator(userid) || validationSecureService.isSupervisor(userid) || validationSecureService.isPpoSupervisor(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        List<LogApproveSkse> skseAll = logApproveSkseRepository.searchAllOrderByStatus();

        List<LogApproveSkseResponse> response = skseAll.stream()
        .skip(start).limit(size)
        .map(item -> new LogApproveSkseResponse(
        item.getId(),
        item.getIdskse(),
        item.getSubmitter(),
        item.getAuthorizer(),
        item.getSubmitAt(),
        item.getDeadlineApprovement(),
        item.getStatusApprovement(),
        item.getNosurat(),
        item.getPerihal(),
        item.getPic(),
        item.getDepartement(),
        item.getDeadlineskse(),
        item.getStatus(),
        item.getUserdomain(),
        item.getUserdomainpic(),
        item.getCreatedby(),
        skseAll.size()))
        .collect(Collectors.toList());

        return response;
    }

    @Transactional
    public List<LogApproveSkseResponse> findLog(String userid, String input) {
        validationSecureService.validateRequest(userid);
        List<LogApproveSkse> logByPerihal = logApproveSkseRepository.searchByPerihal(input);

        List<LogApproveSkseResponse> response = logByPerihal.stream()
        .map(item -> new LogApproveSkseResponse(
            item.getId(),
            item.getIdskse(),
            item.getSubmitter(),
            item.getAuthorizer(),
            item.getSubmitAt(),
            item.getDeadlineApprovement(),
            item.getStatusApprovement(),
            item.getNosurat(),
            item.getPerihal(),
            item.getPic(),
            item.getDepartement(),
            item.getDeadlineskse(),
            item.getStatus(),
            item.getUserdomain(),
            item.getUserdomainpic(),
            item.getCreatedby(),
            logByPerihal.size()))
            .collect((Collectors.toList()));
            return response;
         }

    @Transactional
    public String updateStatusLog(String userid, String id, String status){
        validationSecureService.validateUsers(userid);

        if (!(validationSecureService.isSupervisor(userid) || validationSecureService.isPpoSupervisor(userid) || validationSecureService.isOperator(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        LogApproveSkse result = logApproveSkseRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "log not found!");
        });

        result.setStatusApprovement(status);

        SkseRequest inputRequestSkse = new SkseRequest();
        inputRequestSkse.setNosurat(result.getNosurat());
        inputRequestSkse.setPerihal(result.getPerihal());
        inputRequestSkse.setPic(result.getPic());
        inputRequestSkse.setDepartement(result.getDepartement());
        inputRequestSkse.setDeadlineskse(result.getDeadlineskse());
        inputRequestSkse.setStatus(result.getStatus());
        inputRequestSkse.setUserdomain(result.getUserdomain());
        inputRequestSkse.setUserdomainpic(result.getUserdomainpic());
        inputRequestSkse.setCreatedby(result.getCreatedby());
       

        if (status.toUpperCase().equals("APPROVED")) {
            skseService.editedSkse(userid, inputRequestSkse, result.getIdskse());
            
        }
        log.info(result.getId());

        logApproveSkseRepository.save(result);

        return "Status Update: " + status;


    }
    
}
