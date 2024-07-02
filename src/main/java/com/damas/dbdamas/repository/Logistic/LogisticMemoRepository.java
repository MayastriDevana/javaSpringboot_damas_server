package com.damas.dbdamas.repository.Logistic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.damas.dbdamas.model.Logistic.LogisticMemo;

public interface LogisticMemoRepository extends JpaRepository<LogisticMemo, String> {
    @Query(value = "SELECT * FROM logistic_memo WHERE UPPER(memo_perihal) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(memo_pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(memo_status) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(memo_num) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(memo_deadline) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<LogisticMemo> searchByPerihalorPic(String searchParam);

    @Query(value = "SELECT * FROM logistic_memo WHERE userdomain_pic = :userdomain ORDER BY memo_deadline ASC", nativeQuery = true)
    List<LogisticMemo> findAllByUserdomainPicOrderByDeadline(@Param("userdomain") String userdomain);

    @Query(value = "SELECT * FROM logistic_memo WHERE userdomain_reviewer = :userdomain ORDER BY memo_deadline ASC", nativeQuery = true)
    List<LogisticMemo> findAllByUserdomainReviewerOrderByDeadline(@Param("userdomain") String userdomain);
}
