package com.example.backend.Services;

import com.example.backend.Entity.DatHangEntity;
import org.json.simple.JSONObject;

import java.util.List;

public interface DatHangService {
    DatHangEntity findDatHangbyId(Long id);
    List<JSONObject> getDatHangbyQuyenandChiNhanh(String maquyen,String macn);
    boolean insertDatHang(JSONObject datHang);
    boolean updateDatHang(String nhacc, Long  maddh);
    boolean deleteDatHangbyMaDDH(Long maddh);
}