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
        List<VatTuEntity> nv = vatTuRepository.findAll();
        List<JSONObject> nvOj = new ArrayList<>();
        for(VatTuEntity i :nv){
            JSONObject a = new JSONObject();
            a .put("soluongton",i.getSOLUONGTON());
            a .put("donvitinh",i.getDONVITINH());
            a .put("tenvt",i.getTENVT());
            a .put("mavt",i.getMAVT());
            nvOj.add(a);
        }
        System.gc();
        return nvOj;
    }

    @Override
    public boolean insertVatTu(VatTuEntity vatTuEntity) {
        return true;
    }

    @Override
    public boolean updateVatTu(VatTuEntity vatTuEntity) {
        return true;
    }

    @Override
    public boolean deleteVatTubyId(String id) {
        vatTuRepository.deleteById(id);
        return true;
    }
}
