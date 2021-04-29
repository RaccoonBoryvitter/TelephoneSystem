package com.chnu.pavel.telephone.controller.rest;

import com.chnu.pavel.telephone.model.City;
import com.chnu.pavel.telephone.service.city.interfaces.CityService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CityRestController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 07.04.2021|19:37
 * @Version CityRestController: 1.0
 */

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityRestController {

    private final CityService service;

    @RequestMapping("/get/all")
    public List<City> getCities() {
        return service.findAll();
    }

    @PostMapping("/create/")
    public City create( @RequestBody City city) {
        return service.create(city);
    }

    @GetMapping("/get/{id}")
    public City getById( @PathVariable("id") String id) {
        return service.findById(id);
    }

    @PostMapping("/update/{id}")
    public City updateById( @RequestBody City city, @PathVariable("id") String id) {
        return service.updateById(city, id);
    }

    @GetMapping("delete/{id}")
    public String deleteById( @PathVariable("id") String id) {
        return service.deleteById(id);
    }

}
