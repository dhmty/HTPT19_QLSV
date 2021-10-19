package com.source.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@IdClass(IdChiTietPhieuNhap.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CTPN")
public class ChiTietPhieuNhap {
    @Id
    @ManyToOne
    @JoinColumn(name = "MAPN")
    private PhieuNhap phieuNhap;

    @Id
    @ManyToOne
    @JoinColumn(name = "MAVT")
    private VatTu vatTu;

    @Column(name = "SOLUONG")
    private Integer soLuong;

    @Column(name = "DONGIA")
    private Float donGia;
}
