package com.damas.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.damas.model.ProjectDev;
import com.damas.model.User;


public interface ProjectDevRepository extends JpaRepository<ProjectDev, String> { // karena udh pake jpa repo jd pake interface
    @Query(value = "SELECT * FROM projectdev WHERE UPPER(projectname) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<ProjectDev> searchByNameorPic(String searchParam);

    // Optional<ProjectDev> updateById(String token);
}
