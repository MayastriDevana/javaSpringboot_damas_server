package com.damas.dbdamas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.damas.dbdamas.model.OperationItsecurity;

public interface OperationItsecurityRepository extends JpaRepository<OperationItsecurity, String> {
     @Query(value = "SELECT * FROM operation_itsecurity WHERE UPPER(itsecurity_perihal) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(itsecurity_pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(itsecurity_id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<OperationItsecurity> searchByItsecurity_perihalorItsecurity_pic(String searchParam);
}
