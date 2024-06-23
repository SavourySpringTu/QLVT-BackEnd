package com.example.backend.ServiceImpl;

import com.example.backend.Entity.CTPNEntity;
import com.example.backend.Entity.CTPNID;
import com.example.backend.Entity.VatTuEntity;
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
    public List<JSONObject> getAllCTPN() {
        List<CTPNEntity> ctpn = ctpnRepository.findAll();
        List<JSONObject> ctpnOj = new ArrayList<>();
        for(CTPNEntity i : ctpn){
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
    public CTPNEntity addCTPN(CTPNEntity ctpn) {
        return ctpnRepository.save(ctpn);
    }

    @Override
    public CTPNEntity updateCTPN(CTPNEntity ctpn) {
        return ctpnRepository.save(ctpn);
    }

    @Override
    public void deleteCTPNbyId(String mapn, String mavt) {
        CTPNID id = new CTPNID(mapn,mavt);
        ctpnRepository.deleteById(id);
    }
}
