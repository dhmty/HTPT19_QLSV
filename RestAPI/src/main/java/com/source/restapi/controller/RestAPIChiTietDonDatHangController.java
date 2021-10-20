package com.source.restapi.controller;

import com.source.restapi.model.ChiTietDonDatHang;
import com.source.restapi.repository.impl.ChiTietDonDatHangRepository;
import com.source.restapi.repository.impl.DatHangRepository;
import com.source.restapi.repository.impl.VatTuRepository;
import com.source.restapi.response.ChiTietDonDatHangResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class RestAPIChiTietDonDatHangController {
    @Autowired
    @Qualifier("chitietdondathang")
    private ChiTietDonDatHangRepository chiTietDonDatHangRepository;
    @Autowired
    @Qualifier("vattu")
    private VatTuRepository vatTuRepository;
    @Autowired
    @Qualifier("dathang")
    private DatHangRepository datHangRepository;

    public ChiTietDonDatHangResponse convertToCTDDHResponse(ChiTietDonDatHang ctddh) {
        return new ChiTietDonDatHangResponse(
                ctddh.getDatHang().getMaSoDDH(),
                ctddh.getVatTu().getMaVatTu(),
                ctddh.getSoLuong(),
                ctddh.getDonGia());
    }

    @GetMapping("chitietdondathang")
    public List<ChiTietDonDatHangResponse> getListChiTietDonDatHang() {
        List<ChiTietDonDatHang> chiTietDonDatHangList = chiTietDonDatHangRepository.findAll();
        List<ChiTietDonDatHangResponse> chiTietDonDatHangResponseList = new ArrayList<>();
        chiTietDonDatHangList.forEach(e -> {
            chiTietDonDatHangResponseList.add(convertToCTDDHResponse(e));
        });
        return chiTietDonDatHangResponseList;
    }

    @PostMapping("chitietdondathang")
    public String postListChiTietDonDatHang(@RequestBody ChiTietDonDatHangResponse chiTietDonDatHangResponse) {
        List<ChiTietDonDatHang> chiTietDonDatHangList = chiTietDonDatHangRepository.findAll();
        for (ChiTietDonDatHang ctddh : chiTietDonDatHangList) {
            if (ctddh.getDatHang().getMaSoDDH().equals(chiTietDonDatHangResponse.getMaSoDDH())
                    && ctddh.getVatTu().getMaVatTu().equals(chiTietDonDatHangResponse.getMaVatTu())) {
                return "ID CTDDH đã tồn tại";
            }
        }
        if (datHangRepository.checkId(chiTietDonDatHangResponse.getMaSoDDH())==0){
            return "maSoDDH không tồn tại trong bảng đặt hàng";
        }
        if (vatTuRepository.checkId(chiTietDonDatHangResponse.getMaVatTu()) == 0) {
            return "maVT không tồn tại trong bảng vật tư";
        }
        chiTietDonDatHangRepository.insertChiTietDonDatHang(
                chiTietDonDatHangResponse.getMaSoDDH(),
                chiTietDonDatHangResponse.getMaVatTu(),
                chiTietDonDatHangResponse.getSoLuong(),
                chiTietDonDatHangResponse.getDonGia()
        );
        return "Thêm chi tiết đơn đặt hàng thành công";
    }

    @PutMapping("chitietdondathang")
    public String putListChiTietDonDatHang(@RequestBody ChiTietDonDatHangResponse chiTietDonDatHangResponse) {
        if (datHangRepository.checkId(chiTietDonDatHangResponse.getMaSoDDH())==0){
            return "maSoDDH không tồn tại trong bảng đặt hàng";
        }
        if (vatTuRepository.checkId(chiTietDonDatHangResponse.getMaVatTu()) == 0) {
            return "maVT không tồn tại trong bảng vật tư";
        }
        List<ChiTietDonDatHang> chiTietDonDatHangList = chiTietDonDatHangRepository.findAll();
        for (ChiTietDonDatHang ctddh : chiTietDonDatHangList) {
            if (ctddh.getDatHang().getMaSoDDH().equals(chiTietDonDatHangResponse.getMaSoDDH())
                    && ctddh.getVatTu().getMaVatTu().equals(chiTietDonDatHangResponse.getMaVatTu())) {

                chiTietDonDatHangRepository.updateChiTietDonDatHang(
                        chiTietDonDatHangResponse.getMaSoDDH(),
                        chiTietDonDatHangResponse.getMaVatTu(),
                        chiTietDonDatHangResponse.getSoLuong(),
                        chiTietDonDatHangResponse.getDonGia()
                );
                return "Sửa chi tiết đơn đặt hàng thành công";
            }
        }
        return "ID CTDDH không tồn tại";
    }

    @DeleteMapping("chitietdondathang/{id}")
    public String deleteListChiTietDonDatHang(@PathVariable(name = "id") Integer id){
        List<ChiTietDonDatHang> chiTietDonDatHangList = chiTietDonDatHangRepository.findAll();
        if (id>=chiTietDonDatHangList.size()){
            return "Id không tồn tại";
        }
        ChiTietDonDatHang chiTietDonDatHang = chiTietDonDatHangList.get(id);
        chiTietDonDatHangRepository.deleteChiTietDonDatHang(
                chiTietDonDatHang.getDatHang().getMaSoDDH(),
                chiTietDonDatHang.getVatTu().getMaVatTu());
        return "Xóa chi tiết đơn đặt hàng thành công";
    }
}
