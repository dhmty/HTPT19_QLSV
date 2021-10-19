package com.source.restapi.model;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TaiKhoan")
public class TaiKhoan {
    @Id
    @Column(name = "TENTAIKHOAN")
    private String tenTaiKhoan;

    @Column(name = "MATKHAU")
    private String matKhau;

    @ManyToOne
    @JoinColumn(name = "MANV", nullable = false)
//    @NotFound(action = NotFoundAction.IGNORE)
//    @Column(name = "MANV")
//    private String maNhanVien;
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "MAQUYEN", nullable = false)
    private Quyen quyen;
}
