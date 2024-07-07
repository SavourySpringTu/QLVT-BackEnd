package com.example.backend.ServiceImpl;

import com.example.backend.Entity.ChiNhanhEntity;
import com.example.backend.Entity.KhoEntity;
import com.example.backend.Entity.NhanVienEntity;
import com.example.backend.Repository.ChiNhanhRepository;
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
    private ChiNhanhRepository chiNhanhRepository;

    @Override
    public List<JSONObject> getKhobyQuyenandChiNhanh(String maquyen,String macn) {
        List<KhoEntity> allKho = khoRepository.findAll();
        List<KhoEntity> khobyQuyenandChiNhanh = new ArrayList<>();
        if(maquyen.equals("Q01")==true){
            for(KhoEntity i : allKho){
                khobyQuyenandChiNhanh.add(i);
            }
        }else{
            if(macn.equals("CN01")==true){
                for(KhoEntity i : allKho){
                    if(i.getChiNhanhKho().getMacn().equals("CN01")==true){
                        khobyQuyenandChiNhanh.add(i);
                    }
                }
            }else{
                for(KhoEntity i : allKho){
                    if(i.getChiNhanhKho().getMacn().equals("CN02")==true){
                        khobyQuyenandChiNhanh.add(i);
                    }
                }
            }
        }

        List<JSONObject> khoOj = new ArrayList<>();
        for(KhoEntity i : khobyQuyenandChiNhanh){
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
