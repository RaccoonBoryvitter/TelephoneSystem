package com.chnu.pavel.telephone.controller.rest;

import com.chnu.pavel.telephone.model.Address;
import com.chnu.pavel.telephone.service.address.interfaces.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AddressRestController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|18:58
 * @Version AddressRestController: 1.0
 */

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressRestController {
    
    private final AddressService service;

    @RequestMapping("/get/all/")
    public List<Address> findAll() {
        return service.findAll();
    }

    @PostMapping("/create/")
    public Address create( @RequestBody Address address) {
        return service.create(address);
    }

    @GetMapping("/get/{id}")
    public Address getById( @PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @PostMapping("/update/{id}")
    public Address updateById( @RequestBody Address address, @PathVariable("id") String id) {
        return service.updateById(Long.valueOf(id), address);
    }

    @GetMapping("delete/{id}")
    public Address deleteById(@PathVariable("id") String id) {
        return service.deleteById(Long.valueOf(id));
    }
    
}
