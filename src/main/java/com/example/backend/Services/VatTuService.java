package com.example.backend.Services;

import com.example.backend.Entity.VatTuEntity;
import org.json.simple.JSONObject;

import java.util.List;

public interface VatTuService {
    VatTuEntity findVatTubyId(String id);
    List<JSONObject> getAllVatTu();

    boolean insertVatTu(VatTuEntity vatTuEntity);
    boolean updateVatTu(VatTuEntity vatTuEntity);
    boolean deleteVatTubyId(String id);
}
