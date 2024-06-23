package com.example.backend.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="ctpn")
@Getter
@Setter
@RequiredArgsConstructor
public class CTPNEntity{
    @AttributeOverrides({
            @AttributeOverride(name="my_mapn",column =@Column(name="mapn")),
            @AttributeOverride(name="my_mavtpn",column =@Column(name="mavt")),
    })
    @EmbeddedId
    private CTPNID id;
    private int soluong;
    private float dongia;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="mavt",insertable = false, updatable = false)
    private VatTuEntity vatTuCTPN;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="mapn",insertable = false, updatable = false)
    private PhieuNhapEntity phieuNhapCTPN;
}
