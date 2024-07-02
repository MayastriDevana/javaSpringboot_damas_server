package com.damas.dbdamas.repository.Projectdev;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.damas.dbdamas.model.Projectdev.Skse;

public interface SkseRepository extends JpaRepository<Skse, String> {
    @Query(value = "SELECT * FROM ppo_skse WHERE UPPER(skse_perihal) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(skse_pic) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(id) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<Skse> searchByPerihalorPic(String searchParam);

    @Query(value = "SELECT * FROM ppo_skse WHERE userdomain_pic =:userdomain ORDER BY skse_deadline ASC", nativeQuery = true)
    List<Skse> findByUserdomainOrderByDeadline(@Param("userdomain") String userdomain);

}
