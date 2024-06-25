package com.damas.dbdamas.service;

import java.io.IOException;
import java.sql.Date;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.LogisticMemo;
import com.damas.dbdamas.payload.LogisticMemoRequest;
import com.damas.dbdamas.payload.LogisticMemoResponse;
import com.damas.dbdamas.repository.LogisticMemoRepository;

@Service
public class LogisticMemoService {

        @Autowired
        private LogisticMemoRepository logisticMemoRepository;

        @Autowired
        private ValidationService validationService;

        @Transactional
        public LogisticMemoResponse newMemo(LogisticMemoRequest request, String userid) throws IOException {
                validationService.validateUsers(userid);

                if (!(validationService.isOperator(userid) || validationService.isLogisticOperator(userid))) {
                        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
                }

                LogisticMemo logisticMemo = new LogisticMemo();
                logisticMemo.setMemo_num(request.getMemo_num());
                logisticMemo.setMemo_perihal(request.getMemo_perihal());
                logisticMemo.setMemo_pic(request.getMemo_pic());
                logisticMemo.setMemo_department(request.getMemo_department());
                logisticMemo.setMemo_createdBy(request.getMemo_createdBy());
                logisticMemo.setMemo_reviewer(request.getMemo_reviewer());
                logisticMemo.setMemo_status(request.getMemo_status());
                logisticMemo.setMemo_deadline(request.getMemo_deadline());
                logisticMemo.setMemo_notes(request.getMemo_notes());

                if (request.getMemo_upload() != null) {
                        logisticMemo.setMemo_upload(
                                        Base64.getEncoder().encodeToString(request.getMemo_upload().getBytes()));
                }

                logisticMemoRepository.save(logisticMemo);

                return LogisticMemoResponse.builder()
                                .memo_id(logisticMemo.getMemo_id())
                                .memo_num(logisticMemo.getMemo_num())
                                .memo_perihal(logisticMemo.getMemo_perihal())
                                .memo_pic(logisticMemo.getMemo_pic())
                                .memo_department(logisticMemo.getMemo_department())
                                .memo_createdBy(logisticMemo.getMemo_createdBy())
                                .memo_reviewer(logisticMemo.getMemo_reviewer())
                                .memo_status(logisticMemo.getMemo_status())
                                .memo_deadline(new Date(logisticMemo.getMemo_deadline().getTime()))
                                .memo_notes(logisticMemo.getMemo_notes())
                                .memo_upload(logisticMemo.getMemo_upload())
                                .build();
        }

        @Transactional
        public LogisticMemoResponse editMemo(String memoId, LogisticMemoRequest request, String userid)
                        throws IOException {
                validationService.validateRequest(request);

                if (!(validationService.isOperator(userid) || validationService.isLogisticOperator(userid))) {
                        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
                }

                LogisticMemo logisticMemo = logisticMemoRepository.findById(memoId)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Memo not found"));

                logisticMemo.setMemo_num(request.getMemo_num());
                logisticMemo.setMemo_perihal(request.getMemo_perihal());
                logisticMemo.setMemo_pic(request.getMemo_pic());
                logisticMemo.setMemo_department(request.getMemo_department());
                logisticMemo.setMemo_createdBy(request.getMemo_createdBy());
                logisticMemo.setMemo_reviewer(request.getMemo_reviewer());
                logisticMemo.setMemo_status(request.getMemo_status());
                logisticMemo.setMemo_deadline(request.getMemo_deadline());
                logisticMemo.setMemo_notes(request.getMemo_notes());

                if (request.getMemo_upload() != null) {
                        logisticMemo.setMemo_upload(
                                        Base64.getEncoder().encodeToString(request.getMemo_upload().getBytes()));
                }

                logisticMemoRepository.save(logisticMemo);

                return LogisticMemoResponse.builder()
                                .memo_id(logisticMemo.getMemo_id())
                                .memo_num(logisticMemo.getMemo_num())
                                .memo_perihal(logisticMemo.getMemo_perihal())
                                .memo_pic(logisticMemo.getMemo_pic())
                                .memo_department(logisticMemo.getMemo_department())
                                .memo_createdBy(logisticMemo.getMemo_createdBy())
                                .memo_reviewer(logisticMemo.getMemo_reviewer())
                                .memo_status(logisticMemo.getMemo_status())
                                .memo_deadline(new Date(logisticMemo.getMemo_deadline().getTime()))
                                .memo_notes(logisticMemo.getMemo_notes())
                                .memo_upload(logisticMemo.getMemo_upload())
                                .build();
        }

