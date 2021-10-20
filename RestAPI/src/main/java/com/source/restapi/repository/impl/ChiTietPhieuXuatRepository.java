package com.source.restapi.repository.impl;

import com.source.restapi.model.ChiTietPhieuXuat;
import com.source.restapi.model.IdChiTietPhieuXuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("chitietphieuxuat")
public interface ChiTietPhieuXuatRepository extends JpaRepository<ChiTietPhieuXuat, IdChiTietPhieuXuat> {

}
