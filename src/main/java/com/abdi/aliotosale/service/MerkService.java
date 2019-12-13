package com.abdi.aliotosale.service;

import com.abdi.aliotosale.models.Merk;
import com.abdi.aliotosale.repository.MerkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerkService {
    @Autowired
    private MerkRepository merkRepository;

    public List<Merk> getAllBrand() {
        return merkRepository.findAll();
    }

    public Merk getBrandById(Long id) {
        return merkRepository.getOne(id);
    }

}
