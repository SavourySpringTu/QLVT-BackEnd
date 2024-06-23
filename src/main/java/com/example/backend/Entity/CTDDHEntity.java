package com.example.backend.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="ctddh", uniqueConstraints={@UniqueConstraint(columnNames ={"maddh","mavt"})})
@Getter
@Setter
@RequiredArgsConstructor
//@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "")
public class CTDDHEntity implements Serializable{
    @AttributeOverrides({
            @AttributeOverride(name="my_maddh",column=@Column(name="maddh")),
            @AttributeOverride(name="my_mavtddh",column=@Column(name="mavt"))
    })
    @EmbeddedId
    private CTDDHID id;

    private int soluong;
    private float dongia;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="mavt",insertable = false, updatable = false)
    private VatTuEntity vatTuCTDDH;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="maddh",insertable=false, updatable=false)
    private DatHangEntity datHangCTDDH;

    public CTDDHEntity(CTDDHID id, int soluong, float dongia) {
        this.id = id;
        this.soluong = soluong;
        this.dongia = dongia;
    }
}
