package com.example.backend.ServiceImpl;

import com.example.backend.Entity.CTPXEntity;
import com.example.backend.Repository.CTPXRepository;
import com.example.backend.Services.CTPXService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CTPXServiceImpl implements CTPXService {
    @Autowired
    private CTPXRepository ctpxRepository;

    @Override
    public List<JSONObject> getCTPXbyQuyenandChiNhanh(String maquyen, String chinhanh) {
        List<CTPXEntity> allCTPX = ctpxRepository.findAll();
        List<CTPXEntity> CTPXbyQuyenandChiNhanh = new ArrayList<>();
        if(maquyen.equals("Q01")==true){
            for(CTPXEntity i : allCTPX){
                CTPXbyQuyenandChiNhanh.add(i);
            }
        }else{
            if(chinhanh.equals("CN01")==true){
                for(CTPXEntity i : allCTPX){
                    if(i.getPhieuXuatCTPX().getKhoPX().getChiNhanhKho().getMacn().equals("CN01")==true){
                        CTPXbyQuyenandChiNhanh.add(i);
                    }
                }
            }else{
                for(CTPXEntity i : allCTPX){
                    if(i.getPhieuXuatCTPX().getKhoPX().getChiNhanhKho().getMacn().equals("CN02")==true){
                        CTPXbyQuyenandChiNhanh.add(i);
                    }
                }
            }
        }
        List<JSONObject> ctpxOj = new ArrayList<>();
        for(CTPXEntity i :CTPXbyQuyenandChiNhanh){
            JSONObject a = new JSONObject();
            a .put("manv",i.getDongia());
            a .put("makh",i.getSoluong());
            a .put("ngay",i.getVatTuCTPX().getMavt());
            a .put("mapx",i.getId().getMapx());
            ctpxOj.add(a);
        }
        System.gc();
        return ctpxOj;
    }
}
