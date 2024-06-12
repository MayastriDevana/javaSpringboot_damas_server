package com.damas.dbdamas.service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.OperationNetwork;
import com.damas.dbdamas.model.User;
import com.damas.dbdamas.payload.OperationNetworkRequest;
import com.damas.dbdamas.payload.OperationNetworkResponse;
import com.damas.dbdamas.repository.OperationNetworkRepository;
import com.damas.dbdamas.repository.UserRepository;

import jakarta.transaction.Transactional;
@Service
public class OperationNetworkService {
    
    @Autowired
    private OperationNetworkRepository OperationNetworkRepository;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private Environment env;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public OperationNetworkResponse newNetwork(OperationNetworkRequest userid, String token) {
        validationService.validateRequest(userid);


        OperationNetwork operationNetwork = new OperationNetwork();
        operationNetwork.setNetwork_perihal(userid.getNetwork_perihal());
        operationNetwork.setNetwork_pic(userid.getNetwork_pic());
        operationNetwork.setDepartement(userid.getDepartement());
        operationNetwork.setNetwork_kickoff_start(userid.getNetwork_kickoff_start());
        operationNetwork.setNetwork_kickoff_end(userid.getNetwork_kickoff_end());
        operationNetwork.setNetwork_kickoff_acct_end(userid.getNetwork_kickoff_acct_end());
        operationNetwork.setNetwork_mop_start(userid.getNetwork_mop_start());
        operationNetwork.setNetwork_mop_end(userid.getNetwork_mop_end());
        operationNetwork.setNetwork_mop_acct_end(userid.getNetwork_mop_acct_end());
        operationNetwork.setNetwork_demomop_start(userid.getNetwork_demomop_start());
        operationNetwork.setNetwork_demomop_end(userid.getNetwork_demomop_end());
        operationNetwork.setNetwork_demomop_acct_end(userid.getNetwork_demomop_acct_end());
        operationNetwork.setNetwork_implementasi_start(userid.getNetwork_implementasi_start());
        operationNetwork.setNetwork_implementasi_end(userid.getNetwork_implementasi_end());
        operationNetwork.setNetwork_implementasi_acct_end(userid.getNetwork_implementasi_acct_end());
        operationNetwork.setNetwork_skse_start(userid.getNetwork_skse_start());
        operationNetwork.setNetwork_skse_end(userid.getNetwork_skse_end());
        operationNetwork.setNetwork_skse_acct_end(userid.getNetwork_skse_acct_end());
        operationNetwork.setNetwork_uat_start(userid.getNetwork_uat_start());
        operationNetwork.setNetwork_uat_end(userid.getNetwork_uat_end());
        operationNetwork.setNetwork_uat_acct_end(userid.getNetwork_uat_acct_end());
        operationNetwork.setNetwork_status(userid.getNetwork_status());
        operationNetwork.setNetwork_deadline_project(userid.getNetwork_deadline_project());

        OperationNetworkRepository.save(operationNetwork);

        return OperationNetworkResponse.builder()
        .network_perihal(operationNetwork.getNetwork_perihal())
        .network_pic(operationNetwork.getNetwork_pic())
        .departement(operationNetwork.getDepartement())
        .network_kickoff_start(operationNetwork.getNetwork_kickoff_start())
        .network_kickoff_end(operationNetwork.getNetwork_kickoff_end())
        .network_kickoff_acct_end(operationNetwork.getNetwork_kickoff_acct_end())
        .network_mop_start(operationNetwork.getNetwork_mop_start())
        .network_mop_end(operationNetwork.getNetwork_mop_end())
        .network_mop_acct_end(operationNetwork.getNetwork_mop_acct_end())
        .network_demomop_start(operationNetwork.getNetwork_demomop_start())
        .network_demomop_end(operationNetwork.getNetwork_demomop_end())
        .network_demomop_acct_end(operationNetwork.getNetwork_demomop_acct_end())
        .network_implementasi_start(operationNetwork.getNetwork_implementasi_start())
        .network_implementasi_end(operationNetwork.getNetwork_implementasi_end())
        .network_implementasi_acct_end(operationNetwork.getNetwork_implementasi_acct_end())
        .network_skse_start(operationNetwork.getNetwork_skse_start())
        .network_skse_end(operationNetwork.getNetwork_skse_end())
        .network_skse_acct_end(operationNetwork.getNetwork_skse_acct_end())
        .network_uat_start(operationNetwork.getNetwork_uat_start())
        .network_uat_end(operationNetwork.getNetwork_uat_end())
        .network_uat_acct_end(operationNetwork.getNetwork_uat_acct_end())
        .network_status(operationNetwork.getNetwork_status())
        .network_deadline_project(operationNetwork.getNetwork_deadline_project())
        .build();

    }

