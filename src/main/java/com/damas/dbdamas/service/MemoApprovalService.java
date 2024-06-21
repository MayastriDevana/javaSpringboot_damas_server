package com.damas.dbdamas.service;

import com.damas.dbdamas.model.MemoApproval;
import com.damas.dbdamas.payload.MemoApprovalRequest;
import com.damas.dbdamas.payload.MemoApprovalResponse;
import com.damas.dbdamas.repository.MemoApprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@Service
public class MemoApprovalService {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private MemoApprovalRepository memoApprovalRepository;

    @Autowired
    private ValidationService validationService;

    public MemoApprovalResponse saveOrUpdateApproval(MemoApprovalRequest request, String userId) {
        validationService.validateRequest(request);

        MemoApproval memoApproval = memoApprovalRepository.findByApprovalId(request.getApproval_id()).orElse(new MemoApproval());
        
        memoApproval.setApproval_status(request.getApproval_status());

        MultipartFile file = request.getApproval_upload();
        if (file != null && !file.isEmpty()) {
            String fileName = fileStorageService.storeFile(file);
            memoApproval.setApproval_upload(fileName);
        }

        memoApproval.setApproval_notes(request.getApproval_notes());

        memoApprovalRepository.save(memoApproval);

        return MemoApprovalResponse.builder()
            .approval_status(memoApproval.getApproval_status())
            .approval_upload(memoApproval.getApproval_upload())
            .approval_notes(memoApproval.getApproval_notes())
            .build();
    }

    public MemoApprovalResponse getMemoById(String memo_id) {
        MemoApproval memoApproval = memoApprovalRepository.findByMemoId(memo_id)
            .orElseThrow(() -> new RuntimeException("Memo not found"));

        return MemoApprovalResponse.builder()
            .approval_status(memoApproval.getApproval_status())
            .approval_notes(memoApproval.getApproval_notes())
            .build();
    }

    public MemoApprovalResponse getApprovalById(String approval_id) {
        MemoApproval memoApproval = memoApprovalRepository.findByApprovalId(approval_id)
            .orElseThrow(() -> new RuntimeException("Approval not found"));

        return MemoApprovalResponse.builder()
            .approval_status(memoApproval.getApproval_status())
            .approval_notes(memoApproval.getApproval_notes())
            .build();
    }

    public MemoApprovalResponse getOrCreateApprovalByMemoId(String memoId, String userId) {
        MemoApproval existingApproval = memoApprovalRepository.findByMemoId(memoId).orElse(null);

        if (existingApproval != null) {
            return MemoApprovalResponse.builder()
                .approval_status(existingApproval.getApproval_status())
                .approval_upload(existingApproval.getApproval_upload())
                .approval_notes(existingApproval.getApproval_notes())
                .build();
        }

        MemoApprovalRequest newApprovalRequest = new MemoApprovalRequest();
        newApprovalRequest.setMemo_id(memoId);
        newApprovalRequest.setApproval_status("Pending");
        MemoApprovalResponse newApproval = saveOrUpdateApproval(newApprovalRequest, userId);

        return newApproval;
    }

    public Path loadFile(String fileName) {
        return fileStorageService.loadFile(fileName);
    }
}
