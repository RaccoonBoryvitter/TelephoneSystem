package com.chnu.pavel.telephone.controller.rest;

import com.chnu.pavel.telephone.model.AvailablePhoneNumber;
import com.chnu.pavel.telephone.service.availablephonenumber.interfaces.AvailablePhoneNumberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AvailablePhoneNumberRestController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|19:17
 * @Version AvailablePhoneNumberRestController: 1.0
 */

@RestController
@RequestMapping("/api/availablePhoneNumbers")
@AllArgsConstructor
public class AvailablePhoneNumberRestController {

    private final AvailablePhoneNumberService service;

    @GetMapping("/get/all")
    public List<AvailablePhoneNumber> findAll() {
        return service.findAll();
    }

    @PostMapping("/create")
    public AvailablePhoneNumber create( @RequestBody AvailablePhoneNumber availablePhoneNumber) {
        return service.create(availablePhoneNumber);
    }

    @GetMapping("/get/{id}")
    public AvailablePhoneNumber getById( @PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @PutMapping("/update/{id}")
    public AvailablePhoneNumber updateById( @RequestBody AvailablePhoneNumber availablePhoneNumber, @PathVariable("id") String id) {
        return service.updateById(Long.valueOf(id), availablePhoneNumber);
    }

    @DeleteMapping("delete/{id}")
    public AvailablePhoneNumber deleteById(@PathVariable("id") String id) {
        return service.deleteById(Long.valueOf(id));
    }

}
