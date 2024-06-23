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
    private String maddh;
    private String mavt;
    public CTDDHID(String maddh,String mavt){
        this.maddh=maddh;
        this.mavt=mavt;
    }
}
