package com.source.restapi.repository.impl;

import com.source.restapi.model.ChiTietPhieuNhap;
import com.source.restapi.model.IdChiTietPhieuNhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("chitietphieunhap")
public interface ChiTietPhieuNhapRepository extends JpaRepository<ChiTietPhieuNhap, IdChiTietPhieuNhap> {
    @Query(value = "if exists(Select * from CTPN where MAPN=:maPN and MAVT=:maVT) SELECT 1 ELSE SELECT 0",
            nativeQuery = true)
    Integer checkId(@Param("maPN") String maPN, @Param("maVT") String maVatTu);

    @Modifying
    @Query(value = "INSERT INTO CTPN VALUES (:maPN, :maVT, :soLuong, :donGia)",
            nativeQuery = true)
    @Transactional
    void insertChiTietPhieuNhap(@Param("maPN") String maPN, @Param("maVT") String maVT,
                                @Param("soLuong") Integer soLuong, @Param("donGia") Float donGia);

    @Modifying
    @Query(value = "UPDATE CTPN SET SOLUONG=:soLuong, DONGIA=:donGia WHERE MAPN=:maPN AND MAVT=:maVT",
            nativeQuery = true)
    @Transactional
    void updateChiTietPhieuNhap(@Param("maPN") String maPN, @Param("maVT") String maVT,
                         @Param("soLuong") Integer soLuong, @Param("donGia") Float donGia);

    @Modifying
    @Query(value = "DELETE FROM CTPN WHERE MAPN=:maPN AND MAVT=:maVT", nativeQuery = true)
    @Transactional
    void deleteChiTietPhieuNhap(@Param("maPN") String maPN, @Param("maVT") String maVT);
}
