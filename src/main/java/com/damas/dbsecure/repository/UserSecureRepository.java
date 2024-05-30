package com.damas.dbsecure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.damas.dbsecure.model.Tuser;

public interface UserSecureRepository extends JpaRepository<Tuser, String> {
    @Query(value = "EXEC uspLogonAPI @userid=:userid , @kode_aplikasi='00102' , @pass=:pass", nativeQuery = true)
    List<String> loginSecure(@Param("userid") String userid, @Param("pass") String pass);

    @Modifying
    @Transactional
    @Query(value = "EXEC uspLogoffapl @userid=:userid , @kode_aplikasi='00102'", nativeQuery = true)
    void logoutSecure(@Param("userid") String userid);

    @Query(value = "SELECT * FROM t_users WHERE userid=:userid", nativeQuery = true)
    List<Tuser> findUseridInUsers(@Param("userid") String userid);
}
