package com.example.backend.Services;

import org.json.simple.JSONObject;

import java.util.List;

public interface PhieuXuatService {
    List<JSONObject> getPhieuXuatbyQuyenandChiNhanh(String quyen,String chinhanh);
}
