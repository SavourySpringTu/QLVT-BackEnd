package com.example.backend.Entity;

import com.example.backend.Entity.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="khachhang")
@Getter
@Setter
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "makh")
public class KhachHangEntity {
    @Id
    private long makh;
    private String hoten;
    private String email;
    private String sdt;
    private String diachi;
    private String matkhau;

    @OneToMany(mappedBy="phieuXuatKhachHang",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<PhieuXuatEntity> phieuXuatList;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="magh")
    private GioHangEntity khachHangGioHang;
}
