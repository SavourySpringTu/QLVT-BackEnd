package com.example.backend.ServiceImpl;

import com.example.backend.Entity.VatTuEntity;
import com.example.backend.Repository.VatTuRepository;
import com.example.backend.Services.VatTuService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VatTuServiceImpl implements VatTuService {
    @Autowired
    private VatTuRepository vatTuRepository;
    @Override
    public VatTuEntity findVatTubyId(String id) {
        return vatTuRepository.findById(id).orElse(null);
    }

    @Override
    public List<JSONObject> getAllVatTu() {
        List<VatTuEntity> vt = vatTuRepository.findAll();
        List<JSONObject> vtOj = new ArrayList<>();
        for(VatTuEntity i :vt){
            JSONObject a = new JSONObject();
            a .put("soluongton",i.getSoluongton());
            a .put("donvitinh",i.getDonvitinh());
            a .put("tenvt",i.getTenvt());
            a .put("mavt",i.getMavt());
            vtOj.add(a);
        }
        System.gc();
        return vtOj;
    }

    @Override
    public boolean saveVatTu(JSONObject vattu) {
        VatTuEntity vt = new VatTuEntity((String) vattu.get("mavt"),(String) vattu.get("tenvt"),(String) vattu.get("donvitinh"),Integer.valueOf((String) vattu.get("soluongton")));
        vatTuRepository.save(vt);
        return true;
    }


    @Override
    public boolean deleteVatTubyId(String id) {
        VatTuEntity vt = findVatTubyId(id);
        if(vt.getSoluongton()!=0){
            return false;
        }else{
            vatTuRepository.deleteById(id);
            return true;
        }
    }
}
