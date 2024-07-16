package com.example.backend.Services;

import com.example.backend.Entity.CTPNEntity;
import org.json.simple.JSONObject;

import java.util.List;

public interface CTPNService {

    List<JSONObject> getAllCTPN(String quyen,String chinhanh);
    boolean insertCTPN(JSONObject ctpn);

    CTPNEntity updateCTPN(CTPNEntity ctpn);

    void deleteCTPNbyId(Long mapn, String mavt);
}
