package com.damas.dbdamas.repository.Operation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.damas.dbdamas.model.Operation.OperationItsecurity;

public interface OperationItsecurityRepository extends JpaRepository<OperationItsecurity, String> {
     @Query(value = "SELECT * FROM operation_itsecurity WHERE UPPER(itsecurity_perihal) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(itsecurity_pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(itsecurity_id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<OperationItsecurity> searchByItsecurity_perihalorItsecurity_pic(String searchParam);

    @Query(value = "SELECT * FROM operation_itsecurity ORDER BY itsecurity_deadline_project ASC", nativeQuery = true)
    List<OperationItsecurity> searchAllOrderByDeadline();

    @Query(value = "SELECT * FROM operation_itsecurity WHERE userdomain_pic =:userdomain ORDER BY itsecurity_deadline_project ASC", nativeQuery = true)
    List<OperationItsecurity> findByUserdomainOrderByDeadline(@Param("userdomain") String userdomain);
}
