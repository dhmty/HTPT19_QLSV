package com.source.restapi.repository.impl;

import com.source.restapi.model.Quyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("quyen")
public interface QuyenRepository extends JpaRepository<Quyen, String> {
    @Query(value = "Select * from Quyen", nativeQuery = true)
    List<Quyen> selectAll();
}
