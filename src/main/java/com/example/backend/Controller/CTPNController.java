package com.example.backend.Controller;

import com.example.backend.Entity.CTPNEntity;
import com.example.backend.Services.CTPNService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/backend/api/chitietphieunhap")
@CrossOrigin(origins = "*")
public class CTPNController {
    @Autowired
    private CTPNService ctpnService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<JSONObject>> listCTPN(){
        List<JSONObject> list = ctpnService.getAllCTPN();
        return ResponseEntity.ok(list);
    }
}
