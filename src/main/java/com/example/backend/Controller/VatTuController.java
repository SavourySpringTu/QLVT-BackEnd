package com.example.backend.Controller;

import com.example.backend.Entity.CTDDHEntity;
import com.example.backend.Entity.CTDDHID;
import com.example.backend.Entity.DatHangEntity;
import com.example.backend.Entity.VatTuEntity;
import com.example.backend.Services.VatTuService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("backend/api/vattu")
@CrossOrigin(origins = "*")
public class VatTuController {
    @Autowired
    private VatTuService vatTuService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<JSONObject>> listVatTu(@RequestBody JSONObject data){
        List<JSONObject> list = vatTuService.getAllVatTu();
        return ResponseEntity.ok(list);
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<VatTuEntity> insertVatTu( @RequestBody JSONObject vattu){
        System.out.println(vattu);
        boolean result = vatTuService.saveVatTu(vattu);
        if(result==true){
            return new ResponseEntity(1, HttpStatus.OK);
        }else{
            return new ResponseEntity(0,HttpStatus.OK);
        }
    }
    @RequestMapping(value = "/delete", method = RequestMethod.PUT)
    public ResponseEntity<VatTuEntity> deleteVatTu(@RequestBody JSONObject vt){
        System.out.println(vt.get("mavt"));
        boolean result = vatTuService.deleteVatTubyId((String) vt.get("mavt"));
        if(result==true){
            return new ResponseEntity(1, HttpStatus.OK);
        }else{
            return new ResponseEntity(0,HttpStatus.OK);
        }
    }
}
