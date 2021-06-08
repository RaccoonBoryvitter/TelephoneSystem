package com.chnu.pavel.telephone.controller.ui;

import com.chnu.pavel.telephone.model.*;
import com.chnu.pavel.telephone.repository.phone.PhoneRepository;
import com.chnu.pavel.telephone.service.phone.interfaces.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PhoneUiController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.06.2021|9:15
 * @Version PhoneUiController: 1.0
 */

@RequiredArgsConstructor
@RequestMapping("/phones")
@Controller
public class PhoneUiController {

    private final PhoneService service;

    private String error = "noerror";
    private String successfull = "nosuccess";

    @RequestMapping("/")
    public String findAll(Model model) {
        model.addAttribute("items", service.findAll());
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm:ss");
        model.addAttribute("formatter", formatter);
        model.addAttribute("phoneTypes", Arrays.asList(PhoneType.values()));
        model.addAttribute("errMsg", error);
        if(!error.equals("noerror")) error = "noerror";
        model.addAttribute("successMsg", successfull);
        if(!successfull.equals("nosuccess")) successfull = "nosuccess";
        return "phone/phones";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Phone findById(@PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @GetMapping("/delete/{id}")
    public String deleteById( @PathVariable("id") String id) {
        service.deleteById(Long.valueOf(id));
        successfull = "SUCCESS! Object with id " + id + " has been deleted!";
        return "redirect:/phones/";
    }

    @PostMapping("/create/")
    public String create(HttpServletRequest request) {
        String name = request.getParameter("create-0").trim();
        PhoneType phoneType = PhoneType.valueOf(request.getParameter("create-1"));
        boolean isWorking = Boolean.parseBoolean(request.getParameter("create-2"));
        String description = request.getParameter("create-3").trim();

        Phone phone = new Phone();
        phone.setName(name);
        phone.setPhoneType(phoneType);
        phone.setWorking(isWorking);
        phone.setDescription(description);
        service.create(phone);

        successfull = "Object has been created!";

        return "redirect:/phones/";
    }

    @PostMapping("/update/{id}")
    public String update(HttpServletRequest request, @PathVariable("id") String id) {

        String name = request.getParameter("update-1").trim();
        PhoneType phoneType = PhoneType.valueOf(request.getParameter("update-2"));
        boolean isWorking = Boolean.parseBoolean(request.getParameter("update-3"));
        String description = request.getParameter("update-4").trim();

        Phone phone = new Phone();
        phone.setName(name);
        phone.setPhoneType(phoneType);
        phone.setWorking(isWorking);
        phone.setDescription(description);
        service.updateById(Long.valueOf(id), phone);

        successfull = "Object " + id + " has been created!";
        return "redirect:/phones/";
    }

}
