package com.source.restapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "NhanVien")
public class NhanVien {
    @Id @GeneratedValue
    @Column(name = "MANV")
    private String maNhanVien;

    @Column(name = "HO")
    private String ho;

    @Column(name = "TEN")
    private String ten;

    @Column(name = "DIACHI")
    private String diaChi;

    @Column(name = "NGAYSINH")
    private Date ngaySinh;

    @Column(name = "LUONG")
    private Float luong;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<TaiKhoan> taiKhoanList;

    @OneToMany(mappedBy = "nhanVien")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<PhieuNhap> phieuNhapList;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<PhieuXuat> phieuXuatList;

    @OneToMany(mappedBy = "nhanVien")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<DatHang> datHangList;

}
