package com.source.restapi.controller;

import com.source.restapi.model.ChiTietPhieuNhap;
import com.source.restapi.repository.impl.ChiTietPhieuNhapRepository;
import com.source.restapi.repository.impl.PhieuNhapRepository;
import com.source.restapi.repository.impl.VatTuRepository;
import com.source.restapi.response.ChiTietPhieuNhapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class RestAPIChiTietPhieuNhapController {
    @Autowired
    @Qualifier("chitietphieunhap")
    private ChiTietPhieuNhapRepository chiTietPhieuNhapRepository;
    @Autowired
    @Qualifier("vattu")
    private VatTuRepository vatTuRepository;
    @Autowired
    @Qualifier("phieunhap")
    private PhieuNhapRepository phieuNhapRepository;

    public ChiTietPhieuNhapResponse convertToChiTietPhieuNhapResponse(ChiTietPhieuNhap ctpn) {
        ChiTietPhieuNhapResponse chiTietPhieuNhapResponse = new ChiTietPhieuNhapResponse(
                ctpn.getPhieuNhap().getMaPhieuNhap(),
                ctpn.getVatTu().getMaVatTu(),
                ctpn.getSoLuong(),
                ctpn.getDonGia()
        );
        return chiTietPhieuNhapResponse;
    }

    @GetMapping("chitietphieunhap")
    public List<ChiTietPhieuNhapResponse> getListChiTietPhieuNhap() {
        List<ChiTietPhieuNhap> chiTietPhieuNhapList = chiTietPhieuNhapRepository.findAll();
        List<ChiTietPhieuNhapResponse> chiTietPhieuNhapResponseList = new ArrayList<>();
        chiTietPhieuNhapList.forEach(e -> {
            chiTietPhieuNhapResponseList.add(convertToChiTietPhieuNhapResponse(e));
        });
        return chiTietPhieuNhapResponseList;
    }

    @PostMapping("chitietphieunhap")
    public String postListChiTietPhieuNhap(@RequestBody ChiTietPhieuNhapResponse chiTietPhieuNhapResponse) {
        List<ChiTietPhieuNhap> chiTietPhieuNhapList = chiTietPhieuNhapRepository.findAll();
        for (ChiTietPhieuNhap ctpn : chiTietPhieuNhapList) {
            if (ctpn.getPhieuNhap().getMaPhieuNhap().equals(chiTietPhieuNhapResponse.getMaPhieuNhap())
                    && ctpn.getVatTu().getMaVatTu().equals(chiTietPhieuNhapResponse.getMaVatTu())) {
                return "ID CTPN đã tồn tại";
            }
        }
        if (phieuNhapRepository.checkId(chiTietPhieuNhapResponse.getMaPhieuNhap())==0){
            return "maPN không tồn tại trong bảng phiếu nhập";
        }
        if (vatTuRepository.checkId(chiTietPhieuNhapResponse.getMaVatTu()) == 0) {
            return "maVT không tồn tại trong bảng vật tư";
        }
        chiTietPhieuNhapRepository.insertChiTietPhieuNhap(
                chiTietPhieuNhapResponse.getMaPhieuNhap(),
                chiTietPhieuNhapResponse.getMaVatTu(),
                chiTietPhieuNhapResponse.getSoLuong(),
                chiTietPhieuNhapResponse.getDonGia()
        );
        return "Thêm chi tiết phiếu nhập thành công";
    }

    @PutMapping("chitietphieunhap")
    public String putListChiTietPhieuNhap(@RequestBody ChiTietPhieuNhapResponse chiTietPhieuNhapResponse) {
        if (phieuNhapRepository.checkId(chiTietPhieuNhapResponse.getMaPhieuNhap())==0){
            return "maPN không tồn tại trong bảng phiếu nhập";
        }
        if (vatTuRepository.checkId(chiTietPhieuNhapResponse.getMaVatTu()) == 0) {
            return "maVT không tồn tại trong bảng vật tư";
        }
        List<ChiTietPhieuNhap> chiTietPhieuNhapList = chiTietPhieuNhapRepository.findAll();
        for (ChiTietPhieuNhap ctpn : chiTietPhieuNhapList) {
            if (ctpn.getPhieuNhap().getMaPhieuNhap().equals(chiTietPhieuNhapResponse.getMaPhieuNhap())
                    && ctpn.getVatTu().getMaVatTu().equals(chiTietPhieuNhapResponse.getMaVatTu())) {
                chiTietPhieuNhapRepository.updateChiTietPhieuNhap(
                        chiTietPhieuNhapResponse.getMaPhieuNhap(),
                        chiTietPhieuNhapResponse.getMaVatTu(),
                        chiTietPhieuNhapResponse.getSoLuong(),
                        chiTietPhieuNhapResponse.getDonGia());
                return "Sửa chi tiết phiếu nhập thành công";
            }
        }
        return "ID CTPN không tồn tại";
    }

    @DeleteMapping("chitietphieunhap/{id}")
    public String deleteListChiTietPhieuNhap(@PathVariable(name = "id") Integer id){
        List<ChiTietPhieuNhap> chiTietPhieuNhapList = chiTietPhieuNhapRepository.findAll();
        if (id>=chiTietPhieuNhapList.size()){
            return "Id không tồn tại";
        }
        ChiTietPhieuNhap chiTietPhieuNhap = chiTietPhieuNhapList.get(id);
        chiTietPhieuNhapRepository.deleteChiTietPhieuNhap(
                chiTietPhieuNhap.getPhieuNhap().getMaPhieuNhap(),
                chiTietPhieuNhap.getVatTu().getMaVatTu());
        return "Xóa chi tiết phiếu nhập thành công";
    }
}
