package com.source.restapi.repository.impl;

import com.source.restapi.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {

    @Query(value = "Select * from NhanVien", nativeQuery = true)
    List<NhanVien> selectAll();
}
