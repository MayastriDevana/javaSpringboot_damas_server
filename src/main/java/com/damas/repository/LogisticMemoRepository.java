package com.damas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.damas.model.LogisticMemo;


public interface LogisticMemoRepository extends JpaRepository<LogisticMemo, String> { // karena udh pake jpa repo jd pake interface
    // Optional<User> findFirstByToken(String token);
    // Optional<User> findFirstByRole(String token);
    // Optional<User> findFirstByUsername(String token);

    // boolean existsByUsername(String username);
}
