package com.source.restapi.repository.impl;

import com.source.restapi.model.PhieuNhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository("phieunhap")
public interface PhieuNhapRepository extends JpaRepository<PhieuNhap, String> {
    @Query(value = "if exists(Select * from PhieuNhap where MAPN=:maPN) SELECT 1 ELSE  SELECT 0",
            nativeQuery = true)
    Integer checkId(@Param("maPN") String maPN);

    @Modifying
    @Query(value = "INSERT INTO PhieuNhap (NGAY, MasoDDH, MANV) VALUES (:ngay, :maSoDDH, :maNV)",
            nativeQuery = true)
    @Transactional
    void insertPhieuNhap(@Param("ngay") Date ngay,
                            @Param("maSoDDH") String maSoDDH, @Param("maNV") String maNV);

    @Modifying
    @Query(value = "UPDATE PhieuNhap SET NGAY = :ngay, MasoDDH=:maSoDDH, MANV=:maNV WHERE MAPN = :maPN",
            nativeQuery = true)
    @Transactional
    void updatePhieuNhap(@Param("maPN") String maPN, @Param("ngay") Date ngay,
                         @Param("maSoDDH") String maSoDDH, @Param("maNV") String maNV);

    @Modifying
    @Query(value = "DELETE FROM PhieuNhap WHERE MAPN=:maPN", nativeQuery = true)
    @Transactional
    void deletePhieuNhap(@Param("maPN") String maPN);
}
