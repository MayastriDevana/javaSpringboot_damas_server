package com.damas.dbdamas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.damas.dbdamas.model.OperationSystem;

public interface OperationSystemRepository extends JpaRepository<OperationSystem, String> {
    
}
