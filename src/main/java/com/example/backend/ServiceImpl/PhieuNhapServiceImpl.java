package com.example.backend.ServiceImpl;

import com.example.backend.Entity.DatHangEntity;
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
    public List<JSONObject> getPhieuNhapbyQuyenandChiNhanh(String maquyen,String macn) {
        List<PhieuNhapEntity> allphieunhap = phieuNhapRepository.findAll();
        List<PhieuNhapEntity> phieunhapbyquyenandchinhanh = new ArrayList<>();
        if(maquyen.equals("Q01")){
            for(PhieuNhapEntity i : allphieunhap){
                phieunhapbyquyenandchinhanh.add(i);
            }
        }else{
            if(macn.equals("CN01")==true){
                for(PhieuNhapEntity i : allphieunhap){
                    if(i.getKhoPN().getChiNhanhKho().getMacn().equals("CN01")==true){
                        phieunhapbyquyenandchinhanh.add(i);
                    }
                }
            }else{
                for(PhieuNhapEntity i : allphieunhap){
                    if(i.getKhoPN().getChiNhanhKho().getMacn().equals("CN02")==true){
                        phieunhapbyquyenandchinhanh.add(i);
                    }
                }
            }
        }
        List<JSONObject> dhOj = new ArrayList<>();
        for(PhieuNhapEntity i : phieunhapbyquyenandchinhanh   ){
            JSONObject a = new JSONObject();
            a .put("manv",i.getNhanVienPN().getManv());
            a .put("makho",i.getKhoPN().getMakho());
            a .put("maddh",i.getDatHangPN().getMaddh());
            a .put("ngay",i.getNgay());
            a .put("mapn",i.getMapn());
            dhOj.add(a);
        }
        System.gc();
        return dhOj;
    }
}
