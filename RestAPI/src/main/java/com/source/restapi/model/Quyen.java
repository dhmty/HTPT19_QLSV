package com.source.restapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Quyen")
public class Quyen {
    @Id
    @Column(name = "MAQUYEN")
    private String maQuyen;

    @Column(name = "TENQUYEN")
    private String tenQuyen;

    @OneToMany(mappedBy = "quyen", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<TaiKhoan> taiKhoanList;
}
