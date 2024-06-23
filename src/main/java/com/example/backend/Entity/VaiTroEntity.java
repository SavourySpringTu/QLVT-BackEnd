package com.example.backend.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Data
@Table(name="VAITRO")
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "maquyen")
public class VaiTroEntity {
    @Id
    private String maquyen;
    private String tenquyen;

    public VaiTroEntity(String maquyen) {
        this.maquyen = maquyen;
    }

    @OneToMany(mappedBy="vaiTroNV",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<NhanVienEntity> nhanVienList;
}
