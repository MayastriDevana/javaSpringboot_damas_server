package com.damas.dbdamas.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.Skse;
import com.damas.dbdamas.model.User;
import com.damas.dbdamas.payload.SkseRequest;
import com.damas.dbdamas.payload.SkseResponse;
import com.damas.dbdamas.repository.SkseRepository;
import com.damas.dbdamas.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class SkseService {

    @Autowired
    private SkseRepository skseRepository;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private Environment env;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public SkseResponse newSkse(SkseRequest request, String token) {
        validationService.validateRequest(request);

        User user = userRepository.findFirstByToken(token)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has not login"));

        if (!user.getStatus().equals(env.getProperty("STATUS_GET_ACTIVE"))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This account is inActive");
        }

        Skse skse = new Skse();
        skse.setNosurat(request.getNosurat());
        skse.setPerihal(request.getPerihal());
        skse.setPic(request.getPic());
        skse.setDeadline(request.getDeadline());
        skse.setStatus(request.getStatus());

        skseRepository.save(skse);

        return SkseResponse.builder().nosurat(skse.getNosurat()).perihal(skse.getPerihal()).pic(skse.getPic())
                .deadline(skse.getDeadline()).status(skse.getStatus()).build();
    }

    @Transactional
    public List<SkseResponse> findAll(String token, Long start, Long size) {
        validationService.validateRequest(token);

        User user = userRepository.findFirstByToken(token)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has not login"));

        if (user.getTokenExpiredAt() < Instant.now().toEpochMilli()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has logout by system");
        }

        if (!user.getStatus().equals(env.getProperty("STATUS_GET_ACTIVE"))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This account is inActive");
        }

        List<Skse> skseAll = skseRepository.findAll();

        List<SkseResponse> response = skseAll.stream()
                .skip(start).limit(size)
                .map(item -> new SkseResponse(
                        item.getNosurat(),
                        item.getPerihal(),
                        item.getPic(),
                        item.getDeadline(),
                        item.getStatus(),
                        skseAll.size()))
                .collect(Collectors.toList());

        return response;

    }

    

}
