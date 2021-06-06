package com.chnu.pavel.telephone.controller.rest;

import com.chnu.pavel.telephone.model.SubscriptionFee;
import com.chnu.pavel.telephone.service.subscriptionfee.interfaces.SubscriptionFeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.SubscriptionFeeRestController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|19:29
 * @Version SubscriptionFeeRestController: 1.0
 */

@RestController
@RequestMapping("/api/subscriptionFees")
@AllArgsConstructor
public class SubscriptionFeeRestController {
    
    private final SubscriptionFeeService service;

    @RequestMapping("/get/all/")
    public List<SubscriptionFee> findAll() {
        return service.findAll();
    }

    @PostMapping("/create/")
    public SubscriptionFee create( @RequestBody SubscriptionFee subscriptionFee) {
        return service.create(subscriptionFee);
    }

    @GetMapping("/get/{id}")
    public SubscriptionFee getById( @PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @PostMapping("/update/{id}")
    public SubscriptionFee updateById( @RequestBody SubscriptionFee subscriptionFee, @PathVariable("id") String id) {
        return service.updateById(Long.valueOf(id), subscriptionFee);
    }

    @GetMapping("delete/{id}")
    public SubscriptionFee deleteById(@PathVariable("id") String id) {
        return service.deleteById(Long.valueOf(id));
    }
    
}
