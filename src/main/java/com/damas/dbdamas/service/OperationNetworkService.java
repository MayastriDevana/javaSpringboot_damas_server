package com.damas.dbdamas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.OperationNetwork;
import com.damas.dbdamas.payload.OperationNetworkRequest;
import com.damas.dbdamas.payload.OperationNetworkResponse;
import com.damas.dbdamas.repository.OperationNetworkRepository;

import jakarta.transaction.Transactional;

@Service
public class OperationNetworkService {
    
    @Autowired
    private OperationNetworkRepository OperationNetworkRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public OperationNetworkResponse newNetwork(OperationNetworkRequest userid, String token) {
        validationService.validateRequest(userid);


        OperationNetwork operationNetwork = new OperationNetwork();
        operationNetwork.setNetwork_perihal(userid.getNetwork_perihal());
        operationNetwork.setNetwork_pic(userid.getNetwork_pic());
        operationNetwork.setDepartement(userid.getDepartement());
        operationNetwork.setNetwork_kickoff_start(userid.getNetwork_kickoff_start());
        operationNetwork.setNetwork_kickoff_deadline(userid.getNetwork_kickoff_deadline());
        operationNetwork.setNetwork_kickoff_done(userid.getNetwork_kickoff_done());
        operationNetwork.setNetwork_mop_start(userid.getNetwork_mop_start());
        operationNetwork.setNetwork_mop_deadline(userid.getNetwork_mop_deadline());
        operationNetwork.setNetwork_mop_done(userid.getNetwork_mop_done());
        operationNetwork.setNetwork_demomop_start(userid.getNetwork_demomop_start());
        operationNetwork.setNetwork_demomop_deadline(userid.getNetwork_demomop_deadline());
        operationNetwork.setNetwork_demomop_done(userid.getNetwork_demomop_done());
        operationNetwork.setNetwork_implementasi_start(userid.getNetwork_implementasi_start());
        operationNetwork.setNetwork_implementasi_deadline(userid.getNetwork_implementasi_deadline());
        operationNetwork.setNetwork_implementasi_done(userid.getNetwork_implementasi_done());
        operationNetwork.setNetwork_skse_start(userid.getNetwork_skse_start());
        operationNetwork.setNetwork_skse_deadline(userid.getNetwork_skse_deadline());
        operationNetwork.setNetwork_skse_done(userid.getNetwork_skse_done());
        operationNetwork.setNetwork_uat_start(userid.getNetwork_uat_start());
        operationNetwork.setNetwork_uat_deadline(userid.getNetwork_uat_deadline());
        operationNetwork.setNetwork_uat_done(userid.getNetwork_uat_done());
        operationNetwork.setNetwork_status(userid.getNetwork_status());
        operationNetwork.setNetwork_deadline_project(userid.getNetwork_deadline_project());
        operationNetwork.setNetwork_project_done(userid.getNetwork_project_done());

        OperationNetworkRepository.save(operationNetwork);

        return OperationNetworkResponse.builder()
        .network_perihal(operationNetwork.getNetwork_perihal())
        .network_pic(operationNetwork.getNetwork_pic())
        .departement(operationNetwork.getDepartement())

        .network_kickoff_start(operationNetwork.getNetwork_kickoff_start())
        .network_kickoff_deadline(operationNetwork.getNetwork_kickoff_deadline())
        .network_kickoff_done(operationNetwork.getNetwork_kickoff_done())

        .network_mop_start(operationNetwork.getNetwork_mop_start())
        .network_mop_deadline(operationNetwork.getNetwork_mop_deadline())
        .network_mop_done(operationNetwork.getNetwork_mop_done())

        .network_demomop_start(operationNetwork.getNetwork_demomop_start())
        .network_demomop_deadline(operationNetwork.getNetwork_demomop_deadline())
        .network_demomop_done(operationNetwork.getNetwork_demomop_done())

        .network_implementasi_start(operationNetwork.getNetwork_implementasi_start())
        .network_implementasi_deadline(operationNetwork.getNetwork_implementasi_deadline())
        .network_implementasi_done(operationNetwork.getNetwork_implementasi_done())

        .network_skse_start(operationNetwork.getNetwork_skse_start())
        .network_skse_deadline(operationNetwork.getNetwork_skse_deadline())
        .network_skse_done(operationNetwork.getNetwork_skse_done())

        .network_uat_start(operationNetwork.getNetwork_uat_start())
        .network_uat_deadline(operationNetwork.getNetwork_uat_deadline())
        .network_uat_done(operationNetwork.getNetwork_uat_done())
        
        .network_status(operationNetwork.getNetwork_status())
        .network_deadline_project(operationNetwork.getNetwork_deadline_project())
        .network_project_done(operationNetwork.getNetwork_project_done())
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
            item.getNetwork_kickoff_deadline(),
            item.getNetwork_kickoff_done(),
            item.getNetwork_mop_start(),
            item.getNetwork_mop_deadline(),
            item.getNetwork_mop_done(),
            item.getNetwork_demomop_start(),
            item.getNetwork_demomop_deadline(),
            item.getNetwork_demomop_done(),
            item.getNetwork_implementasi_start(),
            item.getNetwork_implementasi_deadline(),
            item.getNetwork_implementasi_done(),
            item.getNetwork_skse_start(),
            item.getNetwork_skse_deadline(),
            item.getNetwork_skse_done(),
            item.getNetwork_uat_start(),
            item.getNetwork_uat_deadline(),
            item.getNetwork_uat_done(),
            item.getNetwork_status(),
            item.getNetwork_deadline_project(),
            item.getNetwork_project_done(),
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
                operationNetwork.setNetwork_kickoff_deadline(request.getNetwork_kickoff_deadline());
                operationNetwork.setNetwork_kickoff_done(request.getNetwork_kickoff_done());
                operationNetwork.setNetwork_mop_start(request.getNetwork_mop_start());
                operationNetwork.setNetwork_mop_deadline(request.getNetwork_mop_deadline());
                operationNetwork.setNetwork_mop_done(request.getNetwork_mop_done());
                operationNetwork.setNetwork_demomop_start(request.getNetwork_demomop_start());
                operationNetwork.setNetwork_demomop_deadline(request.getNetwork_demomop_deadline());
                operationNetwork.setNetwork_demomop_done(request.getNetwork_demomop_done());
                operationNetwork.setNetwork_implementasi_start(request.getNetwork_implementasi_start());
                operationNetwork.setNetwork_implementasi_deadline(request.getNetwork_implementasi_deadline());
                operationNetwork.setNetwork_implementasi_done(request.getNetwork_implementasi_done());
                operationNetwork.setNetwork_skse_start(request.getNetwork_skse_start());
                operationNetwork.setNetwork_skse_deadline(request.getNetwork_skse_deadline());
                operationNetwork.setNetwork_skse_done(request.getNetwork_skse_done());
                operationNetwork.setNetwork_uat_start(request.getNetwork_uat_start());
                operationNetwork.setNetwork_uat_deadline(request.getNetwork_uat_deadline());
                operationNetwork.setNetwork_uat_done(request.getNetwork_uat_done());
                operationNetwork.setNetwork_status(request.getNetwork_status());
                operationNetwork.setNetwork_deadline_project(request.getNetwork_deadline_project());
                operationNetwork.setNetwork_project_done(request.getNetwork_project_done());


        OperationNetworkRepository.save(operationNetwork);

        return OperationNetworkResponse.builder()
        .network_perihal(operationNetwork.getNetwork_perihal())
        .network_pic(operationNetwork.getNetwork_pic())
        .departement(operationNetwork.getDepartement())
        .network_kickoff_start(operationNetwork.getNetwork_kickoff_start())
        .network_kickoff_deadline(operationNetwork.getNetwork_kickoff_deadline())
        .network_kickoff_done(operationNetwork.getNetwork_kickoff_done())
        .network_mop_start(operationNetwork.getNetwork_mop_start())
        .network_mop_deadline(operationNetwork.getNetwork_mop_deadline())
        .network_mop_done(operationNetwork.getNetwork_mop_done())
        .network_demomop_start(operationNetwork.getNetwork_demomop_start())
        .network_demomop_deadline(operationNetwork.getNetwork_demomop_deadline())
        .network_demomop_done(operationNetwork.getNetwork_demomop_done())
        .network_implementasi_start(operationNetwork.getNetwork_implementasi_start())
        .network_implementasi_deadline(operationNetwork.getNetwork_implementasi_deadline())
        .network_implementasi_done(operationNetwork.getNetwork_implementasi_done())
        .network_skse_start(operationNetwork.getNetwork_skse_start())
        .network_skse_deadline(operationNetwork.getNetwork_skse_deadline())
        .network_skse_done(operationNetwork.getNetwork_skse_done())
        .network_uat_start(operationNetwork.getNetwork_uat_start())
        .network_uat_deadline(operationNetwork.getNetwork_uat_deadline())
        .network_uat_done(operationNetwork.getNetwork_uat_done())
        .network_status(operationNetwork.getNetwork_status())
        .network_deadline_project(operationNetwork.getNetwork_deadline_project())
        .network_project_done(operationNetwork.getNetwork_project_done())
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
            item.getNetwork_kickoff_deadline(),
            item.getNetwork_kickoff_done(),
            item.getNetwork_mop_start(),
            item.getNetwork_mop_deadline(),
            item.getNetwork_mop_done(),
            item.getNetwork_demomop_start(),
            item.getNetwork_demomop_deadline(),
            item.getNetwork_demomop_done(),
            item.getNetwork_implementasi_start(),
            item.getNetwork_implementasi_deadline(),
            item.getNetwork_implementasi_done(),
            item.getNetwork_skse_start(),
            item.getNetwork_skse_deadline(),
            item.getNetwork_skse_done(),
            item.getNetwork_uat_start(),
            item.getNetwork_uat_deadline(),
            item.getNetwork_uat_done(),
            item.getNetwork_status(),
            item.getNetwork_deadline_project(),
            item.getNetwork_project_done(),
            operationNetworkShowAll.size()
        ))
    .collect(Collectors.toList());

        return response;
    }

   
}
