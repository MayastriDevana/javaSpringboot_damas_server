package com.damas.dbdamas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.OperationServer;
import com.damas.dbdamas.payload.OperationServerRequest;
import com.damas.dbdamas.payload.OperationServerResponse;
import com.damas.dbdamas.repository.OperationServerRepository;

import jakarta.transaction.Transactional;

@Service
public class OperationServerService {
    
    @Autowired
    private OperationServerRepository OperationServerRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public OperationServerResponse newServer(OperationServerRequest request, String userid) {
        validationService.validateRequest(userid);

        if (!(validationService.isOperator(userid) || validationService.isServerOperator(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }
        
        OperationServer operationServer = new OperationServer();
        operationServer.setServer_perihal(request.getServer_perihal());
        operationServer.setServer_pic(request.getServer_pic());
        operationServer.setDepartement(request.getDepartement());
        operationServer.setServer_kickoff_start(request.getServer_kickoff_start());
        operationServer.setServer_kickoff_deadline(request.getServer_kickoff_deadline());
        operationServer.setServer_kickoff_done(request.getServer_kickoff_done());
        operationServer.setServer_peyiapanserver_start(request.getServer_peyiapanserver_start());
        operationServer.setServer_peyiapanserver_deadline(request.getServer_peyiapanserver_deadline());
        operationServer.setServer_peyiapanserver_done(request.getServer_peyiapanserver_done());
        operationServer.setServer_instalasiaplikasi_start(request.getServer_instalasiaplikasi_start());
        operationServer.setServer_instalasiaplikasi_deadline(request.getServer_instalasiaplikasi_deadline());
        operationServer.setServer_instalasiaplikasi_done(request.getServer_instalasiaplikasi_done());
        operationServer.setServer_instalcheckpoint_start(request.getServer_instalcheckpoint_start());
        operationServer.setServer_instalcheckpoint_deadline(request.getServer_instalcheckpoint_deadline());
        operationServer.setServer_instalcheckpoint_done(request.getServer_instalcheckpoint_done());
        operationServer.setServer_testingkoneksi_start(request.getServer_testingkoneksi_start());
        operationServer.setServer_testingkoneksi_deadline(request.getServer_testingkoneksi_deadline());
        operationServer.setServer_testingkoneksi_done(request.getServer_testingkoneksi_done());
        operationServer.setServer_serahterimaserver_start(request.getServer_serahterimaserver_start());
        operationServer.setServer_serahterimaserver_deadline(request.getServer_serahterimaserver_deadline());
        operationServer.setServer_serahterimaserver_done(request.getServer_serahterimaserver_done());
        operationServer.setServer_implementasi_start(request.getServer_implementasi_start());
        operationServer.setServer_implementasi_deadline(request.getServer_implementasi_deadline());
        operationServer.setServer_implementasi_done(request.getServer_implementasi_done());
        operationServer.setServer_status(request.getServer_status());
        operationServer.setServer_deadline_project(request.getServer_deadline_project());
        operationServer.setServer_project_done(request.getServer_project_done());


        OperationServerRepository.save(operationServer);

        return OperationServerResponse.builder()
        .server_perihal(operationServer.getServer_perihal())
        .server_pic(operationServer.getServer_pic())
        .departement(operationServer.getDepartement())
        
        .server_kickoff_start(operationServer.getServer_kickoff_start())
        .server_kickoff_deadline(operationServer.getServer_kickoff_deadline())
        .server_kickoff_done(operationServer.getServer_kickoff_done())

        .server_peyiapanserver_start(operationServer.getServer_peyiapanserver_start())
        .server_peyiapanserver_deadline(operationServer.getServer_peyiapanserver_deadline())
        .server_peyiapanserver_done(operationServer.getServer_peyiapanserver_done())

        .server_instalasiaplikasi_start(operationServer.getServer_instalasiaplikasi_start())
        .server_instalasiaplikasi_deadline(operationServer.getServer_instalasiaplikasi_deadline())
        .server_instalasiaplikasi_done(operationServer.getServer_instalasiaplikasi_done())

        .server_instalcheckpoint_start(operationServer.getServer_instalcheckpoint_start())
        .server_instalcheckpoint_deadline(operationServer.getServer_instalcheckpoint_deadline())
        .server_instalcheckpoint_done(operationServer.getServer_instalcheckpoint_done())

        .server_testingkoneksi_start(operationServer.getServer_testingkoneksi_start())
        .server_testingkoneksi_deadline(operationServer.getServer_testingkoneksi_deadline())
        .server_testingkoneksi_done(operationServer.getServer_testingkoneksi_done())

        .server_serahterimaserver_start(operationServer.getServer_serahterimaserver_start())
        .server_serahterimaserver_deadline(operationServer.getServer_serahterimaserver_deadline())
        .server_serahterimaserver_done(operationServer.getServer_serahterimaserver_done())

        .server_implementasi_start(operationServer.getServer_implementasi_start())
        .server_implementasi_deadline(operationServer.getServer_implementasi_deadline())
        .server_implementasi_done(operationServer.getServer_implementasi_done())

        .server_status(operationServer.getServer_status())
        .server_deadline_project(operationServer.getServer_deadline_project())
        .server_project_done(operationServer.getServer_project_done())
        .build();
        
    }

    @Transactional
    public List<OperationServerResponse> findServer(String userid, String input){

        validationService.validateRequest(userid);

        List<OperationServer> serverByName = OperationServerRepository.searchByServer_perihalorServer_pic(input);

        List<OperationServerResponse> response = serverByName.stream()
        .map(item -> new OperationServerResponse(
            item.getServer_id(),
            item.getServer_perihal(),
            item.getServer_pic(),
            item.getDepartement(),
            item.getServer_kickoff_deadline(),
            item.getServer_kickoff_done(),
            item.getServer_kickoff_start(),
            item.getServer_peyiapanserver_start(),
            item.getServer_peyiapanserver_deadline(),
            item.getServer_peyiapanserver_done(),
            item.getServer_instalasiaplikasi_start(),
            item.getServer_instalasiaplikasi_deadline(),
            item.getServer_instalasiaplikasi_done(),
            item.getServer_instalcheckpoint_start(),
            item.getServer_instalcheckpoint_deadline(),
            item.getServer_instalcheckpoint_done(),
            item.getServer_testingkoneksi_start(),
            item.getServer_testingkoneksi_deadline(),
            item.getServer_testingkoneksi_done(),
            item.getServer_serahterimaserver_start(),
            item.getServer_serahterimaserver_deadline(),
            item.getServer_serahterimaserver_done(),
            item.getServer_implementasi_start(),
            item.getServer_implementasi_deadline(),
            item.getServer_implementasi_done(),
            item.getServer_status(),
            item.getServer_deadline_project(),
            item.getServer_project_done(),
            serverByName.size()))
            .collect((Collectors.toList()));

            return response;
        
    }

    @Transactional
    public OperationServerResponse editedServer(String userid, OperationServerRequest request, String input) {

        validationService.validateRequest(userid);

        if (!(validationService.isOperator(userid) || validationService.isServerOperator(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }


        OperationServer operationServer = OperationServerRepository.findById(input)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Server not found"));

            operationServer.setServer_perihal(request.getServer_perihal());
            operationServer.setServer_pic(request.getServer_pic());
            operationServer.setDepartement(request.getDepartement());
            operationServer.setServer_kickoff_start(request.getServer_kickoff_start());
            operationServer.setServer_kickoff_deadline(request.getServer_kickoff_deadline());
            operationServer.setServer_kickoff_done(request.getServer_kickoff_done());
            operationServer.setServer_peyiapanserver_start(request.getServer_peyiapanserver_start());
            operationServer.setServer_peyiapanserver_deadline(request.getServer_peyiapanserver_deadline());
            operationServer.setServer_peyiapanserver_done(request.getServer_peyiapanserver_done());
            operationServer.setServer_instalasiaplikasi_start(request.getServer_instalasiaplikasi_start());
            operationServer.setServer_instalasiaplikasi_deadline(request.getServer_instalasiaplikasi_deadline());
            operationServer.setServer_instalasiaplikasi_done(request.getServer_instalasiaplikasi_done());
            operationServer.setServer_instalcheckpoint_start(request.getServer_instalcheckpoint_start());
            operationServer.setServer_instalcheckpoint_deadline(request.getServer_instalcheckpoint_deadline());
            operationServer.setServer_instalcheckpoint_done(request.getServer_instalcheckpoint_done());
            operationServer.setServer_testingkoneksi_start(request.getServer_testingkoneksi_start());
            operationServer.setServer_testingkoneksi_deadline(request.getServer_testingkoneksi_deadline());
            operationServer.setServer_testingkoneksi_done(request.getServer_testingkoneksi_done());
            operationServer.setServer_serahterimaserver_start(request.getServer_serahterimaserver_start());
            operationServer.setServer_serahterimaserver_deadline(request.getServer_serahterimaserver_deadline());
            operationServer.setServer_serahterimaserver_done(request.getServer_serahterimaserver_done());
            operationServer.setServer_implementasi_start(request.getServer_implementasi_start());
            operationServer.setServer_implementasi_deadline(request.getServer_implementasi_deadline());
            operationServer.setServer_implementasi_done(request.getServer_implementasi_done());
            operationServer.setServer_status(request.getServer_status());
            operationServer.setServer_deadline_project(request.getServer_deadline_project());
            operationServer.setServer_project_done(request.getServer_project_done());

    OperationServerRepository.save(operationServer);

        return OperationServerResponse.builder()
        .server_perihal(operationServer.getServer_perihal())
            .server_pic(operationServer.getServer_pic())
            .departement(operationServer.getDepartement())
            
            .server_kickoff_start(operationServer.getServer_kickoff_start())
            .server_kickoff_deadline(operationServer.getServer_kickoff_deadline())
            .server_kickoff_done(operationServer.getServer_kickoff_done())

            .server_peyiapanserver_start(operationServer.getServer_peyiapanserver_start())
            .server_peyiapanserver_deadline(operationServer.getServer_peyiapanserver_deadline())
            .server_peyiapanserver_done(operationServer.getServer_peyiapanserver_done())

            .server_instalasiaplikasi_start(operationServer.getServer_instalasiaplikasi_start())
            .server_instalasiaplikasi_deadline(operationServer.getServer_instalasiaplikasi_deadline())
            .server_instalasiaplikasi_done(operationServer.getServer_instalasiaplikasi_done())

            .server_instalcheckpoint_start(operationServer.getServer_instalcheckpoint_start())
            .server_instalcheckpoint_deadline(operationServer.getServer_instalcheckpoint_deadline())
            .server_instalcheckpoint_done(operationServer.getServer_instalcheckpoint_done())

            .server_testingkoneksi_start(operationServer.getServer_testingkoneksi_start())
            .server_testingkoneksi_deadline(operationServer.getServer_testingkoneksi_deadline())
            .server_testingkoneksi_done(operationServer.getServer_testingkoneksi_done())

            .server_serahterimaserver_start(operationServer.getServer_serahterimaserver_start())
            .server_serahterimaserver_deadline(operationServer.getServer_serahterimaserver_deadline())
            .server_serahterimaserver_done(operationServer.getServer_serahterimaserver_done())

            .server_implementasi_start(operationServer.getServer_implementasi_start())
            .server_implementasi_deadline(operationServer.getServer_implementasi_deadline())
            .server_implementasi_done(operationServer.getServer_implementasi_done())

            .server_status(operationServer.getServer_status())
            .server_deadline_project(operationServer.getServer_deadline_project())
            .server_project_done(operationServer.getServer_project_done())
            .build();
    }

    @Transactional
    public List<OperationServerResponse> findAll(String userid, Long start, Long size) {

        validationService.validateRequest(userid);

        if (!(validationService.isOperator(userid) || validationService.isDacenOperator(userid)
                || validationService.isOperationSupervisor(userid)
                || validationService.isSupervisor(userid))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
        }

        List<OperationServer> operationServerShowAll = OperationServerRepository.findAll();

        List<OperationServerResponse> response = operationServerShowAll.stream()
        .skip(start).limit(size)
        .map(item -> new OperationServerResponse(
            item.getServer_id(),
            item.getServer_perihal(),
            item.getServer_pic(),
            item.getDepartement(),
            item.getServer_kickoff_deadline(),
            item.getServer_kickoff_done(),
            item.getServer_kickoff_start(),
            item.getServer_peyiapanserver_start(),
            item.getServer_peyiapanserver_deadline(),
            item.getServer_peyiapanserver_done(),
            item.getServer_instalasiaplikasi_start(),
            item.getServer_instalasiaplikasi_deadline(),
            item.getServer_instalasiaplikasi_done(),
            item.getServer_instalcheckpoint_start(),
            item.getServer_instalcheckpoint_deadline(),
            item.getServer_instalcheckpoint_done(),
            item.getServer_testingkoneksi_start(),
            item.getServer_testingkoneksi_deadline(),
            item.getServer_testingkoneksi_done(),
            item.getServer_serahterimaserver_start(),
            item.getServer_serahterimaserver_deadline(),
            item.getServer_serahterimaserver_done(),
            item.getServer_implementasi_start(),
            item.getServer_implementasi_deadline(),
            item.getServer_implementasi_done(),
            item.getServer_status(),
            item.getServer_deadline_project(),
            item.getServer_project_done(),
            operationServerShowAll.size()))
            .collect(Collectors.toList());

        return response;
    }
}
