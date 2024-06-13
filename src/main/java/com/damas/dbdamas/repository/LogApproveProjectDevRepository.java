package com.damas.dbdamas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.damas.dbdamas.model.LogApproveProjectDev;


public interface LogApproveProjectDevRepository extends JpaRepository<LogApproveProjectDev, String>{
    @Query(value = "SELECT * FROM log_approve_project WHERE UPPER(projectname) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<LogApproveProjectDev> searchByName(String searchParam);
}
