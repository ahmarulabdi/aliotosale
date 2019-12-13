package com.abdi.aliotosale.rest;


import com.abdi.aliotosale.models.Type;
import com.abdi.aliotosale.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/type")
public class TypeResource {
    @Autowired
    private TypeService typeService;

    @GetMapping("")
    public List<Type> getAllType() {
        return typeService.getAllType();
    }

    @GetMapping("/{id}")
    public Type getTypeById(@PathVariable(value = "id") Long id) {
        return typeService.getTypeById(id);
    }

}
