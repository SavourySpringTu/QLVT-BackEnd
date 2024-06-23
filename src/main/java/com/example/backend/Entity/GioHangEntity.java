package com.example.backend.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="giohang")
@Getter
@Setter
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "magh")
public class GioHangEntity {
    @Id
    private int magh;

    @OneToOne(mappedBy = "khachHangGioHang")
    private KhachHangEntity khachHang;

    @OneToMany(mappedBy="gioHangCTGH",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CTGHEntity> ctghList;
}
