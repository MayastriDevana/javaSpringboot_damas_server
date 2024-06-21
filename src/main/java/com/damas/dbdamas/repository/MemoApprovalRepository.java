package com.damas.dbdamas.repository;

import com.damas.dbdamas.model.MemoApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemoApprovalRepository extends JpaRepository<MemoApproval, String> {
    Optional<MemoApproval> findByMemoId(String memo_id);
    Optional<MemoApproval> findByApprovalId(String approval_id); // Update method name to findByApprovalId
}
