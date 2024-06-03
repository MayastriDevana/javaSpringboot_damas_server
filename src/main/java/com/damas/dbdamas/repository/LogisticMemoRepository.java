package com.damas.dbdamas.repository;

import java.util.List;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.damas.dbdamas.model.LogisticMemo;

public interface LogisticMemoRepository extends JpaRepository<LogisticMemo, String> { // karena udh pake jpa repo jd pake interface
@Query(value = "SELECT * FROM logistic_memo WHERE UPPER(memo_perihal) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(memo_pic) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<LogisticMemo> searchByPerihalorPic(String searchParam);
}
