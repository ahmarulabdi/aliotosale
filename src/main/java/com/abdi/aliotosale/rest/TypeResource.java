package com.abdi.aliotosale.rest;


import com.abdi.aliotosale.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/type")
public class TypeResource {
    @Autowired
    private TypeService typeService;
}
