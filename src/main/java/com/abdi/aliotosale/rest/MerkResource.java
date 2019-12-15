package com.abdi.aliotosale.rest;

import com.abdi.aliotosale.models.Merk;
import com.abdi.aliotosale.service.MerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
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

    @PutMapping("{id}")
    public Merk updateById(@PathVariable(value = "id") Long id, @RequestBody Merk merk) {
        return merkService.updateMerkById(id, merk);
    }
    @DeleteMapping("{id}")
    public Boolean deleteById(@PathVariable(value = "id") long id) {
        return merkService.deleteMerkById(id);
    }
}
