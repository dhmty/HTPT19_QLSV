package com.source.restapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Vattu")
public class VatTu {
    @Id
    @Column(name = "MAVT")
    private String maVatTu;

    @Column(name = "TENVT")
    private String tenVatTu;

    @Column(name = "DVT")
    private String donViTinh;

    @Column(name = "SOLUONGTON")
    private Integer soLuongTon;

    @OneToMany(mappedBy = "vatTu", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<ChiTietDonDatHang> chiTietDonDatHangList;

    @OneToMany(mappedBy = "vatTu", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<ChiTietPhieuNhap> chiTietPhieuNhapList;

    @OneToMany(mappedBy = "vatTu", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<ChiTietPhieuXuat> chiTietPhieuXuatList;

}
