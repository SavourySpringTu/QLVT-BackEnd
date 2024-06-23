package com.example.backend.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="vattu")
@Getter
@Setter
@RequiredArgsConstructor
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "mavt")
public class VatTuEntity implements Serializable{
    @Id
    private String mavt;
    private String tenvt;
    private String donvitinh;
    private int soluongton;

    @OneToOne(mappedBy = "vatTuCTDDH")
    private CTDDHEntity ctddh;

    @OneToOne(mappedBy = "vatTuCTPN")
    private CTPNEntity ctpn;

    @OneToOne(mappedBy = "vatTuCTGH")
    private CTGHEntity ctgh;

    @OneToOne(mappedBy = "vatTuCTPX")
    private CTPXEntity ctpx;

    public VatTuEntity(String mavt, String tenvt, String donvitinh, int soluongton) {
        this.mavt = mavt;
        this.tenvt = tenvt;
        this.donvitinh = donvitinh;
        this.soluongton = soluongton;
    }
}
