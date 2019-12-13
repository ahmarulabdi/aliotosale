package com.abdi.aliotosale.controller;

import com.abdi.aliotosale.models.Mobil;
import com.abdi.aliotosale.repository.MobilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MobilController {
    EntityManager entityManager;
    @Autowired
    MobilRepository mobilRepository;

    @GetMapping("/mobil")
    public List<Mobil> getAllMobil() {
        return mobilRepository.findAll();
    }

}
