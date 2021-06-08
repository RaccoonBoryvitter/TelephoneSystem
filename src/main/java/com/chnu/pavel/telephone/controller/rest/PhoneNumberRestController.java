package com.chnu.pavel.telephone.controller.rest;

import com.chnu.pavel.telephone.model.PhoneNumber;
import com.chnu.pavel.telephone.service.phonenumber.interfaces.PhoneNumberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PhoneNumberRestController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|19:14
 * @Version PhoneNumberRestController: 1.0
 */

@RestController
@RequestMapping("/api/phoneNumbers")
@AllArgsConstructor
public class PhoneNumberRestController {
    
    private final PhoneNumberService service;

    @GetMapping("/get/all")
    public List<PhoneNumber> findAll() {
        return service.findAll();
    }

    @PostMapping("/create")
    public PhoneNumber create( @RequestBody PhoneNumber phoneNumber) {
        return service.create(phoneNumber);
    }

    @GetMapping("/get/{id}")
    public PhoneNumber getById( @PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @PutMapping("/update/{id}")
    public PhoneNumber updateById( @RequestBody PhoneNumber phoneNumber, @PathVariable("id") String id) {
        return service.updateById(Long.valueOf(id), phoneNumber);
    }

    @DeleteMapping("delete/{id}")
    public PhoneNumber deleteById(@PathVariable("id") String id) {
        return service.deleteById(Long.valueOf(id));
    }
    
}
