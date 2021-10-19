package com.source.restapi.repository.impl;

import com.source.restapi.model.ChiTietPhieuNhap;
import com.source.restapi.model.IdChiTietPhieuNhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietPhieuNhapRepository extends JpaRepository<ChiTietPhieuNhap, IdChiTietPhieuNhap> {
}
