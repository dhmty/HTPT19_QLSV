package com.source.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(IdChiTietPhieuXuat.class)
@Table(name = "CTPX")
public class ChiTietPhieuXuat {
    @Id
    @ManyToOne
    @JoinColumn(name = "MAPX")
    private PhieuXuat phieuXuat;

    @Id
    @ManyToOne
    @JoinColumn(name = "MAVT")
    private VatTu vatTu;

    @Column(name = "SOLUONG")
    private Integer soLuong;

    @Column(name = "DONGIA")
    private Float donGia;
}
