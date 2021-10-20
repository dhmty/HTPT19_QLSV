package com.source.restapi.repository.impl;

import com.source.restapi.model.VatTu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("vattu")
public interface VatTuRepository extends JpaRepository<VatTu, String> {
    @Query(value = "if exists(Select * from Vattu where MAVT=:maVT) SELECT 1 ELSE SELECT 0",
            nativeQuery = true)
    Integer checkId(@Param("maVT") String maVatTu);
}
