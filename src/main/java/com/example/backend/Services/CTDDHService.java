package com.example.backend.Services;

import com.example.backend.Entity.CTDDHEntity;
import org.json.simple.JSONObject;

import java.util.List;

public interface CTDDHService {
    List<JSONObject> getCTDDHbyQuyenandChiNhanh(String maquyen, String macn);
    boolean insertCTDDH(JSONObject ctddh);
    boolean updateCTDDH(JSONObject ctddh);
    boolean deleteCTDDH(JSONObject ctddh);
}
