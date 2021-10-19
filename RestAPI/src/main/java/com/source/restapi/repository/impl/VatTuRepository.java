package com.source.restapi.repository.impl;

import com.source.restapi.model.VatTu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VatTuRepository extends JpaRepository<VatTu, String> {
    @Query(value = "select * from Vattu", nativeQuery = true)
    List<VatTu> selectAll();
}
