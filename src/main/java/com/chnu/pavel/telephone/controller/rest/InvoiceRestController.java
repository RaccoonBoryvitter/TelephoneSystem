package com.chnu.pavel.telephone.controller.rest;

import com.chnu.pavel.telephone.model.Invoice;
import com.chnu.pavel.telephone.service.invoice.interfaces.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.InvoiceRestController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|19:31
 * @Version InvoiceRestController: 1.0
 */

@RestController
@RequestMapping("/api/invoices")
@AllArgsConstructor
public class InvoiceRestController {
    
    private final InvoiceService service;

    @GetMapping("/get/all")
    public List<Invoice> findAll() {
        return service.findAll();
    }

    @PostMapping("/create")
    public Invoice create( @RequestBody Invoice invoice) {
        return service.create(invoice);
    }

    @GetMapping("/get/{id}")
    public Invoice getById( @PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @PutMapping("/update/{id}")
    public Invoice updateById( @RequestBody Invoice invoice, @PathVariable("id") String id) {
        return service.updateById(Long.valueOf(id), invoice);
    }

    @DeleteMapping("delete/{id}")
    public Invoice deleteById(@PathVariable("id") String id) {
        return service.deleteById(Long.valueOf(id));
    }
    
}
