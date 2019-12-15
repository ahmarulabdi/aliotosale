package com.abdi.aliotosale.service;


import com.abdi.aliotosale.exception.ResourceNotFoundException;
import com.abdi.aliotosale.models.Type;
import com.abdi.aliotosale.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public List<Type> getAllType() {
        return typeRepository.findAll();
    }

    public Type getTypeById(Long id) {
        return typeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Type", "ID", id)
        );
    }

    public Type updateTypeById(Long id, Type type) {
        Type udpatedType = typeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Type", "ID", id)
        );

        udpatedType.setNama(type.getNama());
        return typeRepository.save(udpatedType);
    }

    public Boolean deleteTypeById(Long id) {
        typeRepository.deleteById(id);
        return typeRepository.findById(id).isEmpty();
    }
}
