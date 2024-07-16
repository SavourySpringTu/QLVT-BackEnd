package com.example.backend.ServiceImpl;

import com.example.backend.Entity.CTPNEntity;
import com.example.backend.Repository.CTPNRepository;
import com.example.backend.Services.CTPNService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CTPNServiceImpl implements CTPNService {
    @Autowired
    private CTPNRepository ctpnRepository;

    @Override
    public List<JSONObject> getAllCTPN(String maquyen,String chinhanh) {
        List<CTPNEntity> allCTPN = ctpnRepository.findAll();
        List<CTPNEntity> ctpnbyQuyenandChiNhanh = new ArrayList<>();
        if(maquyen.equals("Q01")==true){
            for(CTPNEntity i : allCTPN){
                ctpnbyQuyenandChiNhanh.add(i);
            }
        }else{
            if(chinhanh.equals("CN01")==true){
                for(CTPNEntity i : allCTPN){
                    if(i.getPhieuNhapCTPN().getKhoPN().getChiNhanhKho().getMacn().equals("CN01")==true){
                        ctpnbyQuyenandChiNhanh.add(i);
                    }
                }
            }else{
                for(CTPNEntity i : allCTPN){
                    if(i.getPhieuNhapCTPN().getKhoPN().getChiNhanhKho().getMacn().equals("CN02")==true){
                        ctpnbyQuyenandChiNhanh.add(i);
                    }
                }
            }
        }
        List<JSONObject> ctpnOj = new ArrayList<>();
        for(CTPNEntity i : ctpnbyQuyenandChiNhanh){
            JSONObject a = new JSONObject();
            a .put("mapn",i.getId().getMapn());
            a .put("mavt",i.getId().getMavt());
            a .put("soluong",i.getSoluong());
            a .put("dongia",i.getDongia());
            ctpnOj.add(a);
        }
        System.gc();
        return ctpnOj;
    }
    @Override
    public boolean insertCTPN(JSONObject ctpn) {
        ctpnRepository.insertCTPN((String) ctpn.get("mapn"),(String) ctpn.get("mavt"),(String) ctpn.get("soluong"),(String) ctpn.get("dongia"));
        return true;
    }

    @Override
    public CTPNEntity updateCTPN(CTPNEntity ctpn) {
        return null;
    }

    @Override
    public void deleteCTPNbyId(Long mapn, String mavt) {

    }
}
