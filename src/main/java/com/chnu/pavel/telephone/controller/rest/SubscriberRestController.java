package com.chnu.pavel.telephone.controller.rest;

import com.chnu.pavel.telephone.model.Subscriber;
import com.chnu.pavel.telephone.service.subscriber.interfaces.SubscriberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.SubscriberRestController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|19:27
 * @Version SubscriberRestController: 1.0
 */

@RestController
@RequestMapping("/api/subscribers")
@AllArgsConstructor
public class SubscriberRestController {
    
    private final SubscriberService service;

    @GetMapping("/get/all")
    public List<Subscriber> findAll() {
        return service.findAll();
    }

    @PostMapping("/create")
    public Subscriber create( @RequestBody Subscriber subscriber) {
        return service.create(subscriber);
    }

    @GetMapping("/get/{id}")
    public Subscriber getById( @PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @PutMapping("/update/{id}")
    public Subscriber updateById( @RequestBody Subscriber subscriber, @PathVariable("id") String id) {
        return service.updateById(Long.valueOf(id), subscriber);
    }

    @DeleteMapping("delete/{id}")
    public Subscriber deleteById(@PathVariable("id") String id) {
        return service.deleteById(Long.valueOf(id));
    }
    
}
