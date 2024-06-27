package com.damas.dbdamas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.damas.dbdamas.model.OperationItsupport;

public interface OperationItsupportRepository extends JpaRepository<OperationItsupport, String> {
    @Query(value = "SELECT * FROM operation_itsupport WHERE UPPER(itsupport_perihal) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(itsupport_pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(itsupport_id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<OperationItsupport> searchByItsupport_perihalorItsupport_pic(String searchParam);

    @Query(value = "SELECT * FROM operation_itsupport ORDER BY itsupport_deadline_project ASC", nativeQuery = true)
    List<OperationItsupport> searchAllOrderByDeadline();

    @Query(value = "SELECT * FROM operation_itsupport WHERE userdomain_pic =:userdomain ORDER BY itsupport_deadline_project ASC", nativeQuery = true)
    List<OperationItsupport> findByUserdomainOrderByDeadline(@Param("userdomain") String userdomain);
}
