package com.example.backend.Controller;

import com.example.backend.Entity.NhanVienEntity;
import com.example.backend.Entity.PhieuNhapEntity;
import com.example.backend.Services.PhieuNhapService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/backend/api/phieunhap")
@CrossOrigin(origins = "*")
public class PhieuNhapController{
    @Autowired
    private PhieuNhapService phieuNhapService;

    @RequestMapping(value="/list", method = RequestMethod.POST)
    public ResponseEntity<List<JSONObject>> listPhieuNhap(@RequestBody JSONObject data) {
        List<JSONObject> list = phieuNhapService.getPhieuNhapbyQuyenandChiNhanh((String) data.get("maquyen"),(String) data.get("macn"));
        return ResponseEntity.ok(list);
    }

}
