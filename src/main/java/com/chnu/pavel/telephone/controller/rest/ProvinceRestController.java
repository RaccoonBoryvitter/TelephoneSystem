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

    @Autowired
    @Qualifier("provinceServiceImpl")
    ProvinceService service;

    @RequestMapping("/get/all")
    public List<Province> getProvinces() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Province getById(@PathVariable("id") String id) {
        return service.getById(id);
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") String id) {
        return service.deleteById(id);
    }

    @PostMapping("/create/")
    public Province create(@RequestBody Province province) {
        return service.create(province);
    }

    @PostMapping("/update/{id}")
    public Province update(@RequestBody Province province, @PathVariable("id") String id) {
        return service.updateById(province, id);
    }

}
