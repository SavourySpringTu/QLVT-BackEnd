package com.example.backend.Controller;

import com.example.backend.Services.PhieuXuatService;
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
@RequestMapping("backend/api/phieuxuat")
@CrossOrigin(origins = "*")
public class PhieuXuatController {
    @Autowired
    private PhieuXuatService phieuXuatService;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ResponseEntity<List<JSONObject>> getListPhieuXuat(@RequestBody JSONObject data){
        List<JSONObject> result = phieuXuatService.getPhieuXuatbyQuyenandChiNhanh((String) data.get("maquyen"),(String) data.get("macn"));
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
