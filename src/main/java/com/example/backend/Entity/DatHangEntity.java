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
@Table(name="dathang")
@Getter
@Setter
@RequiredArgsConstructor
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "maddh")
public class DatHangEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maddh;
    private LocalDate ngay;
    private String nhacc;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="manv")
    private NhanVienEntity datHangNV;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="makho")
    private KhoEntity datHangKho;

    @OneToMany(mappedBy="datHangCTDDH",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CTDDHEntity> ctddhList;

    @OneToMany(mappedBy="datHangPN",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<PhieuNhapEntity> phieuNhapList;

    public DatHangEntity(long maddh, String nhacc){
        this.maddh = maddh;
        this.ngay = ngay;
    }
}
