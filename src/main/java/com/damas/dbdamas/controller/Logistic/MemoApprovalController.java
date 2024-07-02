package com.damas.dbdamas.controller.Logistic;

import com.damas.dbdamas.payload.Logistic.MemoApprovalRequest;
import com.damas.dbdamas.payload.Logistic.MemoApprovalResponse;
import com.damas.dbdamas.service.Logistic.MemoApprovalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/memo-approval")
public class MemoApprovalController {

    @Autowired
    private MemoApprovalService memoApprovalService;

    @GetMapping("/memo-or-create/{memoId}")
    public MemoApprovalResponse getOrCreateMemoApproval(@PathVariable String memoId, @RequestParam String userId) {
        return memoApprovalService.getOrCreateApprovalByMemoId(memoId, userId);
    }

    @PostMapping("/save-or-update")
    public MemoApprovalResponse saveOrUpdateMemoApproval(
        @RequestParam("approval_id") String approvalId,
        @RequestParam("memo_id") String memoId,
        @RequestParam("approval_status") String approvalStatus,
        @RequestParam(value = "approval_upload", required = false) MultipartFile approvalUpload,
        @RequestParam("approval_notes") String approvalNotes,
        @RequestParam("userId") String userId) {

        MemoApprovalRequest request = new MemoApprovalRequest();
        request.setApproval_id(approvalId);
        request.setMemo_id(memoId);
        request.setApproval_status(approvalStatus);
        request.setApproval_upload(approvalUpload);
        request.setApproval_notes(approvalNotes);

        return memoApprovalService.saveOrUpdateApproval(request, userId);
    }
}
