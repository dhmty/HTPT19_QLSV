package com.source.restapi.repository.impl;

import com.source.restapi.model.DatHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatHangRepository extends JpaRepository<DatHang, String> {
}
