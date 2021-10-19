package com.source.restapi.repository.impl;

import com.source.restapi.model.ChiTietDonDatHang;
import com.source.restapi.model.IdChiTietDonDatHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietDonDatHangRepository extends JpaRepository<ChiTietDonDatHang, IdChiTietDonDatHang> {
}
