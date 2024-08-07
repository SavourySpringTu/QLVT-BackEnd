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
public class CTGHID implements Serializable {
    private String mavt;
    private Long magh;
    public CTGHID(Long magh,String mavt){
        this.magh=magh;
        this.mavt=mavt;
    }
}
