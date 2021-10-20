package com.source.restapi.repository.impl;

import com.source.restapi.model.DatHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository("dathang")
public interface DatHangRepository extends JpaRepository<DatHang, String> {
    @Query(value = "if exists(Select * from DatHang where MasoDDH=:maSoDDH) SELECT 1 ELSE  SELECT 0",
            nativeQuery = true)
    Integer checkId(@Param("maSoDDH") String maSoDDH);

    @Modifying
    @Query(value = "INSERT INTO DatHang (NGAY, NhaCC, MANV) VALUES (:ngay, :nhaCC, :maNV)", nativeQuery = true)
    @Transactional
    void insertDatHang(@Param("ngay") Date ngay,
                         @Param("nhaCC") String nhaCungCap, @Param("maNV") String maNV);

    @Modifying
    @Query(value = "UPDATE DatHang SET NGAY = :ngay, NhaCC=:nhaCC, MANV=:maNV WHERE MasoDDH = :maSoDDH",
            nativeQuery = true)
    @Transactional
    void updateDatHang(@Param("maSoDDH") String maSoDDH, @Param("ngay") Date ngay,
                         @Param("nhaCC") String nhaCC, @Param("maNV") String maNV);

    @Modifying
    @Query(value = "DELETE FROM DatHang WHERE MasoDDH=:maSoDDH", nativeQuery = true)
    @Transactional
    void deleteDatHang(@Param("maSoDDH") String maSoDDH);
}
