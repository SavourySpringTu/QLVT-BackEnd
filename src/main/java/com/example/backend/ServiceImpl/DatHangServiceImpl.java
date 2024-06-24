package com.example.backend.ServiceImpl;

import com.example.backend.Entity.DatHangEntity;
import com.example.backend.Entity.KhoEntity;
import com.example.backend.Repository.DatHangRepository;
import com.example.backend.Services.DatHangService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DatHangServiceImpl implements DatHangService {
    @Autowired
    private DatHangRepository datHangRepository;
    @Override
    public DatHangEntity findDatHangbyId(String id) {
        return datHangRepository.findById(id).get();
    }

    @Override
    public List<JSONObject> getAllDatHang() {
        List<DatHangEntity> dathang = datHangRepository.findAll();
        List<JSONObject> dhOj = new ArrayList<>();
        for(DatHangEntity i : dathang){
            JSONObject a = new JSONObject();
            a .put("makho",i.getDatHangKho().getMakho());
            a .put("manv",i.getDatHangNV().getManv());
            a .put("nhacc",i.getNhacc());
            a .put("ngay",i.getNgay());
            a .put("maddh",i.getMaddh());
            dhOj.add(a);
        }
        System.gc();
        return dhOj;
    }

    @Override
    public boolean insertDatHang(JSONObject datHang) {
        datHangRepository.save((String) datHang.get("maddh"),(String) datHang.get("ngay"),(String) datHang.get("nhacc"),(String) datHang.get("manv"));
        return true;
    }

    @Override
    public DatHangEntity updateDatHang(DatHangEntity datHang) {
        return datHangRepository.save(datHang);
    }

    @Override
    public void deleteDatHangbyId(String id) {
        datHangRepository.deleteById(id);
    }
}
