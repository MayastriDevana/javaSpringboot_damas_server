package com.damas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.damas.model.OperationNetwork;



public interface OperationNetworkRepository extends JpaRepository<OperationNetwork, String> {
    @Query(value = "SELECT * FROM operation_network WHERE UPPER(network_perihal) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(network_pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(network_id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<OperationNetwork> searchByNetwork_perihalorNetwork_pic(String searchParam);
}
