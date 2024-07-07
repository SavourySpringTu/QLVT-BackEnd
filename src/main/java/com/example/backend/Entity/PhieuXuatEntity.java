package com.example.backend.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="phieuxuat")
@Getter
@Setter
@RequiredArgsConstructor
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "mapx")
public class PhieuXuatEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mapx;
    private LocalDate ngay;

    @ManyToOne(cascade = CascadeType.PERSIST )
    @JoinColumn(name="makh")
    private KhachHangEntity phieuXuatKhachHang;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="manv")
    private NhanVienEntity nhanVienPX;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="makho")
    private KhoEntity khoPX;

    @OneToMany(mappedBy="phieuXuatCTPX",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CTPXEntity> ctpxList;
}
