package com.example.backend.Services;

import com.example.backend.Entity.PhieuNhapEntity;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

import java.util.List;

public interface PhieuNhapService {
    List<JSONObject> getPhieuNhapbyQuyenandChiNhanh(String maquyen,String macn);
}
