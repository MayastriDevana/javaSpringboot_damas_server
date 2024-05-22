package com.damas.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.model.LogisticMemo;
import com.damas.model.User;
import com.damas.payload.LogisticMemoRequest;
import com.damas.payload.LogisticMemoResponse;
import com.damas.repository.LogisticMemoRepository;
import com.damas.repository.UserRepository;

import jakarta.transaction.Transactional;
@Service
public class LogisticMemoService {

    @Autowired 
    private LogisticMemoRepository LogisticMemoRepository;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private Environment env;

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public LogisticMemoResponse newMemo(LogisticMemoRequest request, String token) {
        validationService.validateRequest(request);

        User user = userRepository.findFirstByToken(token)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user has not login"));

        if (!user.getStatus().equals(env.getProperty("STATUS_GET_ACTIVE"))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This account is inActive");
        }

        LogisticMemo logisticMemo = new LogisticMemo();
        logisticMemo.setMemo_num(request.getMemo_num());
        logisticMemo.setMemo_perihal(request.getMemo_perihal());
        logisticMemo.setMemo_pic(request.getMemo_pic());
        logisticMemo.setMemo_deadline(request.getMemo_deadline());
        logisticMemo.setMemo_status(request.getMemo_status());

        LogisticMemoRepository.save(logisticMemo);

        return LogisticMemoResponse.builder()
        .memo_num(logisticMemo.getMemo_num())
        .memo_perihal(logisticMemo.getMemo_perihal())
        .memo_pic(logisticMemo.getMemo_pic())
        .memo_status(logisticMemo.getMemo_status())
        .memo_deadline(logisticMemo.getMemo_deadline())
        .build();
    }
}
