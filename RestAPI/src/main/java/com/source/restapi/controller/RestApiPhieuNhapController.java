package com.source.restapi.controller;

import com.source.restapi.model.PhieuNhap;
import com.source.restapi.repository.impl.PhieuNhapRepository;
import com.source.restapi.response.PhieuNhapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class RestApiPhieuNhapController {

    @Autowired
    @Qualifier("phieunhap")
    private PhieuNhapRepository phieuNhapRepository;

    @GetMapping("phieunhap")
    public List<PhieuNhapResponse> getListPhieuNhap(){
        List<PhieuNhap> phieuNhapList = phieuNhapRepository.findAll();
        List<PhieuNhapResponse> phieuNhapResponseList = new ArrayList<>();
        phieuNhapList.forEach(e->{
            PhieuNhapResponse phieuNhapResponse = new PhieuNhapResponse();
            phieuNhapResponse.setMaPhieuNhap(e.getMaPhieuNhap());
            phieuNhapResponse.setNgay(e.getNgay());
            phieuNhapResponse.setDatHang(e.getDatHang().toString());
            phieuNhapResponse.setNhanVien(e.getNhanVien().toString());
            phieuNhapResponseList.add(phieuNhapResponse);
        });
        return phieuNhapResponseList;
    }
}
