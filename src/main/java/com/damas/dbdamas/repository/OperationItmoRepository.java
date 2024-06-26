package com.damas.dbdamas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.damas.dbdamas.model.OperationItmo;

public interface OperationItmoRepository extends JpaRepository<OperationItmo, String> {
    @Query(value = "SELECT * FROM operation_itmo WHERE UPPER(Itmo_perihal) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(itmo_pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(itmo_id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<OperationItmo> searchByItmo_perihalorItmo_pic(String searchParam);

    @Query(value = "SELECT * FROM operation_itmo ORDER BY itmo_deadline_project ASC", nativeQuery = true)
    List<OperationItmo> searchAllOrderByDeadline();
}