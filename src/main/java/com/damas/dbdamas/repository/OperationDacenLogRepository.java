package com.damas.dbdamas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.damas.dbdamas.model.OperationDacenLog;

public interface OperationDacenLogRepository extends JpaRepository<OperationDacenLog, String> {
    @Query(value = "SELECT * FROM operation_dacen_log WHERE UPPER(dacen_perihal) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(dacen_pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(dacen_id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<OperationDacenLog> searchByName(String searchParam);

    @Query(value = "SELECT * FROM operation_dacen_log ORDER BY status_approvement DESC", nativeQuery = true)
    List<OperationDacenLog> searchAllOrderByStatus();
}
