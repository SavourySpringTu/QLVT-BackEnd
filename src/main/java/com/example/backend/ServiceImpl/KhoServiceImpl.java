package com.example.backend.ServiceImpl;

import com.example.backend.Entity.KhoEntity;
import com.example.backend.Entity.NhanVienEntity;
import com.example.backend.Repository.KhoRepository;
import com.example.backend.Services.KhoService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KhoServiceImpl implements KhoService {
    @Autowired
    private KhoRepository khoRepository;

    @Override
    public List<JSONObject> listKho() {
        List<KhoEntity> kho = khoRepository.findAll();
        List<JSONObject> khoOj = new ArrayList<>();
        for(KhoEntity i : kho){
            JSONObject a = new JSONObject();
            a .put("chinhanh",i.getChiNhanhKho().getMacn());
            a .put("diachi",i.getDiachi());
            a .put("tenkho",i.getTenkho());
            a .put("makho",i.getMakho());
            khoOj.add(a);
        }
        System.gc();
        return khoOj;
    }
}
