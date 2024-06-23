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
public class CTPXID implements Serializable {
    private String mapx;
    private String mavt;
    public CTPXID(String mapx,String mavt){
        this.mavt=mavt;
        this.mapx=mapx;
    }
}
