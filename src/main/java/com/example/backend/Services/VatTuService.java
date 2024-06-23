package com.example.backend.Services;

import com.example.backend.Entity.VatTuEntity;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface VatTuService {
    VatTuEntity findVatTubyId(String mavt);
    List<JSONObject> getAllVatTu();
    boolean saveVatTu(JSONObject vattu);
    boolean deleteVatTubyId(String id);
}
