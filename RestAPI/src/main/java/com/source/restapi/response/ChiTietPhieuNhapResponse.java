package com.source.restapi.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietPhieuNhapResponse {
    private String maPhieuNhap;
    private String maVatTu;
    private Integer soLuong;
    private Float donGia;
}
