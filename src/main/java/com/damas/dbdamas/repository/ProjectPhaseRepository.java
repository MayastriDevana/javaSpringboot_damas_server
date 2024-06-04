package com.damas.dbdamas.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.damas.dbdamas.model.ProjectPhase;


public interface ProjectPhaseRepository extends JpaRepository<ProjectPhase, String> { // karena udh pake jpa repo jd pake interface
    @Query(value = "SELECT * FROM projectphase", nativeQuery = true)
    List<ProjectPhase> getAll();

    // Optional<ProjectDev> updateById(String token);
}
