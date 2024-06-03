package com.damas.dbdamas.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.damas.dbdamas.model.ProjectPhase;


public interface ProjectPhaseRepository extends JpaRepository<ProjectPhase, String> { // karena udh pake jpa repo jd pake interface
    @Query(value = "SELECT * FROM projectphase WHERE UPPER(project_name) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<ProjectPhase> searchByNameorPic(String searchParam);

    // Optional<ProjectDev> updateById(String token);
}
