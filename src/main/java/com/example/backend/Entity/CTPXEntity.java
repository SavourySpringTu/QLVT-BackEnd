package com.example.backend.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="ctpx")
@Getter
@Setter
@RequiredArgsConstructor
public class CTPXEntity implements Serializable {
    @AttributeOverrides({
            @AttributeOverride(name="my_mapx",column =@Column(name="mapx")),
            @AttributeOverride(name="my_mavtpx",column =@Column(name="mavt")),
    })
    @EmbeddedId CTPXID id;
    private int soluong;
    private float dongia;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="mavt",insertable = false, updatable = false)
    private VatTuEntity vatTuCTPX;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="mapx",insertable=false, updatable=false)
    private PhieuXuatEntity phieuXuatCTPX;

}
