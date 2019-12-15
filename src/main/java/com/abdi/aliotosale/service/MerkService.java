package com.abdi.aliotosale.service;

import com.abdi.aliotosale.exception.ResourceNotFoundException;
import com.abdi.aliotosale.models.Merk;
import com.abdi.aliotosale.repository.MerkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerkService {
    @Autowired
    private MerkRepository merkRepository;

    public List<Merk> getAllMerk() {
        return merkRepository.findAll();
    }

    public Merk getMerkById(Long id) {
        return merkRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Merk", "ID", id)
        );
    }

    public Merk updateMerkById(Long id, Merk merk) {
        Merk updatedMerk = merkRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Merk", "ID", id)
        );

        updatedMerk.setBrand(merk.getBrand());
        return merkRepository.save(updatedMerk);
    }

    public Boolean deleteMerkById(Long id) {
        merkRepository.deleteById(id);
        return merkRepository.findById(id).isEmpty();
    }

}
