package com.example.backend.Services;

import com.example.backend.Entity.CTPNEntity;
import org.json.simple.JSONObject;

import java.util.List;

public interface CTPNService {

    List<JSONObject> getAllCTPN();
    CTPNEntity addCTPN(CTPNEntity ctpn);

    CTPNEntity updateCTPN(CTPNEntity ctpn);

    void deleteCTPNbyId(String mapn, String mavt);
}
