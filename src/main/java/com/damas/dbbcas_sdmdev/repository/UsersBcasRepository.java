package com.damas.dbbcas_sdmdev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.damas.dbbcas_sdmdev.model.Users;

public interface UsersBcasRepository extends JpaRepository<Users, String> {
@Query(value = "SELECT nama, departement FROM users", nativeQuery = true)
List<Users> findNamaAndDeptInUsers();
    
}
