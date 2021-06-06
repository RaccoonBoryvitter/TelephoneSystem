package com.chnu.pavel.telephone.controller.rest;

import com.chnu.pavel.telephone.model.CallDetailRecord;
import com.chnu.pavel.telephone.service.calldetailrecord.interfaces.CallDetailRecordService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CallDetailRecordRestController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|19:24
 * @Version CallDetailRecordRestController: 1.0
 */

@RestController
@RequestMapping("/api/callDetailRecords")
@AllArgsConstructor
public class CallDetailRecordRestController {
    
    private final CallDetailRecordService service;

    @RequestMapping("/get/all/")
    public List<CallDetailRecord> findAll() {
        return service.findAll();
    }

    @PostMapping("/create/")
    public CallDetailRecord create( @RequestBody CallDetailRecord callDetailRecord) {
        return service.create(callDetailRecord);
    }

    @GetMapping("/get/{id}")
    public CallDetailRecord getById( @PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @PostMapping("/update/{id}")
    public CallDetailRecord updateById( @RequestBody CallDetailRecord callDetailRecord, @PathVariable("id") String id) {
        return service.updateById(Long.valueOf(id), callDetailRecord);
    }

    @GetMapping("delete/{id}")
    public CallDetailRecord deleteById(@PathVariable("id") String id) {
        return service.deleteById(Long.valueOf(id));
    }
    
}
