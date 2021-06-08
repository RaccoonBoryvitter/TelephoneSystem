package com.chnu.pavel.telephone.controller.rest;

import com.chnu.pavel.telephone.model.Agency;
import com.chnu.pavel.telephone.service.agency.interfaces.AgencyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AgencyRestController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|19:21
 * @Version AgencyRestController: 1.0
 */

@RestController
@RequestMapping("/api/agencies")
@AllArgsConstructor
public class AgencyRestController {
    
    private final AgencyService service;

    @GetMapping("/get/all")
    public List<Agency> findAll() {
        return service.findAll();
    }

    @PostMapping("/create")
    public Agency create( @RequestBody Agency agency) {
        return service.create(agency);
    }

    @GetMapping("/get/{id}")
    public Agency getById( @PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @PutMapping("/update/{id}")
    public Agency updateById( @RequestBody Agency agency, @PathVariable("id") String id) {
        return service.updateById(Long.valueOf(id), agency);
    }

    @DeleteMapping("delete/{id}")
    public Agency deleteById(@PathVariable("id") String id) {
        return service.deleteById(Long.valueOf(id));
    }
    
}