        @Transactional
        public List<LogisticMemoResponse> findAll(String userid, Long start, Long size) {
                validationService.validateRequest(userid);

                if (!(validationService.isOperator(userid) || validationService.isLogisticOperator(userid)
                                || validationService.isLogisticSupervisor(userid)
                                || validationService.isSupervisor(userid)
                                || validationService.isReviewerSupervisor(userid))) {
                        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user not allowed");
                }

                List<LogisticMemo> logisticMemos = logisticMemoRepository.findAll();

                return logisticMemos.stream()
                                .skip(start).limit(size)
                                .map(item -> LogisticMemoResponse.builder()
                                                .memo_id(item.getMemo_id())
                                                .memo_num(item.getMemo_num())
                                                .memo_perihal(item.getMemo_perihal())
                                                .memo_pic(item.getMemo_pic())
                                                .memo_status(item.getMemo_status())
                                                .memo_department(item.getMemo_department())
                                                .memo_createdBy(item.getMemo_createdBy())
                                                .memo_reviewer(item.getMemo_reviewer())
                                                .memo_deadline(new Date(item.getMemo_deadline().getTime()))
                                                .memo_notes(item.getMemo_notes())
                                                .memo_upload(item.getMemo_upload())
                                                .build())
                                .collect(Collectors.toList());
        }

        public LogisticMemoResponse getMemoById(String memoId) {
                LogisticMemo logisticMemo = logisticMemoRepository.findById(memoId)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Memo not found"));

                return LogisticMemoResponse.builder()
                                .memo_id(logisticMemo.getMemo_id())
                                .memo_num(logisticMemo.getMemo_num())
                                .memo_perihal(logisticMemo.getMemo_perihal())
                                .memo_pic(logisticMemo.getMemo_pic())
                                .memo_department(logisticMemo.getMemo_department())
                                .memo_createdBy(logisticMemo.getMemo_createdBy())
                                .memo_reviewer(logisticMemo.getMemo_reviewer())
                                .memo_status(logisticMemo.getMemo_status())
                                .memo_deadline(new Date(logisticMemo.getMemo_deadline().getTime()))
                                .memo_notes(logisticMemo.getMemo_notes())
                                .memo_upload(logisticMemo.getMemo_upload())
                                .build();
        }

        public List<LogisticMemoResponse> findMemo(String userId, String input) {
                validationService.validateRequest(userId);

                List<LogisticMemo> memoByPerihal = logisticMemoRepository.searchByPerihalorPic(input);

                return memoByPerihal.stream()
                                .map(item -> LogisticMemoResponse.builder()
                                                .memo_id(item.getMemo_id())
                                                .memo_num(item.getMemo_num())
                                                .memo_perihal(item.getMemo_perihal())
                                                .memo_pic(item.getMemo_pic())
                                                .memo_status(item.getMemo_status())
                                                .memo_department(item.getMemo_department())
                                                .memo_createdBy(item.getMemo_createdBy())
                                                .memo_reviewer(item.getMemo_reviewer())
                                                .memo_deadline(new Date(item.getMemo_deadline().getTime()))
                                                .memo_notes(item.getMemo_notes())
                                                .memo_upload(item.getMemo_upload())
                                                .build())
                                .collect(Collectors.toList());
        }

        public LogisticMemoResponse uploadMemoFile(String memoId, MultipartFile file) throws IOException {
                LogisticMemo logisticMemo = logisticMemoRepository.findById(memoId)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Memo not found"));

                logisticMemo.setMemo_upload(Base64.getEncoder().encodeToString(file.getBytes()));

                logisticMemoRepository.save(logisticMemo);

                return LogisticMemoResponse.builder()
                                .memo_id(logisticMemo.getMemo_id())
                                .memo_num(logisticMemo.getMemo_num())
                                .memo_perihal(logisticMemo.getMemo_perihal())
                                .memo_pic(logisticMemo.getMemo_pic())
                                .memo_department(logisticMemo.getMemo_department())
                                .memo_createdBy(logisticMemo.getMemo_createdBy())
                                .memo_reviewer(logisticMemo.getMemo_reviewer())
                                .memo_status(logisticMemo.getMemo_status())
                                .memo_deadline(new Date(logisticMemo.getMemo_deadline().getTime()))
                                .memo_notes(logisticMemo.getMemo_notes())
                                .memo_upload(logisticMemo.getMemo_upload())
                                .build();
        }

        @Transactional
        public LogisticMemoResponse updateMemoWithFile(String memoId, String fileName) {
                LogisticMemo logisticMemo = logisticMemoRepository.findById(memoId)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Memo not found"));

                logisticMemo.setMemo_upload(fileName);
                logisticMemoRepository.save(logisticMemo);

                return LogisticMemoResponse.builder()
                                .memo_id(logisticMemo.getMemo_id())
                                .memo_num(logisticMemo.getMemo_num())
                                .memo_perihal(logisticMemo.getMemo_perihal())
                                .memo_pic(logisticMemo.getMemo_pic())
                                .memo_department(logisticMemo.getMemo_department())
                                .memo_createdBy(logisticMemo.getMemo_createdBy())
                                .memo_reviewer(logisticMemo.getMemo_reviewer())
                                .memo_status(logisticMemo.getMemo_status())
                                .memo_deadline(new Date(logisticMemo.getMemo_deadline().getTime()))
                                .memo_notes(logisticMemo.getMemo_notes())
                                .memo_upload(logisticMemo.getMemo_upload())
                                .build();
        }

        public byte[] downloadMemoFile(String memoId) {
                LogisticMemo logisticMemo = logisticMemoRepository.findById(memoId)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Memo not found"));

                return Base64.getDecoder().decode(logisticMemo.getMemo_upload());
        }
}
