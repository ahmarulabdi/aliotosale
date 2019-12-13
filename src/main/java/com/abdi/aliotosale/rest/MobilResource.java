package com.abdi.aliotosale.rest;

import com.abdi.aliotosale.models.Mobil;
import com.abdi.aliotosale.repository.MobilRepository;
import com.abdi.aliotosale.service.MobilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/mobil")
public class MobilResource {
    @Autowired
    private MobilService mobilService;

    @GetMapping("/")
    public List<Mobil> getAllMobil() {
        return mobilService.getAllMobil();
    }

}
