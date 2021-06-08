package com.chnu.pavel.telephone.controller.ui;

import com.chnu.pavel.telephone.model.Address;
import com.chnu.pavel.telephone.model.AvailablePhoneNumber;
import com.chnu.pavel.telephone.model.PhoneNumber;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import com.chnu.pavel.telephone.service.address.interfaces.AddressService;
import com.chnu.pavel.telephone.service.availablephonenumber.interfaces.AvailablePhoneNumberService;
import com.chnu.pavel.telephone.service.phonenumber.interfaces.PhoneNumberService;
import com.chnu.pavel.telephone.service.telephoneexchange.interfaces.TelephoneExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AvailablePhoneUiController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.06.2021|9:15
 * @Version AvailablePhoneUiController: 1.0
 */

@RequiredArgsConstructor
@RequestMapping("/availablePhoneNumbers")
@Controller
public class AvailablePhoneUiController {

    private final AvailablePhoneNumberService service;
    private final TelephoneExchangeService telephoneExchangeService;

    private String error = "noerror";
    private String successfull = "nosuccess";

    @RequestMapping("/")
    public String findAll(Model model) {
        model.addAttribute("items", service.findAll());
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm:ss");
        model.addAttribute("formatter", formatter);
        model.addAttribute("telephoneExchanges", telephoneExchangeService.findAll());
        model.addAttribute("errMsg", error);
        if(!error.equals("noerror")) error = "noerror";
        model.addAttribute("successMsg", successfull);
        if(!successfull.equals("nosuccess")) successfull = "nosuccess";
        return "availablephonenumber/availablephonenumbers";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public AvailablePhoneNumber findById(@PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @GetMapping("/delete/{id}")
    public String deleteById( @PathVariable("id") String id) {
        service.deleteById(Long.valueOf(id));
        successfull = "SUCCESS! Object with id " + id + " has been deleted!";
        return "redirect:/phoneNumbers/";
    }

    @PostMapping("/create/")
    public String create(HttpServletRequest request) {
        String number = request.getParameter("create-0").trim();
        TelephoneExchange telephoneExchange = telephoneExchangeService.findById(Long.valueOf(request.getParameter("create-2")));
        String description = request.getParameter("create-3").trim();

        AvailablePhoneNumber phoneNumber = new AvailablePhoneNumber();
        phoneNumber.setNumber(number);
        telephoneExchange.setDescription(description);
        service.create(phoneNumber);

        successfull = "Object has been created!";

        return "redirect:/phoneNumbers/";
    }

    @PostMapping("/update/{id}")
    public String update(HttpServletRequest request, @PathVariable("id") String id) {

        String number = request.getParameter("update-1").trim();
        TelephoneExchange telephoneExchange = telephoneExchangeService.findById(Long.valueOf(request.getParameter("create-3")));
        String description = request.getParameter("create-4").trim();

        AvailablePhoneNumber phoneNumber = new AvailablePhoneNumber();
        phoneNumber.setNumber(number);
        telephoneExchange.setDescription(description);
        service.create(phoneNumber);

        successfull = "Object " + id + " has been created!";
        return "redirect:/phoneNumbers/";
    }

}
