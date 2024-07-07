package com.example.backend.ServiceImpl;

import com.example.backend.Entity.ChiNhanhEntity;
import com.example.backend.Entity.NhanVienEntity;
import com.example.backend.Entity.VaiTroEntity;
import com.example.backend.Repository.ChiNhanhRepository;
import com.example.backend.Repository.NhanVienRepository;
import com.example.backend.Repository.VaiTroRepository;
import com.example.backend.Services.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.json.simple.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private ChiNhanhRepository chiNhanhRepository;
    @Autowired
    private VaiTroRepository vaiTroRepository;

    @Override
    public NhanVienEntity login(String cn, Long manv, String password) {
        NhanVienEntity result = nhanVienRepository.findById(manv).orElse(null);
        if(result == null){
            return null;
        }else{
            if(result.getChiNhanhNV().getMacn().equals(cn)==true && result.getMatkhau().equals(password)==true){
                return result;
            }else{
                return null;
            }
        }
    }

    @Override
    public List<JSONObject> getNhanVienbyQuyenandChiNhanh(String maquyen,String chinhanh) {
        List<NhanVienEntity> allNhanVien = nhanVienRepository.findAll();
        List<NhanVienEntity> nhanVienbyQuyenandChiNhanh = new ArrayList<>();
        if(maquyen.equals("Q01")==true){
            for(NhanVienEntity i : allNhanVien){
                nhanVienbyQuyenandChiNhanh.add(i);
            }
        }else{
            if(chinhanh.equals("CN01")==true){
                for(NhanVienEntity i : allNhanVien){
                    if(i.getChiNhanhNV().getMacn().equals("CN01")==true){
                        nhanVienbyQuyenandChiNhanh.add(i);
                    }
                }
            }else{
                for(NhanVienEntity i : allNhanVien){
                    if(i.getChiNhanhNV().getMacn().equals("CN02")==true){
                        nhanVienbyQuyenandChiNhanh.add(i);
                    }
                }
            }
        }
        List<JSONObject> nvOj = new ArrayList<>();
        for(NhanVienEntity i :nhanVienbyQuyenandChiNhanh){
            JSONObject a = new JSONObject();
            a .put("macn",i.getChiNhanhNV().getMacn());
            a .put("diachi",i.getDiachi());
            a .put("email",i.getEmail());
            a .put("luong",i.getLuong());
            a .put("ngaysinh",i.getNgaysinh());
            a .put("socmnd",i.getSocmnd());
            a .put("maquyen",i.getVaiTroNV().getMaquyen());
            a .put("trangthai",i.isTrangthai());
            a .put("hoten",i.getHoten());
            a .put("manv",i.getManv());
            nvOj.add(a);
        }
        System.gc();
        return nvOj;
    }

    @Override
    public boolean insertNhanVien(JSONObject nhanvien) {
        //boolean trangthai = Boolean.valueOf((String) nhanvien.get("trangthai"));
        nhanVienRepository.save((String) nhanvien.get("hoten"),
                (String) nhanvien.get("diachi"),
                (String) nhanvien.get("ngaysinh"),
                (String) nhanvien.get("email"),
                String.valueOf(nhanvien.get("luong")),
                (String) nhanvien.get("socmnd"),
                Boolean.valueOf((String) nhanvien.get("trangthai")),
                (String) nhanvien.get("macn"),
                (String) nhanvien.get("maquyen"),
                "123");
        return true;
    }

    @Override
    public boolean updateNhanVien(JSONObject nhanvien) {
        //boolean trangthai = Boolean.valueOf((String) nhanvien.get("trangthai"));
        nhanVienRepository.updateByMANV(String.valueOf(nhanvien.get("manv")),
                (String) nhanvien.get("hoten"),
                (String) nhanvien.get("diachi"),
                (String) nhanvien.get("ngaysinh"),
                (String) nhanvien.get("email"),
                String.valueOf(nhanvien.get("luong")),
                (String) nhanvien.get("socmnd"),
                Boolean.valueOf((String) nhanvien.get("trangthai")),
                (String) nhanvien.get("macn"),
                (String) nhanvien.get("maquyen"));
        return true;
    }

    @Override
    public boolean deleteNhanVien(Long manv){
        nhanVienRepository.deleteById(manv);
        return true;
    }
}
