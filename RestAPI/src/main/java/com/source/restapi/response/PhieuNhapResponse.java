package com.source.restapi.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PhieuNhapResponse {
    private String maPhieuNhap;
    private Date ngay;
    private String datHang;
    private String nhanVien;
}
