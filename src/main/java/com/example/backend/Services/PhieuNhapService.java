package com.example.backend.Services;

import com.example.backend.Entity.PhieuNhapEntity;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

import java.util.List;

public interface PhieuNhapService {
    PhieuNhapEntity findPhieuNhapbyId(String id);
    List<JSONObject> getAllPhieuNhap();
    PhieuNhapEntity addPhieuNhap(PhieuNhapEntity phieuNhap);
    PhieuNhapEntity updatePhieuNhap(PhieuNhapEntity phieuNhap);
    void deletePhieuNhapbyId(String id);
}
