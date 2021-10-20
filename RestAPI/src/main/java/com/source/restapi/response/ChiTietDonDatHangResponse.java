package com.source.restapi.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietDonDatHangResponse {
    private String maSoDDH;
    private String maVatTu;
    private Integer soLuong;
    private Float donGia;
}
