package com.chnu.pavel.telephone.controller.ui;

import com.chnu.pavel.telephone.model.AvailablePhoneNumber;
import com.chnu.pavel.telephone.model.Establishment;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import com.chnu.pavel.telephone.service.establishment.interfaces.EstablishmentService;
import com.chnu.pavel.telephone.service.telephoneexchange.interfaces.TelephoneExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.EstablishmentUiController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.06.2021|9:15
 * @Version EstablishmentUiController: 1.0
 */

@RequiredArgsConstructor
@RequestMapping("/establishments")
@Controller
public class EstablishmentUiController {

    private final TelephoneExchangeService telephoneExchangeService;
    private final EstablishmentService service;

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
        return "establishments/establishments";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Establishment findById(@PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @GetMapping("/delete/{id}")
    public String deleteById( @PathVariable("id") String id) {
        service.deleteById(Long.valueOf(id));
        successfull = "SUCCESS! Object with id " + id + " has been deleted!";
        return "redirect:/establishments/";
    }

    @PostMapping("/create/")
    public String create(HttpServletRequest request) {
        String name = request.getParameter("create-0").trim();
        TelephoneExchange telephoneExchange = telephoneExchangeService.findById(Long.valueOf(request.getParameter("create-1")));
        String description = request.getParameter("create-2").trim();

        Establishment establishment = new Establishment();
        establishment.setName(name);
        establishment.setTelephoneExchange(telephoneExchange);
        establishment.setDescription(description);
        service.create(establishment);

        successfull = "Object has been created!";

        return "redirect:/establishments/";
    }

    @PostMapping("/update/{id}")
    public String update(HttpServletRequest request, @PathVariable("id") String id) {

        String name = request.getParameter("update-1").trim();
        TelephoneExchange telephoneExchange = telephoneExchangeService.findById(Long.valueOf(request.getParameter("update-2")));
        String description = request.getParameter("update-3").trim();

        Establishment establishment = new Establishment();
        establishment.setName(name);
        establishment.setTelephoneExchange(telephoneExchange);
        establishment.setDescription(description);
        service.create(establishment);

        successfull = "Object " + id + " has been created!";
        return "redirect:/establishments/";
    }

}
