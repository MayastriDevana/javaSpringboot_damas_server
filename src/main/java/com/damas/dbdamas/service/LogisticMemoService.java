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

import com.damas.dbdamas.model.LogisticMemo;
import com.damas.dbdamas.payload.LogisticMemoRequest;
import com.damas.dbdamas.payload.LogisticMemoResponse;
import com.damas.dbdamas.repository.LogisticMemoRepository;
import com.damas.dbdamas.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class LogisticMemoService {

    @Autowired 
    private LogisticMemoRepository logisticMemoRepository;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private Environment env;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public LogisticMemoResponse newMemo(LogisticMemoRequest request, String userId) {
        validationService.validateRequest(request);

        LogisticMemo logisticMemo = new LogisticMemo();
        logisticMemo.setMemo_num(request.getMemo_num());
        logisticMemo.setMemo_perihal(request.getMemo_perihal());
        logisticMemo.setMemo_pic(request.getMemo_pic());
        logisticMemo.setMemo_status(request.getMemo_status());
        logisticMemo.setMemo_status(request.getMemo_status());
        logisticMemo.setMemo_deadline(request.getMemo_deadline());

        logisticMemoRepository.save(logisticMemo);

        return LogisticMemoResponse.builder()
            .memo_num(logisticMemo.getMemo_num())
            .memo_perihal(logisticMemo.getMemo_perihal())
            .memo_pic(logisticMemo.getMemo_pic())
            .memo_status(logisticMemo.getMemo_status())
            .memo_deadline(logisticMemo.getMemo_deadline())
            .build();
    }

    @Transactional
    public LogisticMemoResponse editMemo(String memoId, LogisticMemoRequest request, String userId) {
        validationService.validateRequest(request);

        LogisticMemo logisticMemo = logisticMemoRepository.findById(memoId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Memo not found"));

        logisticMemo.setMemo_num(request.getMemo_num());
        logisticMemo.setMemo_perihal(request.getMemo_perihal());
        logisticMemo.setMemo_pic(request.getMemo_pic());
        logisticMemo.setMemo_status(request.getMemo_status());
        logisticMemo.setMemo_status(request.getMemo_status());
        logisticMemo.setMemo_deadline(request.getMemo_deadline());

        logisticMemoRepository.save(logisticMemo);

        return LogisticMemoResponse.builder()
            .memo_num(logisticMemo.getMemo_num())
            .memo_perihal(logisticMemo.getMemo_perihal())
            .memo_pic(logisticMemo.getMemo_pic())
            .memo_status(logisticMemo.getMemo_status())
            .memo_deadline(logisticMemo.getMemo_deadline())
            .build();
    }

    public List<LogisticMemoResponse> findAll(String userId, Long start, Long size) {
        validationService.validateRequest(userId);

        List<LogisticMemo> logisticMemos = logisticMemoRepository.findAll();

        return logisticMemos.stream()
            .skip(start).limit(size)
            .map(item -> new LogisticMemoResponse(
                item.getMemo_id(),
                item.getMemo_num(),
                item.getMemo_perihal(),
                item.getMemo_pic(),
                item.getMemo_status(),
                item.getMemo_deadline(),
                logisticMemos.size()
            ))
            .collect(Collectors.toList());
    }

    public LogisticMemoResponse getMemoById(String memoId) {
        LogisticMemo logisticMemo = logisticMemoRepository.findById(memoId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Memo not found"));

        return LogisticMemoResponse.builder()
            .memo_num(logisticMemo.getMemo_num())
            .memo_perihal(logisticMemo.getMemo_perihal())
            .memo_pic(logisticMemo.getMemo_pic())
            .memo_status(logisticMemo.getMemo_status())
            .memo_deadline(logisticMemo.getMemo_deadline())
            .build();
    }

    public List<LogisticMemoResponse> findMemo(String userId, String input) {
        validationService.validateRequest(userId);

        List<LogisticMemo> memoByPerihal = logisticMemoRepository.searchByPerihalorPic(input);

        return memoByPerihal.stream()
            .map(item -> new LogisticMemoResponse(
                item.getMemo_id(),
                item.getMemo_num(),
                item.getMemo_perihal(),
                item.getMemo_pic(),
                item.getMemo_status(),
                item.getMemo_deadline(),
                memoByPerihal.size()
            ))
            .collect(Collectors.toList());
    }
}
