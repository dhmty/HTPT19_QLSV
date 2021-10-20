package com.source.restapi.repository.impl;

import com.source.restapi.model.ChiTietDonDatHang;
import com.source.restapi.model.IdChiTietDonDatHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("chitietdondathang")
public interface ChiTietDonDatHangRepository extends JpaRepository<ChiTietDonDatHang, IdChiTietDonDatHang> {
    @Query(value = "if exists(Select * from CTDDH where MasoDDh=:maSoDDH and MAVT=:maVT) SELECT 1 ELSE SELECT 0",
            nativeQuery = true)
    Integer checkId(@Param("maSoDDH") String maSoDDH, @Param("maVT") String maVatTu);

    @Modifying
    @Query(value = "INSERT INTO CTDDH VALUES (:maSoDDH, :maVT, :soLuong, :donGia)",
            nativeQuery = true)
    @Transactional
    void insertChiTietDonDatHang(@Param("maSoDDH") String maSoDDH, @Param("maVT") String maVT,
                                @Param("soLuong") Integer soLuong, @Param("donGia") Float donGia);

    @Modifying
    @Query(value = "UPDATE CTDDH SET SOLUONG=:soLuong, DONGIA=:donGia WHERE MasoDDH=:maSoDDH AND MAVT=:maVT",
            nativeQuery = true)
    @Transactional
    void updateChiTietDonDatHang(@Param("maSoDDH") String maSoDDH, @Param("maVT") String maVT,
                                @Param("soLuong") Integer soLuong, @Param("donGia") Float donGia);

    @Modifying
    @Query(value = "DELETE FROM CTDDH WHERE MasoDDH=:maSoDDH AND MAVT=:maVT", nativeQuery = true)
    @Transactional
    void deleteChiTietDonDatHang(@Param("maSoDDH") String maPN, @Param("maVT") String maVT);
}
