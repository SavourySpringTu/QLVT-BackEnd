package com.example.backend.Controller;

import com.example.backend.Entity.KhoEntity;
import com.example.backend.Services.KhoService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("backend/api/kho")
@CrossOrigin(origins = "*")
public class KhoController {
    @Autowired
    private KhoService khoService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseEntity<List<JSONObject>> listKho(@RequestBody JSONObject data){
        List<JSONObject> list = khoService.getKhobyQuyenandChiNhanh((String) data.get("maquyen"),(String) data.get("macn"));
        return ResponseEntity.ok(list);
    }
}