    @Transactional
    public List<OperationNetworkResponse> findNetwork(String userid, String input){

        validationService.validateRequest(userid);

        List<OperationNetwork> networkByName = OperationNetworkRepository.searchByNetwork_perihalorNetwork_pic(input);

        List<OperationNetworkResponse> response = networkByName.stream()
        .map(item -> new OperationNetworkResponse(
            item.getNetwork_id(),
            item.getNetwork_perihal(),
            item.getNetwork_pic(),
            item.getDepartement(),
            item.getNetwork_kickoff_start(),
            item.getNetwork_kickoff_end(),
            item.getNetwork_kickoff_acct_end(),
            item.getNetwork_mop_start(),
            item.getNetwork_mop_end(),
            item.getNetwork_mop_acct_end(),
            item.getNetwork_demomop_start(),
            item.getNetwork_demomop_end(),
            item.getNetwork_demomop_acct_end(),
            item.getNetwork_implementasi_start(),
            item.getNetwork_implementasi_end(),
            item.getNetwork_implementasi_acct_end(),
            item.getNetwork_skse_start(),
            item.getNetwork_skse_end(),
            item.getNetwork_skse_acct_end(),
            item.getNetwork_uat_start(),
            item.getNetwork_uat_end(),
            item.getNetwork_uat_acct_end(),
            item.getNetwork_status(),
            item.getNetwork_deadline_project(),
            networkByName.size()))
            .collect((Collectors.toList()));

        return response;
    }

