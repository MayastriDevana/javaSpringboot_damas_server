package com.damas.service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.model.OperationNetwork;
import com.damas.model.User;
import com.damas.payload.OperationNetworkRequest;
import com.damas.payload.OperationNetworkResponse;
import com.damas.repository.OperationNetworkRepository;
import com.damas.repository.UserRepository;

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
    public OperationNetworkResponse newNetwork(OperationNetworkRequest request, String token) {
        validationService.validateRequest(request);

        User user = userRepository.findFirstByToken(token)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has not login"));

        if (!user.getStatus().equals(env.getProperty("STATUS_GET_ACTIVE"))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This account is inActive");
        }

        OperationNetwork operationNetwork = new OperationNetwork();
        operationNetwork.setNetwork_perihal(request.getNetwork_perihal());
        operationNetwork.setNetwork_pic(request.getNetwork_pic());
        operationNetwork.setNetwork_deadline(request.getNetwork_deadline());
        operationNetwork.setNetwork_status(request.getNetwork_status());

        OperationNetworkRepository.save(operationNetwork);

        return OperationNetworkResponse.builder()
        .network_perihal(operationNetwork.getNetwork_perihal())
        .network_pic(operationNetwork.getNetwork_pic())
        .network_deadline(operationNetwork.getNetwork_deadline())
        .network_status(operationNetwork.getNetwork_status())
        .build();

    }

    public List<OperationNetworkResponse> findAll(String token, Long start, Long size) {
        validationService.validateRequest(token);

        User user = userRepository.findFirstByToken(token)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has not login"));

        if (user.getTokenExpiredAt() < Instant.now().toEpochMilli()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has logout by system");
        }

        if (!user.getStatus().equals(env.getProperty("STATUS_GET_ACTIVE"))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This account is inActive");
        }

        List<OperationNetwork> operationNetworkShowAll = OperationNetworkRepository.findAll();

        List<OperationNetworkResponse> response = operationNetworkShowAll.stream()
        .skip(start).limit(size)
        .map(item -> new OperationNetworkResponse(
            item.getNetwork_id(),
            item.getNetwork_perihal(),
            item.getNetwork_pic(),
            item.getNetwork_deadline(),
            item.getNetwork_status(),
            operationNetworkShowAll.size()
        ))
    .collect(Collectors.toList());

        return response;
    }

    public List<OperationNetworkResponse> findNetwork(String token, String input){

        validationService.validateRequest(token);

        if (input == "" || input == null || Objects.isNull(input) || input.equals("")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid request");
        }

        User user = userRepository.findFirstByToken(token)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has not login"));

        if (user.getTokenExpiredAt() < Instant.now().toEpochMilli()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has logout by system");
        }

        if (!user.getStatus().equals(env.getProperty("STATUS_GET_ACTIVE"))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This account is inActive");
        }
        List<OperationNetwork> networkByName = OperationNetworkRepository.searchByNetwork_perihalorNetwork_pic(input);

        List<OperationNetworkResponse> response = networkByName.stream()
        .map(item -> new OperationNetworkResponse(
            item.getNetwork_id(),
            item.getNetwork_perihal(),
            item.getNetwork_pic(),
            item.getNetwork_deadline(),
            item.getNetwork_status(),
            networkByName.size()))
            .collect((Collectors.toList()));

        return response;
    }

    @Transactional
    public OperationNetworkResponse editedNetwork(String token, OperationNetworkRequest request, String input) {

        validationService.validateRequest(request);

        User user = userRepository.findFirstByToken(token)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has not login"));

        if (!user.getStatus().equals(env.getProperty("STATUS_GET_ACTIVE"))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This account is inActive");
        }

        OperationNetwork operationNetwork = OperationNetworkRepository.findById(input)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Network not found"));

        operationNetwork.setNetwork_perihal(request.getNetwork_perihal());
        operationNetwork.setNetwork_pic(request.getNetwork_pic());
        operationNetwork.setNetwork_deadline(request.getNetwork_deadline());
        operationNetwork.setNetwork_status(request.getNetwork_status());

        OperationNetworkRepository.save(operationNetwork);

        return OperationNetworkResponse.builder()
                .network_perihal(operationNetwork.getNetwork_perihal())
                .network_pic(operationNetwork.getNetwork_pic())
                .network_deadline(operationNetwork.getNetwork_deadline())
                .network_status(operationNetwork.getNetwork_status())
                .build();
    }
}
