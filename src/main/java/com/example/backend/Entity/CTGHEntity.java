package com.example.backend.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ctgh")
@Getter
@Setter
public class CTGHEntity {
    @AttributeOverrides({
            @AttributeOverride(name="maghgh",column =@Column(name="magh")),
            @AttributeOverride(name="mavtgh",column =@Column(name="mavt")),
    })
    @EmbeddedId CTGHID id;
    private int soluong;
    private float dongia;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="mavt",insertable = false, updatable = false)
    private VatTuEntity vatTuCTGH;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="magh",insertable=false, updatable=false)
    private GioHangEntity gioHangCTGH;

}
