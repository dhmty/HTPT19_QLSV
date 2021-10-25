package com.source.restapi.controller;

import com.source.restapi.exception.ResourceNotFoundException;
import com.source.restapi.model.SinhVien;
import com.source.restapi.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/students")
public class SinhVienController {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @GetMapping
    public List<SinhVien> getAllStudents(){
        return sinhVienRepository.findAll();
    }
    // build create SinhVien REST API
    @PostMapping
    public SinhVien createSinhVien(@RequestBody SinhVien sinhVien) {
        if (sinhVienRepository.existsById(sinhVien.getMaSV()))
            throw new ResourceNotFoundException("Mã SinhVien đã tồn tại, Thêm mã khác");
        return sinhVienRepository.save(sinhVien);
    }

    // build get SinhVien by maSV REST API
    @GetMapping(value = "{maSV}")
    public ResponseEntity<SinhVien> getSinhVienById(@PathVariable  String maSV){
        SinhVien sinhVien = sinhVienRepository.findById(maSV)
                .orElseThrow(() -> new ResourceNotFoundException("SinhVien not exist with id:" + maSV));
        return ResponseEntity.ok(sinhVien);
    }

    // build update SinhVien REST API
    @PutMapping("{maSV}")
    public ResponseEntity<SinhVien> updateSinhVien(@PathVariable String maSV,@RequestBody SinhVien sinhVienDetails) {
        SinhVien updateSinhVien = sinhVienRepository.findById(maSV)
                .orElseThrow(() -> new ResourceNotFoundException("SinhVien not exist with id: " + maSV));

        updateSinhVien.setHo(sinhVienDetails.getHo());
        updateSinhVien.setTen(sinhVienDetails.getTen());
        updateSinhVien.setEmail(sinhVienDetails.getEmail());
        updateSinhVien.setNgaySinh(sinhVienDetails.getNgaySinh());
        updateSinhVien.setGioiTinh(sinhVienDetails.isGioiTinh());
        updateSinhVien.setNganh(sinhVienDetails.getNganh());
        updateSinhVien.setGPA(sinhVienDetails.getGPA());
        updateSinhVien.setKhoaHoc(sinhVienDetails.getKhoaHoc());

        sinhVienRepository.save(updateSinhVien);
        return ResponseEntity.ok(updateSinhVien);
    }

    // build delete SinhVien REST API
    @DeleteMapping("{maSV}")
    public ResponseEntity<HttpStatus> deleteSinhVien(@PathVariable String maSV){

        SinhVien sinhVien = sinhVienRepository.findById(maSV)
                .orElseThrow(() -> new ResourceNotFoundException("SinhVien not exist with id: " + maSV));

        sinhVienRepository.delete(sinhVien);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
