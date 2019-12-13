package com.abdi.aliotosale.service;


import com.abdi.aliotosale.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;
}
