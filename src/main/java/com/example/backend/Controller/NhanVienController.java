package com.example.backend.Controller;

import com.example.backend.Entity.NhanVienEntity;
import com.example.backend.Services.NhanVienService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;

import java.util.List;

@Controller
@RequestMapping("backend/api/nhanvien")
@CrossOrigin(origins = "*")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public ResponseEntity<NhanVienEntity> login(@RequestBody NhanVienEntity nhanvien){
        NhanVienEntity result = nhanVienService.login(String.valueOf(nhanvien.getChiNhanhNV().getMACN()),nhanvien.getMANV(),nhanvien.getMATKHAU());
        return new ResponseEntity(result, HttpStatus.OK);
    }
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public ResponseEntity<List<JSONObject>> listNhanVien() {
        List<JSONObject> list = nhanVienService.listNhanVien();
        return ResponseEntity.ok(list);
    }
    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public ResponseEntity saveNhanVien(@RequestBody JSONObject nhanvien){
        boolean result = nhanVienService.insertNhanVien(nhanvien);
        if(result == true){
            return new ResponseEntity(0, HttpStatus.OK);
        }else{
            return new ResponseEntity(1, HttpStatus.OK);
        }
    }
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public ResponseEntity updateNhanVien(@RequestBody JSONObject nhanvien){
        boolean result = nhanVienService.updateNhanVien(nhanvien);
        if(result == true){
            return new ResponseEntity(0, HttpStatus.OK);
        }else{
            return new ResponseEntity(1, HttpStatus.OK);
        }
    }
    @RequestMapping(value="/delete",method = RequestMethod.PUT)
    public ResponseEntity deleteNhanVien(@RequestBody JSONObject nhanvien){
        boolean result = nhanVienService.deleteNhanVien( Long.parseLong((String) nhanvien.get("manv")));
        if(result==true) {
            return new ResponseEntity(0, HttpStatus.OK);
        }else{
            return new ResponseEntity(1, HttpStatus.OK);
        }
    }
}