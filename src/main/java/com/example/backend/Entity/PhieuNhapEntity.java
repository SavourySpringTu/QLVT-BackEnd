package com.example.backend.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="phieunhap")
@Getter
@Setter
@RequiredArgsConstructor
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "mapn")
public class PhieuNhapEntity{
    @Id
    private String mapn;
    private LocalDate ngay;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="manv")
    private NhanVienEntity nhanVienPN;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="makho")
    private KhoEntity khoPN;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="maddh")
    private DatHangEntity datHangPN;

    @OneToMany(mappedBy="phieuNhapCTPN",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CTPNEntity> ctpnList;
}
