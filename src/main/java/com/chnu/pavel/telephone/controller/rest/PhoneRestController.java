package com.chnu.pavel.telephone.controller.rest;

import com.chnu.pavel.telephone.model.Phone;
import com.chnu.pavel.telephone.service.phone.interfaces.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PhoneRestController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|19:15
 * @Version PhoneRestController: 1.0
 */

@RestController
@RequestMapping("/api/phones")
@AllArgsConstructor
public class PhoneRestController {
    
    private final PhoneService service;

    @RequestMapping("/get/all/")
    public List<Phone> findAll() {
        return service.findAll();
    }

    @PostMapping("/create/")
    public Phone create( @RequestBody Phone phone) {
        return service.create(phone);
    }

    @GetMapping("/get/{id}")
    public Phone getById( @PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @PostMapping("/update/{id}")
    public Phone updateById( @RequestBody Phone phone, @PathVariable("id") String id) {
        return service.updateById(Long.valueOf(id), phone);
    }

    @GetMapping("delete/{id}")
    public Phone deleteById(@PathVariable("id") String id) {
        return service.deleteById(Long.valueOf(id));
    }
    
}
