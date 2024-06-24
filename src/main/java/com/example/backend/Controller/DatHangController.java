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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<JSONObject>> listDatHang(){
        List<JSONObject> list = datHangService.getAllDatHang();
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

    @RequestMapping(value = "/dathang/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DatHangEntity> updateDatHang(@RequestBody DatHangEntity datHang){
        return new ResponseEntity<DatHangEntity>(datHangService.updateDatHang(datHang),HttpStatus.OK);
    }

    @RequestMapping(value = "/dathang/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DatHangEntity> deleteDatHang(@PathVariable String id){
        DatHangEntity datHang = datHangService.findDatHangbyId(id);
        datHangService.deleteDatHangbyId(id);
        return new ResponseEntity<DatHangEntity>(datHang,HttpStatus.OK);
    }
}
