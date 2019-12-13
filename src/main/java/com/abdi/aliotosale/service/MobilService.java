package com.abdi.aliotosale.service;


import com.abdi.aliotosale.models.Mobil;
import com.abdi.aliotosale.repository.MobilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobilService {
    @Autowired
    private MobilRepository mobilRepository;

    public List<Mobil> getAllMobil() {
        return mobilRepository.findAll();
    }

}
