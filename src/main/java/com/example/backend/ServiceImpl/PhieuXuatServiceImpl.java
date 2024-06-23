package com.example.backend.ServiceImpl;

import com.example.backend.Entity.PhieuXuatEntity;
import com.example.backend.Repository.PhieuXuatRepository;
import com.example.backend.Services.PhieuXuatService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PhieuXuatServiceImpl implements PhieuXuatService {
    @Autowired
    private PhieuXuatRepository phieuXuatRepository;

    @Override
    public List<JSONObject> getAllPhieuXuat() {
        List<PhieuXuatEntity> nv = phieuXuatRepository.findAll();
        List<JSONObject> nvOj = new ArrayList<>();
        for(PhieuXuatEntity i :nv){
            JSONObject a = new JSONObject();
            a .put("mapx",i.getMapx());
            a .put("ngay",i.getNgay());
            a .put("makh",i.getPhieuXuatKhachHang().getMakh());
            nvOj.add(a);
        }
        System.gc();
        return nvOj;
    }
}
