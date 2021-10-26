package com.source.restclient.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien {
    private String maSV;
    private String ho;
    private String ten;
    private String email;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date ngaySinh;
    private boolean gioiTinh;
    private String nganh;
    private float GPA;
    private String khoaHoc;
}