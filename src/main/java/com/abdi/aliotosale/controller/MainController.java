package com.abdi.aliotosale.controller;

import com.abdi.aliotosale.service.MobilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mobil")
public class MainController {
    @Autowired
    MobilService mobilService;

    @GetMapping("")
    public String index() {
        return "mobil_show";
    }
}
