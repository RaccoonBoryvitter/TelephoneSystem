package com.chnu.pavel.telephone.controller.rest;

import com.chnu.pavel.telephone.model.ConnectedPhone;
import com.chnu.pavel.telephone.service.connectedphone.interfaces.ConnectedPhoneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ConnectedPhoneRestController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|19:23
 * @Version ConnectedPhoneRestController: 1.0
 */

@RestController
@RequestMapping("/api/connectedPhones")
@AllArgsConstructor
public class ConnectedPhoneRestController {
    
    private final ConnectedPhoneService service;

    @RequestMapping("/get/all/")
    public List<ConnectedPhone> findAll() {
        return service.findAll();
    }

    @PostMapping("/create/")
    public ConnectedPhone create( @RequestBody ConnectedPhone connectedPhone) {
        return service.create(connectedPhone);
    }

    @GetMapping("/get/{id}")
    public ConnectedPhone getById( @PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @PostMapping("/update/{id}")
    public ConnectedPhone updateById( @RequestBody ConnectedPhone connectedPhone, @PathVariable("id") String id) {
        return service.updateById(Long.valueOf(id), connectedPhone);
    }

    @GetMapping("delete/{id}")
    public ConnectedPhone deleteById(@PathVariable("id") String id) {
        return service.deleteById(Long.valueOf(id));
    }
    
}
