package com.chnu.pavel.telephone.controller.rest;

import com.chnu.pavel.telephone.model.Penalty;
import com.chnu.pavel.telephone.service.penalty.interfaces.PenaltyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PenaltyRestController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|19:28
 * @Version PenaltyRestController: 1.0
 */

@RestController
@RequestMapping("/api/penalites")
@AllArgsConstructor
public class PenaltyRestController {
    
    private final PenaltyService service;

    @GetMapping("/get/all")
    public List<Penalty> findAll() {
        return service.findAll();
    }

    @PostMapping("/create")
    public Penalty create( @RequestBody Penalty penalty) {
        return service.create(penalty);
    }

    @GetMapping("/get/{id}")
    public Penalty getById( @PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @PutMapping("/update/{id}")
    public Penalty updateById( @RequestBody Penalty penalty, @PathVariable("id") String id) {
        return service.updateById(Long.valueOf(id), penalty);
    }

    @DeleteMapping("delete/{id}")
    public Penalty deleteById(@PathVariable("id") String id) {
        return service.deleteById(Long.valueOf(id));
    }
    
}
