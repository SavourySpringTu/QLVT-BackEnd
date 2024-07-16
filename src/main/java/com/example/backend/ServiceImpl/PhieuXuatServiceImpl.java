package com.example.backend.ServiceImpl;

import com.example.backend.Entity.NhanVienEntity;
import com.example.backend.Entity.PhieuXuatEntity;
import com.example.backend.Repository.PhieuXuatRepository;
import com.example.backend.Services.PhieuXuatService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhieuXuatServiceImpl implements PhieuXuatService {
    @Autowired
    private PhieuXuatRepository phieuXuatRepository;

    @Override
    public List<JSONObject> getPhieuXuatbyQuyenandChiNhanh(String maquyen,String chinhanh) {
        List<PhieuXuatEntity> allPhieuXuat = phieuXuatRepository.findAll();
        List<PhieuXuatEntity> phieuXuatbyQuyenandChiNhanh = new ArrayList<>();
        if(maquyen.equals("Q01")==true){
            for(PhieuXuatEntity i : allPhieuXuat){
                phieuXuatbyQuyenandChiNhanh.add(i);
            }
        }else{
            if(chinhanh.equals("CN01")==true){
                for(PhieuXuatEntity i : allPhieuXuat){
                    if(i.getKhoPX().getChiNhanhKho().getMacn().equals("CN01")==true){
                        phieuXuatbyQuyenandChiNhanh.add(i);
                    }
                }
            }else{
                for(PhieuXuatEntity i : allPhieuXuat){
                    if(i.getKhoPX().getChiNhanhKho().getMacn().equals("CN02")==true){
                        phieuXuatbyQuyenandChiNhanh.add(i);
                    }
                }
            }
        }
        List<JSONObject> pxOj = new ArrayList<>();
        for(PhieuXuatEntity i :phieuXuatbyQuyenandChiNhanh){
            JSONObject a = new JSONObject();
            a .put("makho",i.getKhoPX().getMakho());
            a .put("manv",i.getNhanVienPX().getManv());
            a .put("makh",i.getPhieuXuatKhachHang().getMakh());
            a .put("ngay",i.getNgay());
            a .put("mapx",i.getMapx());
            pxOj.add(a);
        }
        System.gc();
        return pxOj;
    }
}
