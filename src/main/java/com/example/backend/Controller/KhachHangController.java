package com.example.backend.Controller;

import com.example.backend.Services.KhachHangService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("backend/api/khachhang")
@CrossOrigin(origins = "*")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<List<JSONObject>> listKhachHang(){
        List<JSONObject> list = khachHangService.listKhachHang();
        return ResponseEntity.ok(list);
    }
}
