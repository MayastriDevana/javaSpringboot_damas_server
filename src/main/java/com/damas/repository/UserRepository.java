package com.damas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.damas.model.User;

public interface UserRepository extends JpaRepository<User, String> { // karena udh pake jpa repo jd pake interface
    Optional<User> findFirstByToken(String token);
    Optional<User> findFirstByRole(String token);
    Optional<User> findFirstByUsername(String token);

    boolean existsByUsername(String username);
}
