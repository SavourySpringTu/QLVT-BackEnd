package com.example.backend.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Getter
@Setter
@RequiredArgsConstructor
public class CTDDHID implements Serializable {
    private Long maddh;
    private String mavt;
    public CTDDHID(Long maddh,String mavt){
        this.maddh=maddh;
        this.mavt=mavt;
    }
}
