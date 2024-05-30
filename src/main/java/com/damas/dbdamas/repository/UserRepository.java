package com.damas.dbdamas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.damas.dbdamas.model.User;

public interface UserRepository extends JpaRepository<User, String> { // karena udh pake jpa repo jd pake interface
    Optional<User> findFirstByToken(String token);
    Optional<User> findFirstByRole(String token);
    Optional<User> findFirstByUsername(String token);
    // Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}
