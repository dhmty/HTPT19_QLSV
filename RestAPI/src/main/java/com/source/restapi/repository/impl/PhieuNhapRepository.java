package com.source.restapi.repository.impl;

import com.source.restapi.model.PhieuNhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("phieunhap")
public interface PhieuNhapRepository extends JpaRepository<PhieuNhap, String> {
}
