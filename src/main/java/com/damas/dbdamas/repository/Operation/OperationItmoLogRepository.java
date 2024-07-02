package com.damas.dbdamas.repository.Operation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.damas.dbdamas.model.Operation.OperationItmoLog;

public interface OperationItmoLogRepository extends JpaRepository<OperationItmoLog, String> {
     @Query(value = "SELECT * FROM operation_itmo_log WHERE UPPER(itmo_perihal) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(itmo_pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(Itmo_id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<OperationItmoLog> searchByName(String searchParam);

    @Query(value = "SELECT * FROM operation_itmo_log ORDER BY status_approvement DESC", nativeQuery = true)
    List<OperationItmoLog> searchAllOrderByStatus();
}
