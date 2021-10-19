package com.source.restapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PhieuNhap")
public class PhieuNhap {
    @Id @GeneratedValue
    @Column(name = "MAPN")
    private String maPhieuNhap;

    @Column(name = "NGAY")
    private Date ngay;

    @OneToOne
    @JoinColumn(name = "MassoDDH")
    private DatHang datHang;

    @ManyToOne
    @JoinColumn(name = "MANV")
    private NhanVien nhanVien;

    @OneToMany(mappedBy = "phieuNhap", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<ChiTietPhieuNhap> chiTietPhieuNhapList;
}
