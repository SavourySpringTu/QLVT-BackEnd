package com.example.backend.Entity;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Getter
@Setter
@RequiredArgsConstructor
public class CTPNID implements Serializable {
    private String mapn;
    private String mavt;
    public CTPNID(String mapn,String mavt){
        this.mapn=mapn;
        this.mavt=mavt;
    }
}
