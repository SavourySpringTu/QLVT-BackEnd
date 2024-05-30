package com.example.backend.Services;

import com.example.backend.Entity.NhanVienEntity;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NhanVienService {
    NhanVienEntity login(String cn,Long manv,String password);
    List<JSONObject> listNhanVien();
    boolean insertNhanVien(JSONObject nv);
    boolean updateNhanVien(JSONObject nv);
    boolean deleteNhanVien(Long manv);
}
