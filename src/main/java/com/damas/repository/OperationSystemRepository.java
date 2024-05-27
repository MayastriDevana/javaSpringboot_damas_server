package com.damas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.damas.model.OperationSystem;

public interface OperationSystemRepository extends JpaRepository<OperationSystem, String> {
    
}
