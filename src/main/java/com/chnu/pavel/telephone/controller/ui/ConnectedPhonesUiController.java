package com.chnu.pavel.telephone.controller.ui;

import com.chnu.pavel.telephone.model.ConnectedPhone;
import com.chnu.pavel.telephone.model.Phone;
import com.chnu.pavel.telephone.model.PhoneNumber;
import com.chnu.pavel.telephone.model.PhoneType;
import com.chnu.pavel.telephone.service.connectedphone.interfaces.ConnectedPhoneService;
import com.chnu.pavel.telephone.service.phone.interfaces.PhoneService;
import com.chnu.pavel.telephone.service.phonenumber.interfaces.PhoneNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ConnectedPhonesUiController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.06.2021|13:30
 * @Version ConnectedPhonesUiController: 1.0
 */

@RequiredArgsConstructor
@RequestMapping("/connectedPhones")
@Controller
public class ConnectedPhonesUiController {

    private final ConnectedPhoneService service;
    private final PhoneNumberService phoneNumberService;
    private final PhoneService phoneService;

    private String error = "noerror";
    private String successfull = "nosuccess";

    @RequestMapping("/")
    public String findAll(Model model) {
        model.addAttribute("items", service.findAll());
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm:ss");
        model.addAttribute("formatter", formatter);
        model.addAttribute("phones", phoneService.findAll());
        model.addAttribute("phoneNumbers", phoneNumberService.findAll());
        model.addAttribute("errMsg", error);
        if(!error.equals("noerror")) error = "noerror";
        model.addAttribute("successMsg", successfull);
        if(!successfull.equals("nosuccess")) successfull = "nosuccess";
        return "connectedphone/connectedphones";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public ConnectedPhone findById(@PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @GetMapping("/delete/{id}")
    public String deleteById( @PathVariable("id") String id) {
        service.deleteById(Long.valueOf(id));
        successfull = "SUCCESS! Object with id " + id + " has been deleted!";
        return "redirect:/connectedPhones/";
    }

    @PostMapping("/create/")
    public String create(HttpServletRequest request) {
        Phone phone = phoneService.findById(Long.valueOf(request.getParameter("create-0").trim()));
        PhoneNumber number = phoneNumberService.findById(Long.valueOf(request.getParameter("create-1")));
        String description = request.getParameter("create-2").trim();

        ConnectedPhone connectedPhone = new ConnectedPhone();
        connectedPhone.setPhone(phone);
        connectedPhone.setPhoneNumber(number);
        connectedPhone.setDescription(description);
        service.create(connectedPhone);

        successfull = "Object has been created!";

        return "redirect:/connectedPhones/";
    }

    @PostMapping("/update/{id}")
    public String update(HttpServletRequest request, @PathVariable("id") String id) {

        Phone phone = phoneService.findById(Long.valueOf(request.getParameter("update-1").trim()));
        PhoneNumber number = phoneNumberService.findById(Long.valueOf(request.getParameter("update-2")));
        String description = request.getParameter("update-3").trim();

        ConnectedPhone connectedPhone = new ConnectedPhone();
        connectedPhone.setPhone(phone);
        connectedPhone.setPhoneNumber(number);
        connectedPhone.setDescription(description);
        service.updateById(Long.valueOf(id), connectedPhone);

        successfull = "Object " + id + " has been created!";
        return "redirect:/connectedPhones/";
    }

}
