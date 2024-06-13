package com.damas.dbdamas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.damas.dbdamas.model.OperationServer;

public interface OperationServerRepository extends JpaRepository<OperationServer, String> {
    @Query(value = "SELECT * FROM operation_Server WHERE UPPER(server_perihal) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(server_pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(Server_id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<OperationServer> searchByServer_perihalorServer_pic(String searchParam);
    
}
