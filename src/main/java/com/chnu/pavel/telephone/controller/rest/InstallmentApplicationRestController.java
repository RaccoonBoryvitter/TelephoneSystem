package com.chnu.pavel.telephone.controller.rest;

import com.chnu.pavel.telephone.model.InstallmentApplication;
import com.chnu.pavel.telephone.service.installmentapplication.interfaces.InstallmentApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.InstallmentApplicationRestController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|19:26
 * @Version InstallmentApplicationRestController: 1.0
 */

@RestController
@RequestMapping("/api/installQueue")
@AllArgsConstructor
public class InstallmentApplicationRestController {
    
    private final InstallmentApplicationService service;

    @RequestMapping("/get/all/")
    public List<InstallmentApplication> findAll() {
        return service.findAll();
    }

    @PostMapping("/create/")
    public InstallmentApplication create( @RequestBody InstallmentApplication installmentApplication) {
        return service.create(installmentApplication);
    }

    @GetMapping("/get/{id}")
    public InstallmentApplication getById( @PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @PostMapping("/update/{id}")
    public InstallmentApplication updateById( @RequestBody InstallmentApplication installmentApplication, @PathVariable("id") String id) {
        return service.updateById(Long.valueOf(id), installmentApplication);
    }

    @GetMapping("delete/{id}")
    public InstallmentApplication deleteById(@PathVariable("id") String id) {
        return service.deleteById(Long.valueOf(id));
    }
    
}
