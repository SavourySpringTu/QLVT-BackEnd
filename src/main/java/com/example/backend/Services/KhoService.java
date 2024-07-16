package com.example.backend.Services;

import com.example.backend.Entity.KhoEntity;
import org.json.simple.JSONObject;

import java.util.List;

public interface KhoService {
    List<JSONObject> getKhobyQuyenandChiNhanh(String maquyen,String macn);
    boolean insertKho(JSONObject kho);
    boolean updateKho(JSONObject kho);
}
