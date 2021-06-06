package com.chnu.pavel.telephone.controller.rest;

import com.chnu.pavel.telephone.model.City;
import com.chnu.pavel.telephone.model.District;
import com.chnu.pavel.telephone.service.district.interfaces.DistrictService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.DistrictRestController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|18:56
 * @Version DistrictRestController: 1.0
 */

@RestController
@RequestMapping("/api/districts")
@AllArgsConstructor
public class DistrictRestController {

    private final DistrictService service;

    @RequestMapping("/get/all/")
    public List<District> findAll() {
        return service.findAll();
    }

    @PostMapping("/create/")
    public District create( @RequestBody District district) {
        return service.create(district);
    }

    @GetMapping("/get/{id}")
    public District getById( @PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @PostMapping("/update/{id}")
    public District updateById( @RequestBody District district, @PathVariable("id") String id) {
        return service.updateById(Long.valueOf(id), district);
    }

    @GetMapping("delete/{id}")
    public District deleteById(@PathVariable("id") String id) {
        return service.deleteById(Long.valueOf(id));
    }

}
