package com.chnu.pavel.telephone.controller.rest;

import com.chnu.pavel.telephone.model.TelephoneExchange;
import com.chnu.pavel.telephone.service.telephoneexchange.interfaces.TelephoneExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.TelephoneExchangeRestController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|19:00
 * @Version TelephoneExchangeRestController: 1.0
 */

@RestController
@RequestMapping("/api/telephoneExchanges")
@AllArgsConstructor
public class TelephoneExchangeRestController {
    
    private final TelephoneExchangeService service;

    @RequestMapping("/get/all/")
    public List<TelephoneExchange> findAll() {
        return service.findAll();
    }

    @PostMapping("/create/")
    public TelephoneExchange create( @RequestBody TelephoneExchange telephoneExchange) {
        return service.create(telephoneExchange);
    }

    @GetMapping("/get/{id}")
    public TelephoneExchange getById( @PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @PostMapping("/update/{id}")
    public TelephoneExchange updateById( @RequestBody TelephoneExchange telephoneExchange, @PathVariable("id") String id) {
        return service.updateById(Long.valueOf(id), telephoneExchange);
    }

    @GetMapping("delete/{id}")
    public TelephoneExchange deleteById(@PathVariable("id") String id) {
        return service.deleteById(Long.valueOf(id));
    }
    
}
