package com.source.restapi.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SinhVien")
public class SinhVien {
    @Id
    private String maSV;
    private String ho;
    private String ten;
    private String email;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date ngaySinh;
    private boolean gioiTinh;
    private String nganh;
    private float GPA;
    private String khoaHoc;
}