    @Transactional
    public OperationNetworkResponse editedNetwork(String userid, OperationNetworkRequest request, String input) {

        validationService.validateRequest(userid);


        OperationNetwork operationNetwork = OperationNetworkRepository.findById(input)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Network not found"));

                operationNetwork.setNetwork_perihal(request.getNetwork_perihal());
                operationNetwork.setNetwork_pic(request.getNetwork_pic());
                operationNetwork.setDepartement(request.getDepartement());
                operationNetwork.setNetwork_kickoff_start(request.getNetwork_kickoff_start());
                operationNetwork.setNetwork_kickoff_end(request.getNetwork_kickoff_end());
                operationNetwork.setNetwork_kickoff_acct_end(request.getNetwork_kickoff_acct_end());
                operationNetwork.setNetwork_mop_start(request.getNetwork_mop_start());
                operationNetwork.setNetwork_mop_end(request.getNetwork_mop_end());
                operationNetwork.setNetwork_mop_acct_end(request.getNetwork_mop_acct_end());
                operationNetwork.setNetwork_demomop_start(request.getNetwork_demomop_start());
                operationNetwork.setNetwork_demomop_end(request.getNetwork_demomop_end());
                operationNetwork.setNetwork_demomop_acct_end(request.getNetwork_demomop_acct_end());
                operationNetwork.setNetwork_implementasi_start(request.getNetwork_implementasi_start());
                operationNetwork.setNetwork_implementasi_end(request.getNetwork_implementasi_end());
                operationNetwork.setNetwork_implementasi_acct_end(request.getNetwork_implementasi_acct_end());
                operationNetwork.setNetwork_skse_start(request.getNetwork_skse_start());
                operationNetwork.setNetwork_skse_end(request.getNetwork_skse_end());
                operationNetwork.setNetwork_skse_acct_end(request.getNetwork_skse_acct_end());
                operationNetwork.setNetwork_uat_start(request.getNetwork_uat_start());
                operationNetwork.setNetwork_uat_end(request.getNetwork_uat_end());
                operationNetwork.setNetwork_uat_acct_end(request.getNetwork_uat_acct_end());
                operationNetwork.setNetwork_status(request.getNetwork_status());
                operationNetwork.setNetwork_deadline_project(request.getNetwork_deadline_project());

        OperationNetworkRepository.save(operationNetwork);

        return OperationNetworkResponse.builder()
        .network_perihal(operationNetwork.getNetwork_perihal())
        .network_pic(operationNetwork.getNetwork_pic())
        .departement(operationNetwork.getDepartement())
        .network_kickoff_start(operationNetwork.getNetwork_kickoff_start())
        .network_kickoff_end(operationNetwork.getNetwork_kickoff_end())
        .network_kickoff_acct_end(operationNetwork.getNetwork_kickoff_acct_end())
        .network_mop_start(operationNetwork.getNetwork_mop_start())
        .network_mop_end(operationNetwork.getNetwork_mop_end())
        .network_mop_acct_end(operationNetwork.getNetwork_mop_acct_end())
        .network_demomop_start(operationNetwork.getNetwork_demomop_start())
        .network_demomop_end(operationNetwork.getNetwork_demomop_end())
        .network_demomop_acct_end(operationNetwork.getNetwork_demomop_acct_end())
        .network_implementasi_start(operationNetwork.getNetwork_implementasi_start())
        .network_implementasi_end(operationNetwork.getNetwork_implementasi_end())
        .network_implementasi_acct_end(operationNetwork.getNetwork_implementasi_acct_end())
        .network_skse_start(operationNetwork.getNetwork_skse_start())
        .network_skse_end(operationNetwork.getNetwork_skse_end())
        .network_skse_acct_end(operationNetwork.getNetwork_skse_acct_end())
        .network_uat_start(operationNetwork.getNetwork_uat_start())
        .network_uat_end(operationNetwork.getNetwork_uat_end())
        .network_uat_acct_end(operationNetwork.getNetwork_uat_acct_end())
        .network_status(operationNetwork.getNetwork_status())
        .network_deadline_project(operationNetwork.getNetwork_deadline_project())
        .build();
    }

    @Transactional
    public List<OperationNetworkResponse> findAll(String userid, Long start, Long size) {
        validationService.validateRequest(userid);

        

        List<OperationNetwork> operationNetworkShowAll = OperationNetworkRepository.findAll();

        List<OperationNetworkResponse> response = operationNetworkShowAll.stream()
        .skip(start).limit(size)
        .map(item -> new OperationNetworkResponse(
            item.getNetwork_id(),
            item.getNetwork_perihal(),
            item.getNetwork_pic(),
            item.getDepartement(),
            item.getNetwork_kickoff_start(),
            item.getNetwork_kickoff_end(),
            item.getNetwork_kickoff_acct_end(),
            item.getNetwork_mop_start(),
            item.getNetwork_mop_end(),
            item.getNetwork_mop_acct_end(),
            item.getNetwork_demomop_start(),
            item.getNetwork_demomop_end(),
            item.getNetwork_demomop_acct_end(),
            item.getNetwork_implementasi_start(),
            item.getNetwork_implementasi_end(),
            item.getNetwork_implementasi_acct_end(),
            item.getNetwork_skse_start(),
            item.getNetwork_skse_end(),
            item.getNetwork_skse_acct_end(),
            item.getNetwork_uat_start(),
            item.getNetwork_uat_end(),
            item.getNetwork_uat_acct_end(),
            item.getNetwork_status(),
            item.getNetwork_deadline_project(),
            operationNetworkShowAll.size()
        ))
    .collect(Collectors.toList());

        return response;
    }

   
}
