package com.damas.dbdamas.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.damas.dbdamas.model.ProjectDev;


public interface ProjectDevRepository extends JpaRepository<ProjectDev, String> { // karena udh pake jpa repo jd pake interface
    @Query(value = "SELECT * FROM projectdev WHERE UPPER(projectname) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<ProjectDev> searchByNameorPic(String searchParam);
    
    @Query(value = "SELECT * FROM projectdev ORDER BY deadline_project ASC", nativeQuery = true)
    List<ProjectDev> searchAllOrderByDeadline();

    // Optional<ProjectDev> updateById(String token);
}
