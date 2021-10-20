package com.source.restapi.repository.impl;

import com.source.restapi.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("nhanvien")
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    @Query(value = "if exists(Select * from NhanVien where MANV=:maNV) SELECT 1 ELSE  SELECT 0",
            nativeQuery = true)
    Integer checkId(@Param("maNV") String maNV);
}
