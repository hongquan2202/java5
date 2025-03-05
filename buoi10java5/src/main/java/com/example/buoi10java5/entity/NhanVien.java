package com.example.buoi10java5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ma_nhan_vien")
    private String ma;
    @Column(name = "ho_ten")
    private String ten;
    @Column(name = "ngay_sinh")
    private String ngaySinh;
    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;
    @ManyToOne
    @JoinColumn(name = "id_chuc_vu",referencedColumnName = "id")
    private ChucVu chucVu;

}
