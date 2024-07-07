package com.example.backend.Entity;

import com.fasterxml.jackson.annotation.*;
import com.example.backend.Entity.ChiNhanhEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="nhanvien")
@Getter
@Setter
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "manv")
public class NhanVienEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manv;

    private String hoten;
    private String socmnd;
    private String email;
    private String diachi;
    private LocalDate ngaysinh;
    private int luong;
    private boolean trangthai;
    private String matkhau;

    @ManyToOne(cascade = CascadeType.PERSIST )
    @JoinColumn(name="macn")
    private ChiNhanhEntity chiNhanhNV;

    @ManyToOne(cascade = CascadeType.PERSIST )
    @JoinColumn(name="maquyen")
    private VaiTroEntity vaiTroNV;

    @OneToMany(mappedBy="datHangNV",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DatHangEntity> datHangList;

    @OneToMany(mappedBy="nhanVienPN",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<PhieuNhapEntity> phieuNhapList;

    @OneToMany(mappedBy="nhanVienPX",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<PhieuXuatEntity> phieuXuatList;


    public NhanVienEntity() {

    }

}
