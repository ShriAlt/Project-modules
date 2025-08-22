package com.xworkz.module.repository;

import com.xworkz.module.entity.OtpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OtpRepository extends JpaRepository<OtpEntity ,Long> {

    @Query("SELECT entity FROM OtpEntity entity WHERE entity.email = :email ORDER BY entity.createdTime DESC ")
    List<OtpEntity> findRecentByEmail(@Param("email") String email);

}
