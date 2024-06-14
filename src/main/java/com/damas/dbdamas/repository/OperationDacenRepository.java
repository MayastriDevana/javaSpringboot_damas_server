package com.damas.dbdamas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.damas.dbdamas.model.OperationDacen;

public interface OperationDacenRepository extends JpaRepository<OperationDacen, String> {
    @Query(value = "SELECT * FROM operation_dacen WHERE UPPER(dacen_perihal) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(dacen_pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(dacen_id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<OperationDacen> searchByDacen_perihalorDacen_pic(String searchParam);
    
}
