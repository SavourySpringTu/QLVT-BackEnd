package com.example.backend.Controller;

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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<JSONObject>> listPhieuNhap(){
        List<JSONObject> list = phieuNhapService.getAllPhieuNhap();
        return ResponseEntity.ok(list);
    }

}
