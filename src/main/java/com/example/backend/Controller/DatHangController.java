package com.example.backend.Controller;

import com.example.backend.Entity.DatHangEntity;
import com.example.backend.Services.DatHangService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("backend/api/dathang")
@CrossOrigin(origins = "*")
public class DatHangController {
    @Autowired
    private DatHangService datHangService;

    @RequestMapping(value = "/list", method = RequestMethod.POST )
    public ResponseEntity<List<JSONObject>> listDatHang(@RequestBody JSONObject data){
        List<JSONObject> list = datHangService.getDatHangbyQuyenandChiNhanh((String) data.get("maquyen"),(String) data.get("macn"));
        return ResponseEntity.ok(list);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity insertDatHang (@RequestBody JSONObject datHang){
        boolean result = datHangService.insertDatHang(datHang);
        if(result == true){
            return new ResponseEntity(1, HttpStatus.OK);
        }else{
            return new ResponseEntity(0, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity updateDatHang (@RequestBody JSONObject datHang){
        boolean result = datHangService.updateDatHang((String) datHang.get("nhacc"),Long.parseLong((String)datHang.get("maddh")));
        if(result == true){
            return new ResponseEntity(1, HttpStatus.OK);
        }else{
            return new ResponseEntity(0, HttpStatus.OK);
        }
    }
    @RequestMapping(value="/delete",method = RequestMethod.PUT)
    public ResponseEntity deleteDatHang (@RequestBody JSONObject datHang){
        System.out.println((String)datHang.get("maddh"));
        boolean result = datHangService.deleteDatHangbyMaDDH(Long.parseLong((String)datHang.get("maddh")));
        if(result == true){
            return new ResponseEntity(1, HttpStatus.OK);
        }else{
            return new ResponseEntity(0, HttpStatus.OK);
        }
    }
}
