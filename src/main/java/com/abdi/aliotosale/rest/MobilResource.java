package com.abdi.aliotosale.rest;

import com.abdi.aliotosale.models.Merk;
import com.abdi.aliotosale.models.Mobil;
import com.abdi.aliotosale.models.Type;
import com.abdi.aliotosale.service.MerkService;
import com.abdi.aliotosale.service.MobilService;
import com.abdi.aliotosale.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/mobil")
public class MobilResource {
    @Autowired
    private MobilService mobilService;
    @Autowired
    private MerkService merkService;
    @Autowired
    private TypeService typeService;

    @GetMapping("")
    public List<Mobil> getAllMobil() {
        return mobilService.getAllMobil();
    }

    @GetMapping("/{brand}/merk")
    public List<Mobil> getMobilByMerkId(@PathVariable(name = "brand") String brand) {
        Merk merk = merkService.findFirstByBrand(brand);
        return mobilService.getMobilByMerkId(merk.getId());
    }

    @GetMapping("/{merkNama}/type")
    public List<Mobil> getMobilByTypeId(@PathVariable(name = "merkNama") String merkNama) {
        Type type = typeService.findFirstByTypeNama(merkNama);
        return mobilService.getMobilByTypeId(type.getId());
    }

    @PutMapping("/{id}")
    public Mobil updateMobilById(@PathVariable long id, @RequestBody Mobil mobil){
        return mobilService.updateMobilById(id, mobil);
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

    @DeleteMapping("/{id}")
    public Boolean deleteMobilById(@PathVariable Long id){
        return mobilService.deleteMobilById(id);
    }



}
