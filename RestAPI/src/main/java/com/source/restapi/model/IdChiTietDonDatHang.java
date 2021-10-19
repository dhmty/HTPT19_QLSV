package com.source.restapi.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class IdChiTietDonDatHang implements Serializable {
    private DatHang datHang;
    private VatTu vatTu;
}
