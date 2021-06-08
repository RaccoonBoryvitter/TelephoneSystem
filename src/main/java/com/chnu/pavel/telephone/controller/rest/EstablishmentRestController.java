package com.chnu.pavel.telephone.controller.rest;

import com.chnu.pavel.telephone.model.Establishment;
import com.chnu.pavel.telephone.service.establishment.interfaces.EstablishmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.EstablishmentRestController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|19:19
 * @Version EstablishmentRestController: 1.0
 */

@RestController
@RequestMapping("/api/establishments")
@AllArgsConstructor
public class EstablishmentRestController {
    
    private final EstablishmentService service;

    @GetMapping("/get/all")
    public List<Establishment> findAll() {
        return service.findAll();
    }

    @PostMapping("/create")
    public Establishment create( @RequestBody Establishment establishment) {
        return service.create(establishment);
    }

    @GetMapping("/get/{id}")
    public Establishment getById( @PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @PutMapping("/update/{id}")
    public Establishment updateById( @RequestBody Establishment establishment, @PathVariable("id") String id) {
        return service.updateById(Long.valueOf(id), establishment);
    }

    @DeleteMapping("delete/{id}")
    public Establishment deleteById(@PathVariable("id") String id) {
        return service.deleteById(Long.valueOf(id));
    }
    
}
