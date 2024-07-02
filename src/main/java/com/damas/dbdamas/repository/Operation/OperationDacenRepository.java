package com.damas.dbdamas.repository.Operation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.damas.dbdamas.model.Operation.OperationDacen;

public interface OperationDacenRepository extends JpaRepository<OperationDacen, String> {
    @Query(value = "SELECT * FROM operation_dacen WHERE UPPER(dacen_perihal) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(dacen_pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(dacen_id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<OperationDacen> searchByDacen_perihalorDacen_pic(String searchParam);
    
    @Query(value = "SELECT * FROM operation_dacen ORDER BY dacen_deadline_project ASC", nativeQuery = true)
    List<OperationDacen> searchAllOrderByDeadline();

    @Query(value = "SELECT * FROM operation_dacen WHERE userdomain_pic =:userdomain ORDER BY dacen_deadline_project ASC", nativeQuery = true)
    List<OperationDacen> findByUserdomainOrderByDeadline(@Param("userdomain") String userdomain);
}
