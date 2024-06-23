package com.example.backend.ServiceImpl;

import com.example.backend.Entity.PhieuNhapEntity;
import com.example.backend.Entity.VatTuEntity;
import com.example.backend.Repository.PhieuNhapRepository;
import com.example.backend.Services.PhieuNhapService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhieuNhapServiceImpl implements PhieuNhapService {
    @Autowired
    private PhieuNhapRepository phieuNhapRepository;
    @Override
    public PhieuNhapEntity findPhieuNhapbyId(String id) {
        return phieuNhapRepository.findById(id).get();
    }

    @Override
    public List<JSONObject> getAllPhieuNhap() {
        List<PhieuNhapEntity> pn = phieuNhapRepository.findAll();
        List<JSONObject> pnOj = new ArrayList<>();
        for(PhieuNhapEntity i :pn){
            JSONObject a = new JSONObject();
            a .put("mapn",i.getMapn());
            a .put("ngay",i.getNgay());
            pnOj.add(a);
        }
        System.gc();
        return pnOj;
    }

    @Override
    public PhieuNhapEntity addPhieuNhap(PhieuNhapEntity phieuNhap) {
        return phieuNhapRepository.save(phieuNhap);
    }

    @Override
    public PhieuNhapEntity updatePhieuNhap(PhieuNhapEntity phieuNhap) {
        return phieuNhapRepository.save(phieuNhap);
    }

    @Override
    public void deletePhieuNhapbyId(String id) {
        phieuNhapRepository.deleteById(id);
    }
}
