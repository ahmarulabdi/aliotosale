package com.abdi.aliotosale.rest;

import com.abdi.aliotosale.service.BrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brand")
public class BrandResource {
    BrandService brandService;
}
