package com.source.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(IdChiTietDonDatHang.class)
@Table(name = "CTDDH")
public class ChiTietDonDatHang {
    @Id
    @ManyToOne
    @JoinColumn(name = "MasoDDH")
    private DatHang datHang;

    @Id
    @ManyToOne
    @JoinColumn(name = "MAVT")
    private VatTu vatTu;

    @Column(name = "SOLUONG")
    private Integer soLuong;

    @Column(name = "DONGIA")
    private Float donGia;
}
