package com.source.restapi.controller;

import com.source.restapi.model.PhieuNhap;
import com.source.restapi.repository.impl.DatHangRepository;
import com.source.restapi.repository.impl.NhanVienRepository;
import com.source.restapi.repository.impl.PhieuNhapRepository;
import com.source.restapi.response.PhieuNhapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class RestApiPhieuNhapController {

    @Autowired
    @Qualifier("phieunhap")
    private PhieuNhapRepository phieuNhapRepository;
    @Autowired
    @Qualifier("dathang")
    private DatHangRepository datHangRepository;
    @Autowired
    @Qualifier("nhanvien")
    private NhanVienRepository nhanVienRepository;

    public PhieuNhapResponse convertToPhieuNhapResponse(PhieuNhap pn){
        PhieuNhapResponse phieuNhapResponse = new PhieuNhapResponse(
                pn.getMaPhieuNhap(),
                pn.getNgay(),
                pn.getDatHang().getMaSoDDH(),
                pn.getNhanVien().getMaNhanVien()
        );
        return phieuNhapResponse;
    }

    @GetMapping("phieunhap")
    public List<PhieuNhapResponse> getListPhieuNhap(){
        List<PhieuNhap> phieuNhapList = phieuNhapRepository.findAll();
        List<PhieuNhapResponse> phieuNhapResponseList = new ArrayList<>();
        phieuNhapList.forEach(e->{
            phieuNhapResponseList.add(convertToPhieuNhapResponse(e));
        });
        return phieuNhapResponseList;
    }

    @PostMapping("phieunhap")
    public String postListPhieuNhap(@RequestBody PhieuNhapResponse phieuNhapResponse){
        List<PhieuNhap> phieuNhapList = phieuNhapRepository.findAll();
        for (PhieuNhap pn : phieuNhapList) {
            if (pn.getDatHang().getMaSoDDH().equals(phieuNhapResponse.getMaSoDonDatHang())){
                return "maSoDDH bị trùng với record khác";
            }
        }
        if (datHangRepository.checkId(phieuNhapResponse.getMaSoDonDatHang())==0){
            return "maSoDDH không tồn tại trong bảng đặt hàng";
        }
        if (nhanVienRepository.checkId(phieuNhapResponse.getMaNhanVien())==0){
            return "maNhanVien không tồn tại trong bảng nhân viên";
        }
        phieuNhapRepository.insertPhieuNhap(
                phieuNhapResponse.getNgay(),
                phieuNhapResponse.getMaSoDonDatHang(),
                phieuNhapResponse.getMaNhanVien()
        );
        return "Thêm phiếu nhập thành công";
    }

    @PutMapping("phieunhap")
    public String putListPhieuNhap(@RequestBody PhieuNhapResponse phieuNhapResponse){
        List<PhieuNhap> phieuNhapList = phieuNhapRepository.findAll();
        for (PhieuNhap pn : phieuNhapList) {
            if (pn.getDatHang().getMaSoDDH().equals(phieuNhapResponse.getMaSoDonDatHang())){
                return "maSoDDH bị trùng với record khác";
            }
        }
        if (datHangRepository.checkId(phieuNhapResponse.getMaSoDonDatHang())==0){
            return "maSoDDH không tồn tại trong bảng đặt hàng";
        }
        if (nhanVienRepository.checkId(phieuNhapResponse.getMaNhanVien())==0){
            return "maNhanVien không tồn tại trong bảng nhân viên";
        }
        if (phieuNhapRepository.checkId(phieuNhapResponse.getMaPhieuNhap())==0){
            return "maPhieuNhap không tồn tại trong bảng phiếu nhập";
        }
        phieuNhapRepository.updatePhieuNhap(
                phieuNhapResponse.getMaPhieuNhap(),
                phieuNhapResponse.getNgay(),
                phieuNhapResponse.getMaSoDonDatHang(),
                phieuNhapResponse.getMaNhanVien());
        return "Sửa phiếu nhập thành công  ";
    }

    @DeleteMapping("phieunhap/{id}")
    public String deleteListPhieuNhap(@PathVariable(name = "id") Integer id){
        List<PhieuNhap> phieuNhapList = phieuNhapRepository.findAll();
        if (id>=phieuNhapList.size()){
            return "Id không tồn tại";
        }
        PhieuNhap phieuNhap = phieuNhapList.get(id);
        phieuNhapRepository.deletePhieuNhap(phieuNhap.getMaPhieuNhap());
        return "Xóa phiếu nhập thành công";
    }
}
