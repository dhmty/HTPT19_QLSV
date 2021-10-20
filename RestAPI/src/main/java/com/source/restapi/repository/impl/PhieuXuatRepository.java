package com.source.restapi.repository.impl;

import com.source.restapi.model.PhieuXuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("phieuxuat")
public interface PhieuXuatRepository extends JpaRepository<PhieuXuat, String> {
    @Query(value = "select * from PhieuXuat", nativeQuery = true)
    List<PhieuXuat> selectAll();
}
