package com.damas.dbdamas.repository.Logistic;

import org.springframework.data.jpa.repository.JpaRepository;

import com.damas.dbdamas.model.Logistic.MemoApproval;

import java.util.Optional;

public interface MemoApprovalRepository extends JpaRepository<MemoApproval, String> {
    Optional<MemoApproval> findByMemoId(String memo_id);
    Optional<MemoApproval> findByApprovalId(String approval_id); // Update method name to findByApprovalId
}
