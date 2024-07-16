package com.example.backend.Controller;

import com.example.backend.Entity.CTDDHEntity;
import com.example.backend.Services.CTDDHService;
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
@RequestMapping("backend/api/chitietdathang")
@CrossOrigin(origins = "*")
public class CTDDHController {
    @Autowired
    private CTDDHService ctddhService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseEntity<List<JSONObject>> listAllCTDDH(@RequestBody JSONObject data){
        List<JSONObject> result = ctddhService.getCTDDHbyQuyenandChiNhanh((String) data.get("maquyen"),(String) data.get("macn"));
        return new ResponseEntity(result, HttpStatus.OK);
    }
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseEntity insertCTDDH(@RequestBody JSONObject data){
        System.out.println((String) data.get("maddh"));
        System.out.println((String) data.get("mavt"));
        System.out.println((String) data.get("soluong"));
        System.out.println((String) data.get("dongia"));
        boolean result = ctddhService.insertCTDDH(data);
        if(result==true){
            return new ResponseEntity(1,HttpStatus.OK);
        }
        return new ResponseEntity(0,HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity updateCTDDH(@RequestBody JSONObject data){
        System.out.println("toi day");
        System.out.println((String) data.get("maddh"));
        System.out.println((String) data.get("mavt"));
        System.out.println((String) data.get("mavtupdate"));
        System.out.println((String) data.get("soluong"));
        System.out.println((String) data.get("dongia"));
        boolean result = ctddhService.updateCTDDH(data);
        if(result==true){
            return new ResponseEntity(1,HttpStatus.OK);
        }
        return new ResponseEntity(0,HttpStatus.OK);
    }

    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public ResponseEntity deleteCTDDH(@RequestBody JSONObject data) {
        boolean result = ctddhService.deleteCTDDH(data);
        if(result==true){
            return new ResponseEntity(1,HttpStatus.OK);
        }else {
            return new ResponseEntity(0,HttpStatus.OK);
        }
    }
}
