package com.source.restapi.controller;

import com.source.restapi.model.DatHang;
import com.source.restapi.repository.impl.DatHangRepository;
import com.source.restapi.repository.impl.NhanVienRepository;
import com.source.restapi.response.DatHangResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class RestAPIDatHangController {

    @Autowired
    @Qualifier("dathang")
    private DatHangRepository datHangRepository;
    @Autowired
    @Qualifier("nhanvien")
    private NhanVienRepository nhanVienRepository;

    public DatHangResponse convertToDatHangResponse(DatHang datHang){
        return new DatHangResponse(
                datHang.getMaSoDDH(),
                datHang.getNgay(),
                datHang.getNhaCungCap(),
                datHang.getNhanVien().getMaNhanVien()
        );
    }

    @GetMapping("dathang")
    private List<DatHangResponse> getListDatHang(){
        List<DatHangResponse> datHangResponseList = new ArrayList<>();
        datHangRepository.findAll().forEach(e->{
            datHangResponseList.add(convertToDatHangResponse(e));
        });
        return  datHangResponseList;
    }

    @PostMapping("dathang")
    private String postListDatHang(@RequestBody DatHangResponse datHangResponse){
        if (nhanVienRepository.checkId(datHangResponse.getMaNhanVien())==0){
            return "maNhanVien không tồn tại trong bảng nhân viên";
        }
        datHangRepository.insertDatHang(
                datHangResponse.getNgay(),
                datHangResponse.getNhaCungCap(),
                datHangResponse.getMaNhanVien()
        );
        return "Thêm đơn đặt hàng thành công";
    }

    @PutMapping("dathang")
    private String putListDatHang(@RequestBody DatHangResponse datHangResponse){
        if(datHangRepository.checkId(datHangResponse.getMaSoDDH())==0){
            return "maSoDDH không tồn tại";
        }
        if (nhanVienRepository.checkId(datHangResponse.getMaNhanVien())==0){
            return "maNhanVien không tồn tại trong bảng nhân viên";
        }
        datHangRepository.updateDatHang(
                datHangResponse.getMaSoDDH(),
                datHangResponse.getNgay(),
                datHangResponse.getNhaCungCap(),
                datHangResponse.getMaNhanVien()
        );
        return "Sửa đơn đặt hàng thành công";
    }

    @DeleteMapping("dathang/{id}")
    public String deleteListDatHang(@PathVariable(name = "id") Integer id){
        List<DatHang> datHangList = datHangRepository.findAll();
        if (id>=datHangList.size()){
            return "Id không tồn tại";
        }
        DatHang datHang = datHangList.get(id);
        datHangRepository.deleteDatHang(datHang.getMaSoDDH());
        return "Xóa đơn đặt hàng thành công";
    }
}
