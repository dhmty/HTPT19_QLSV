package com.source.restapi.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class IdChiTietPhieuXuat implements Serializable {
    private PhieuXuat phieuXuat;
    private VatTu vatTu;
}
