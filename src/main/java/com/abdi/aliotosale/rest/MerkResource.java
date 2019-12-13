package com.abdi.aliotosale.rest;

import com.abdi.aliotosale.service.MerkService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/merk")
public class MerkResource {
    MerkService merkService;
}
