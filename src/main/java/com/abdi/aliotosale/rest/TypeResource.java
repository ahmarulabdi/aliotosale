package com.abdi.aliotosale.rest;


import com.abdi.aliotosale.models.Type;
import com.abdi.aliotosale.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/type")
public class TypeResource {
    @Autowired
    private TypeService typeService;

    @GetMapping("")
    public List<Type> getAllType() {
        return typeService.getAllType();
    }

    @GetMapping("{id}")
    public Type getTypeById(@PathVariable(value = "id") Long id) {
        return typeService.getTypeById(id);
    }

    @PutMapping("{id}")
    public Type updateTypeById(@PathVariable(value = "id") Long id, @RequestBody Type type){
        return typeService.updateTypeById(id, type);
    }

    @DeleteMapping("{id}")
    public Boolean deleteTypeById(@PathVariable(value = "id") Long id) {
        return typeService.deleteTypeById(id);
    }

}
