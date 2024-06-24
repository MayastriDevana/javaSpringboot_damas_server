package com.damas.dbdamas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.damas.dbdamas.model.OperationServerLog;

public interface OperationServerLogRepository extends JpaRepository<OperationServerLog, String> {
     @Query(value = "SELECT * FROM operation_server_log WHERE UPPER(server_perihal) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(server_pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(server_id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<OperationServerLog> searchByName(String searchParam);

    @Query(value = "SELECT * FROM operation_server_log ORDER BY status_approvement DESC", nativeQuery = true)
    List<OperationServerLog> searchAllOrderByStatus();
}
