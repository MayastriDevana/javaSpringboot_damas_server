package com.damas.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.damas.model.ProjectDev;


public interface ProjectDevRepository extends JpaRepository<ProjectDev, String> { // karena udh pake jpa repo jd pake interface
    // Optional<User> findFirstByToken(String token);
    // Optional<User> findFirstByRole(String token);
    // Optional<User> findFirstByUsername(String token);

    // boolean existsByUsername(String username);
}
