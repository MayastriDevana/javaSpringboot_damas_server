package com.damas.dbdamas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.damas.dbdamas.payload.LogisticMemoRequest;
import com.damas.dbdamas.payload.LogisticMemoResponse;
import com.damas.dbdamas.payload.ProjectDevResponse;
import com.damas.dbdamas.payload.WebResponse;
import com.damas.dbdamas.service.LogisticMemoService;
import com.damas.dbdamas.service.FileStorageService;

import java.io.IOException;
import java.util.List;

@RestController
public class LogisticMemoController {

    @Autowired
    private LogisticMemoService logisticMemoService;

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping(path = "/api/logisticmemo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WebResponse<LogisticMemoResponse>> newMemo(@RequestBody LogisticMemoRequest request,
            @RequestHeader("USER-ID") String userId) {
        try {
            LogisticMemoResponse logisticMemoResponse = logisticMemoService.newMemo(request, userId);
            return ResponseEntity
                    .ok(WebResponse.<LogisticMemoResponse>builder().data(logisticMemoResponse).error(null).build());
        } catch (IOException e) {
            return ResponseEntity.status(500)
                    .body(WebResponse.<LogisticMemoResponse>builder().data(null).error(e.getMessage()).build());
        }
    }

    @PostMapping(path = "/api/logisticmemo/upload/{memoId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<WebResponse<LogisticMemoResponse>> uploadMemoFile(
            @PathVariable("memoId") String memoId,
            @RequestParam("file") MultipartFile file) {
        try {
            String fileName = fileStorageService.storeFile(file);
            LogisticMemoResponse response = logisticMemoService.updateMemoWithFile(memoId, fileName);
            return ResponseEntity.ok(WebResponse.<LogisticMemoResponse>builder().data(response).error(null).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(WebResponse.<LogisticMemoResponse>builder().data(null).error(e.getMessage()).build());
        }
    }

    @GetMapping(path = "/api/logisticmemo/download/{fileName}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> downloadMemoFile(@PathVariable("fileName") String fileName) {
        Resource resource = fileStorageService.loadFileAsResource(fileName);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping("/api/allmemo")
    public WebResponse<List<LogisticMemoResponse>> findAll(@RequestHeader("USER-ID") String userId,
            @RequestParam(value = "start") Long start,
            @RequestParam(value = "size") Long size) {
        List<LogisticMemoResponse> response = logisticMemoService.findAll(userId, start, size);
        return WebResponse.<List<LogisticMemoResponse>>builder().data(response).error(null).build();
    }

    @PutMapping("/api/editmemo")
    public ResponseEntity<WebResponse<LogisticMemoResponse>> editMemo(@RequestParam("memoId") String memoId,
            @RequestHeader("USER-ID") String userId,
            @RequestBody LogisticMemoRequest request) {
        try {
            LogisticMemoResponse logisticMemoResponse = logisticMemoService.editMemo(memoId, request, userId);
            return ResponseEntity
                    .ok(WebResponse.<LogisticMemoResponse>builder().data(logisticMemoResponse).error(null).build());
        } catch (IOException e) {
            return ResponseEntity.status(500)
                    .body(WebResponse.<LogisticMemoResponse>builder().data(null).error(e.getMessage()).build());
        }
    }

    @GetMapping("api/getMemoByID/{memoId}")
    public WebResponse<LogisticMemoResponse> getMemoById(@PathVariable("memoId") String memoId) {
        LogisticMemoResponse response = logisticMemoService.getMemoById(memoId);
        return WebResponse.<LogisticMemoResponse>builder().data(response).error(null).build();
    }

    @GetMapping("api/allmemo/getmemo")
    public WebResponse<List<LogisticMemoResponse>> findMemo(@RequestHeader("USER-ID") String userId,
            @RequestParam("input") String input) {
        List<LogisticMemoResponse> response = logisticMemoService.findMemo(userId, input);
        return WebResponse.<List<LogisticMemoResponse>>builder().data(response).error(null).build();
    }

    @GetMapping("api/allmemo/pic")
    public ResponseEntity<List<LogisticMemoResponse>> getAllByUserdomainPic(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size,
            @RequestParam("userdomain") String userdomain) {
        List<LogisticMemoResponse> responses = logisticMemoService.findAllByUserdomainPicOrderByDeadline(userid, start,
                size, userdomain);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("api/allmemo/reviewer")
    public ResponseEntity<List<LogisticMemoResponse>> getAllByUserdomainReviewer(
            @RequestHeader("USER-ID") String userid,
            @RequestParam("start") Long start,
            @RequestParam("size") Long size,
            @RequestParam("userdomain") String userdomain) {
        List<LogisticMemoResponse> responses = logisticMemoService.findAllByUserdomainReviewerOrderByDeadline(userid,
                start, size, userdomain);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
