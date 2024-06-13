package com.damas.dbdamas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.LogApproveSkse;
import com.damas.dbdamas.payload.LogApproveSkseResponse;
import com.damas.dbdamas.payload.SkseRequest;
import com.damas.dbdamas.repository.LogApproveSkseRepository;
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

        logApproveSkseRepository.save(request);

        return "request submitted";
    }

    @Transactional
    public List<LogApproveSkseResponse> findAll(String userid, Long start, Long size){
        validationSecureService.validateUsers(userid);

        List<LogApproveSkse> skseAll = logApproveSkseRepository.findAll();

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
        item.getDeadline(),
        item.getStatus(),
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
            item.getDeadline(),
            item.getStatus(),
            logByPerihal.size()))
            .collect((Collectors.toList()));
            return response;
         }

    @Transactional
    public String updateStatusLog(String userid, String id, String status){
        validationSecureService.validateUsers(userid);

        LogApproveSkse result = logApproveSkseRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "log not found!");
        });

        result.setStatusApprovement(status);

        SkseRequest inputRequestSkse = new SkseRequest();
        inputRequestSkse.setNosurat(result.getNosurat());
        inputRequestSkse.setPerihal(result.getPerihal());
        inputRequestSkse.setPic(result.getPic());
        inputRequestSkse.setDepartement(result.getDepartement());
        inputRequestSkse.setDeadline(result.getDeadline());
        inputRequestSkse.setStatus(result.getStatus());
       

        if (status.toUpperCase().equals("APPROVED")) {
            skseService.editedSkse(userid, inputRequestSkse, result.getIdskse());
            
        }
        log.info(result.getId());

        logApproveSkseRepository.save(result);

        return "Status Update: " + status;


    }
    
}
