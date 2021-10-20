package com.source.restapi.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatHangResponse {
    private String maSoDDH;
    private Date ngay;
    private String nhaCungCap;
    private String maNhanVien;
}
