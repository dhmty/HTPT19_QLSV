package com.source.restclient.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien {
    @NotBlank(message = "Mã Sinh Viên Không Được Bỏ Trống")
    private String maSV;
    @NotBlank(message = "Họ Sinh Viên Không Được Bỏ Trống")
    private String ho;
    @NotBlank(message = "Tên Sinh Viên Không Được Bỏ Trống")
    private String ten;
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email chưa đúng định dạng")
    private String email;
    @NotNull(message = "Ngày Sinh Không Được Bỏ Trống")
    @Past(message = "Ngày Sinh không hợp lệ")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date ngaySinh;
    private boolean gioiTinh;
    @NotBlank(message = "Ngành Học Không Được Bỏ Trống")
    private String nganh;
    @DecimalMin(value = "0.0",message = "ERROR: GPA >=0.0 and GPA<=4.0")
    @DecimalMax(value = "4.0",message = "ERROR: GPA >=0.0 and GPA<=4.0")
    private float GPA;
    @Pattern(regexp = "[0-9]{1,4}-[0-9]{1,4}",message = "Khóa Học phải đúng định dạng yyyy-yyyy VD:2018-2023")
    private String khoaHoc;
}