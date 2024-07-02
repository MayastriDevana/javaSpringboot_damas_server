package com.damas.dbdamas.repository.Projectdev;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.damas.dbdamas.model.Projectdev.LogApproveSkse;

public interface LogApproveSkseRepository extends JpaRepository<LogApproveSkse, String> {
  @Query(value = "SELECT * FROM log_approve_skse WHERE UPPER(skse_perihal) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(skse_pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<LogApproveSkse> searchByPerihal(String searchParam);

    @Query(value = "SELECT * FROM log_approve_skse ORDER BY status_approvement DESC", nativeQuery = true)
    List<LogApproveSkse> searchAllOrderByStatus();
    
}
