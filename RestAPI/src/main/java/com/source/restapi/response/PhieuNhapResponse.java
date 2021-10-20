package com.source.restapi.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhieuNhapResponse {
    private String maPhieuNhap;
    private Date ngay;
    private String maSoDonDatHang;
    private String maNhanVien;
}
