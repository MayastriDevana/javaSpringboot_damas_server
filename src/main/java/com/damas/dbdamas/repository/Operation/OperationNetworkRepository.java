package com.damas.dbdamas.repository.Operation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.damas.dbdamas.model.Operation.OperationNetwork;



public interface OperationNetworkRepository extends JpaRepository<OperationNetwork, String> {
    @Query(value = "SELECT * FROM operation_network WHERE UPPER(network_perihal) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(network_pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(network_id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<OperationNetwork> searchByNetwork_perihalorNetwork_pic(String searchParam);

    @Query(value = "SELECT * FROM operation_network ORDER BY network_deadline_project ASC", nativeQuery = true)
    List<OperationNetwork> searchAllOrderByDeadline();

     @Query(value = "SELECT * FROM operation_network WHERE userdomain_pic =:userdomain ORDER BY network_deadline_project ASC", nativeQuery = true)
    List<OperationNetwork> findByUserdomainOrderByDeadline(@Param("userdomain") String userdomain);
}
