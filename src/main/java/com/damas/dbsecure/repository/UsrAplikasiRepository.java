package com.damas.dbsecure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.damas.dbsecure.model.UsrAplikasi;

public interface UsrAplikasiRepository extends JpaRepository<UsrAplikasi, String> {
    @Query(value = "SELECT * FROM t_usraplikasi WHERE userid=:userid", nativeQuery = true)
    List<UsrAplikasi> findUseridInUsrAplikasi(@Param("userid") String userid);
}
