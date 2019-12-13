package com.abdi.aliotosale.rest;

import com.abdi.aliotosale.models.Merk;
import com.abdi.aliotosale.service.MerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/merk")
public class MerkResource {
    @Autowired
    MerkService merkService;

    @GetMapping("")
    public List<Merk> getAllMerk() {
        return merkService.getAllMerk();
    }

    @GetMapping("{id}")
    public Merk getMerkById(@PathVariable(value = "id") Long id) {
        return merkService.getMerkById(id);
    }
}
