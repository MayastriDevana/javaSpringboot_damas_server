package com.damas.dbdamas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.damas.dbdamas.model.OperationItsecurityLog;

public interface OperationItsecurityLogRepository extends JpaRepository<OperationItsecurityLog, String> {
     @Query(value = "SELECT * FROM operation_itsecurity_log WHERE UPPER(itsecurity_perihal) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(itsecurity_pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(itsecurity_id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<OperationItsecurityLog> searchByName(String searchParam);

    @Query(value = "SELECT * FROM operation_itsecurity_log ORDER BY status_approvement DESC", nativeQuery = true)
    List<OperationItsecurityLog> searchAllOrderByStatus();
}
