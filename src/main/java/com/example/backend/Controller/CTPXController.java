package com.example.backend.Controller;

import com.example.backend.Services.CTPXService;
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
@CrossOrigin(origins = "*")
public class CTPXController {
    @Autowired
    private CTPXService ctpxService;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ResponseEntity<List<JSONObject>> getListCTPX(@RequestBody JSONObject data){
        List<JSONObject> result = ctpxService.getCTPXbyQuyenandChiNhanh((String) data.get("maquyen"),(String) data.get("macn"));
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
