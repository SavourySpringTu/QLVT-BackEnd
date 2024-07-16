package com.example.backend.Controller;

import com.example.backend.Entity.CTPNEntity;
import com.example.backend.Services.CTPNService;
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
@RequestMapping("/backend/api/chitietphieunhap")
@CrossOrigin(origins = "*")
public class CTPNController {
    @Autowired
    private CTPNService ctpnService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseEntity<List<JSONObject>> listCTPN(@RequestBody JSONObject data){
        List<JSONObject> list = ctpnService.getAllCTPN((String)data.get("maquyen"),(String)data.get("macn"));
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseEntity addCTPN(@RequestBody JSONObject data){
        boolean result = ctpnService.insertCTPN(data);
        if(result==true){
            return new ResponseEntity(1,HttpStatus.OK);
        }else{
            return new ResponseEntity(0,HttpStatus.OK);
        }
    }
}
