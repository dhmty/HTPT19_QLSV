package com.source.restapi.model;


import lombok.Data;

import java.io.Serializable;

@Data
public class IdChiTietPhieuNhap implements Serializable {
    private PhieuNhap phieuNhap;
    private VatTu vatTu;
}
