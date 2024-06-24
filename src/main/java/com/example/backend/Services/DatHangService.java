package com.example.backend.Services;

import com.example.backend.Entity.DatHangEntity;
import org.json.simple.JSONObject;

import java.util.List;

public interface DatHangService {
    DatHangEntity findDatHangbyId(String id);
    List<JSONObject> getAllDatHang();
    boolean insertDatHang(JSONObject datHang);
    DatHangEntity updateDatHang(DatHangEntity datHang);
    void deleteDatHangbyId(String id);
}