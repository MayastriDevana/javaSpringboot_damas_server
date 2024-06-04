package com.damas.dbbcassdmdev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.damas.dbbcassdmdev.model.Users;

public interface UsersBcasRepository extends JpaRepository<Users, String> {
@Query(value = "SELECT * FROM users", nativeQuery = true)
List<Users> findNamaAndDeptInUsers();
    
}
