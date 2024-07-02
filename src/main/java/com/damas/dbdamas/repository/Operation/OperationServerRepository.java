package com.damas.dbdamas.repository.Operation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.damas.dbdamas.model.Operation.OperationServer;

public interface OperationServerRepository extends JpaRepository<OperationServer, String> {
    @Query(value = "SELECT * FROM operation_server WHERE UPPER(server_perihal) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(server_pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(server_id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<OperationServer> searchByServer_perihalorServer_pic(String searchParam);
    
    @Query(value = "SELECT * FROM operation_server ORDER BY server_deadline_project ASC", nativeQuery = true)
    List<OperationServer> searchAllOrderByDeadline();

    @Query(value = "SELECT * FROM operation_server WHERE userdomain_pic =:userdomain ORDER BY server_deadline_project ASC", nativeQuery = true)
    List<OperationServer> findByUserdomainOrderByDeadline(@Param("userdomain") String userdomain);
}
