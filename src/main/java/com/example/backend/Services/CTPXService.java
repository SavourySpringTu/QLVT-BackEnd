package com.example.backend.Services;

import org.json.simple.JSONObject;

import java.util.List;

public interface CTPXService {
    List<JSONObject> getCTPXbyQuyenandChiNhanh(String quyen, String chinhanh);
}
