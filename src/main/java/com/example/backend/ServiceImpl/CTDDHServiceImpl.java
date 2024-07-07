package com.example.backend.ServiceImpl;

import com.example.backend.Entity.CTDDHEntity;
import com.example.backend.Entity.CTDDHID;
import com.example.backend.Entity.KhoEntity;
import com.example.backend.Repository.CTDDHRepository;
import com.example.backend.Services.CTDDHService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CTDDHServiceImpl implements CTDDHService {
    @Autowired
    private CTDDHRepository ctddhRepository;


    @Override
    public List<JSONObject> getCTDDHbyQuyenandChiNhanh(String maquyen,String macn) {
        List<CTDDHEntity> allCTDDH = ctddhRepository.findAll();
        List<CTDDHEntity> ctddhbyQuyenandChiNhanh = new ArrayList<>();
        if(maquyen.equals("Q01")==true){
            for(CTDDHEntity i:allCTDDH){
                ctddhbyQuyenandChiNhanh.add(i);
            }
        }else{
            if(macn.equals("CN01")==true){
                for(CTDDHEntity i:allCTDDH){
                    if(i.getDatHangCTDDH().getDatHangKho().getChiNhanhKho().getMacn().equals("CN01")==true){
                        ctddhbyQuyenandChiNhanh.add(i);
                    }
                }
            }else{
                for(CTDDHEntity i:allCTDDH){
                    if(i.getDatHangCTDDH().getDatHangKho().getChiNhanhKho().getMacn().equals("CN02")==true){
                        ctddhbyQuyenandChiNhanh.add(i);
                    }
                }
            }
        }
        List<JSONObject> ctddhOj = new ArrayList<>();
        for(CTDDHEntity i : ctddhbyQuyenandChiNhanh){
            JSONObject a = new JSONObject();
            a .put("dongia",i.getDongia());
            a .put("soluong",i.getSoluong());
            a .put("maddh",i.getId().getMaddh());
            a .put("mavt",i.getId().getMavt());
            ctddhOj.add(a);
        }
        System.gc();
        return ctddhOj;
    }

    @Override
    public boolean insertCTDDH(JSONObject ctddh) {
        ctddhRepository.save((String) ctddh.get("maddh"),(String) ctddh.get("mavt"),(String) ctddh.get("soluong"),(String) ctddh.get("dongia"));
        return true;
    }
}
