package com.example.backend.ServiceImpl;

import com.example.backend.Entity.KhachHangEntity;
import com.example.backend.Repository.KhachHangRepository;
import com.example.backend.Services.KhachHangService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KhachHangSeviceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<JSONObject> listKhachHang() {
        List<KhachHangEntity> kh = khachHangRepository.findAll();
        List<JSONObject> khOj = new ArrayList<>();
        for(KhachHangEntity i :kh){
            JSONObject a = new JSONObject();
            a .put("diachi",i.getDiachi());
            a .put("sdt",i.getSdt());
            a .put("email",i.getEmail());
            a .put("hoten",i.getHoten());
            a .put("makh",i.getMakh());
            khOj.add(a);
        }
        System.gc();
        return khOj;
    }
}
