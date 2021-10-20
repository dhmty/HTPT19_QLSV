package com.source.restapi.repository.impl;

import com.source.restapi.model.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("taikhoan")
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, String> {

    @Query(value = "Select * from TaiKhoan", nativeQuery = true)
    public List<TaiKhoan> selectAll();
}
