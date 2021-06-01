package com.chnu.pavel.telephone.controller.rest;

import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.service.province.interfaces.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ProvinceRestController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2021|01:22
 * @Version ProvinceRestController: 1.0
 */

@RestController
@RequestMapping("api/provinces")
@RequiredArgsConstructor
public class ProvinceRestController {

    private final ProvinceService service;

    @RequestMapping("/get/all")
    public List<Province> getProvinces() {
        return service.findAll();
    }

    @GetMapping("/get/{id}")
    public Province getById(@PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") String id) {
        return "Object " + service.deleteById(Long.valueOf(id)).toString() + " was succesfully deleted";
    }

    @PostMapping("/create/")
    public Province create(@RequestBody Province province) {
        return service.create(province);
    }

    @PostMapping("/update/{id}")
    public Province update(@RequestBody Province province, @PathVariable("id") String id) {
        return service.updateById(Long.valueOf(id), province);
    }

}
