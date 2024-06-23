package com.example.backend.Controller;

import com.example.backend.Services.GioHangSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("backend/api/giohang")
@CrossOrigin(origins = "*")
public class GioHangController {
    @Autowired
    private GioHangSerice gioHangSerice;
}
