package com.abdi.aliotosale.rest;

import com.abdi.aliotosale.models.Mobil;
import com.abdi.aliotosale.service.MobilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/mobil")
public class MobilResource {
    @Autowired
    private MobilService mobilService;

    @GetMapping("")
    public List<Mobil> getAllMobil() {
        return mobilService.getAllMobil();
    }

    @GetMapping("/{merkId}")
    public List<Mobil> getMobilByMerkId(@PathVariable(name = "merkId") Long merkId) {
        return mobilService.getMobilByMerkId(merkId);
    }

    @GetMapping("/{merkId}/{typeId}")
    public List<Mobil> getMobilByMerkIdTypeId(@PathVariable(name = "merkId") Long merkId, @PathVariable(name = "typeId") Long typeId) {
        return mobilService.getMobilByMerkIdTypeId(merkId,typeId);
    }

    @PostMapping("/{merkId}/{typeId}")
    public Mobil addMobilByMerkIdTypeId(@PathVariable Long merkId, @PathVariable Long typeId, @RequestBody Mobil mobil) {
        return mobilService.addMobilByMerkIdTypeId(merkId,typeId,mobil);
    }

    @PutMapping("/{merkId}/{typeId}")
    public List<Mobil> updateMobilByMerkIdTypeId(@PathVariable Long merkId, @PathVariable Long typeId, @RequestBody Mobil mobil) {
        return mobilService.updateMobilByMerkIdTypeId(merkId, typeId,mobil);
    }

    @DeleteMapping("/{merkId}/{typeId}")
    public Boolean deleteMobilByMerkIdTypeId(@PathVariable Long merkId, @PathVariable Long typeId, @RequestBody Mobil mobil) {
        return mobilService.deleteMobilByMerkIdTypeId(merkId, typeId,mobil);
    }



}
