package com.source.restapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DatHang")
public class DatHang {
    @Id @GeneratedValue
    @Column(name = "MasoDDH")
    private String maSoDDH;

    @Column(name = "NGAY")
    private Date ngay;

    @Column(name = "NhaCC")
    private String nhaCungCap;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MANV")
    private NhanVien nhanVien;

    @OneToOne(mappedBy = "datHang", cascade = CascadeType.ALL)
    private PhieuNhap phieuNhap;

    @OneToMany(mappedBy = "datHang", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<ChiTietDonDatHang> chiTietDonDatHangList;


}
