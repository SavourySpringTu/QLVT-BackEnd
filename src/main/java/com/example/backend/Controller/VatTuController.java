package com.example.backend.Controller;

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
    public ResponseEntity<List<JSONObject>> listVatTu(){
        List<JSONObject> list = vatTuService.getAllVatTu();
        return ResponseEntity.ok(list);
    }
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<VatTuEntity> insertVatTu( @RequestBody VatTuEntity vatTu){
        return new ResponseEntity(vatTuService.insertVatTu(vatTu),HttpStatus.OK);
    }
    @RequestMapping(value = "/vattu/{id}", method = RequestMethod.GET)
    public ResponseEntity<VatTuEntity> findVatTu(@PathVariable String id){
        return new ResponseEntity<>(vatTuService.findVatTubyId(id),HttpStatus.OK);
    }
//    @RequestMapping(value = "/vattu/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<VatTuEntity> deleteVatTu(@PathVariable String id){
//        VatTuEntity vt = vatTuService.findVatTubyId(id);
//        vatTuService.deleteVatTubyId(id);
//        return new ResponseEntity<>(vt,HttpStatus.OK);
//    }
//    @RequestMapping(value = "/vattu", method = RequestMethod.PUT)
//    public ResponseEntity<VatTuEntity> updateVatTu(@RequestBody VatTuEntity vattu){
//        System.out.println(vattu.getMAVT());
//        return new ResponseEntity<>(vatTuService.updateVatTu(vattu),HttpStatus.OK);
//    }
}
