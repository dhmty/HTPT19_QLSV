package com.source.restapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PhieuXuat")
public class PhieuXuat {
    @Id @GeneratedValue
    @Column(name = "MAPX")
    private String maPhieuXuat;

    @Column(name = "NGAY")
    private Date ngay;

    @Column(name = "HOTENKH")
    private String hoTenKhachHang;

    @ManyToOne
    @JoinColumn(name = "MANV")
    private NhanVien nhanVien;

    @OneToMany(mappedBy = "phieuXuat", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<ChiTietPhieuXuat> chiTietPhieuXuatList;
}
