package com.example.backend.ServiceImpl;

import com.example.backend.Entity.DatHangEntity;
import com.example.backend.Entity.KhoEntity;
import com.example.backend.Repository.DatHangRepository;
import com.example.backend.Services.DatHangService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DatHangServiceImpl implements DatHangService {
    @Autowired
    private DatHangRepository datHangRepository;
    @Override
    public DatHangEntity findDatHangbyId(Long id) {
        return datHangRepository.findById(id).get();
    }

    @Override
    public List<JSONObject> getDatHangbyQuyenandChiNhanh(String maquyen,String macn) {
        List<DatHangEntity> alldathang = datHangRepository.findAll();
        List<DatHangEntity> dathangbyquyenandchinhanh = new ArrayList<>();
        if(maquyen.equals("Q01")){
            for(DatHangEntity i : alldathang){
                dathangbyquyenandchinhanh.add(i);
            }
        }else{
            if(macn.equals("CN01")==true){
                for(DatHangEntity i : alldathang){
                    if(i.getDatHangKho().getChiNhanhKho().getMacn().equals("CN01")==true){
                        dathangbyquyenandchinhanh.add(i);
                    }
                }
            }else{
                for(DatHangEntity i : alldathang){
                    if(i.getDatHangKho().getChiNhanhKho().getMacn().equals("CN02")==true){
                        dathangbyquyenandchinhanh.add(i);
                    }
                }
            }
        }
        List<JSONObject> dhOj = new ArrayList<>();
        for(DatHangEntity i : dathangbyquyenandchinhanh){
            JSONObject a = new JSONObject();
            a .put("makho",i.getDatHangKho().getMakho());
            a .put("manv",i.getDatHangNV().getManv());
            a .put("nhacc",i.getNhacc());
            a .put("ngay",i.getNgay());
            a .put("maddh",i.getMaddh());
            dhOj.add(a);
        }
        System.gc();
        return dhOj;
    }

    @Override
    public boolean insertDatHang(JSONObject datHang) {
        datHangRepository.save((String) datHang.get("ngay"),(String) datHang.get("nhacc"),(String) datHang.get("makho"),(String) datHang.get("manv"));
        return true;
    }

    @Override
    public boolean updateDatHang(String nhacc, Long maddh) {
        datHangRepository.updateByMaDDH(nhacc,maddh);
        return true;
    }

    @Override
    public boolean deleteDatHangbyMaDDH(Long maddh) {
        datHangRepository.deleteById(maddh);
        return true;
    }
}
