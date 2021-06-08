package com.chnu.pavel.telephone.controller.ui;

import com.chnu.pavel.telephone.model.Address;
import com.chnu.pavel.telephone.model.StationType;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import com.chnu.pavel.telephone.service.address.interfaces.AddressService;
import com.chnu.pavel.telephone.service.telephoneexchange.interfaces.TelephoneExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.TelephoneExchangeUiController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.06.2021|9:14
 * @Version TelephoneExchangeUiController: 1.0
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/telephoneExchanges")
public class TelephoneExchangeUiController {

    private final TelephoneExchangeService service;
    private final AddressService addressService;

    private String error = "noerror";
    private String successfull = "nosuccess";

    @RequestMapping("/")
    public String findAll(Model model) {
        model.addAttribute("items", service.findAll());
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm:ss");
        model.addAttribute("formatter", formatter);
        model.addAttribute("stationTypes", Arrays.asList(StationType.values()));
        model.addAttribute("addresses", addressService.findAll());
        model.addAttribute("errMsg", error);
        if(!error.equals("noerror")) error = "noerror";
        model.addAttribute("successMsg", successfull);
        if(!successfull.equals("nosuccess")) successfull = "nosuccess";
        return "telephoneexchange/telephoneexchanges";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public TelephoneExchange findById(@PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @GetMapping("/delete/{id}")
    public String deleteById( @PathVariable("id") String id) {
        service.deleteById(Long.valueOf(id));
        successfull = "SUCCESS! Object with id " + id + " has been deleted!";
        return "redirect:/telephoneExchanges/";
    }

    @PostMapping("/create/")
    public String create(HttpServletRequest request) {
        String codeName = request.getParameter("create-0").trim();
        Address address = addressService.findById(Long.valueOf(request.getParameter("create-1")));
        StationType stationType = StationType.valueOf(request.getParameter("create-2"));
        short availableCables = Short.parseShort(request.getParameter("create-3"));
        short availableChannels = Short.parseShort(request.getParameter("create-4"));
        boolean workingStatus = Boolean.getBoolean(request.getParameter("create-5"));
        String description = request.getParameter("create-6").trim();

        TelephoneExchange telephoneExchange = new TelephoneExchange();
        telephoneExchange.setCodeName(codeName);
        telephoneExchange.setAddress(address);
        telephoneExchange.setStationType(stationType);
        telephoneExchange.setAvailableChannels(availableChannels);
        telephoneExchange.setAvailableCables(availableCables);
        telephoneExchange.setWorkingStatus(workingStatus);
        telephoneExchange.setDescription(description);
        service.create(telephoneExchange);

        successfull = "Object has been created!";

        return "redirect:/telephoneExchanges/";
    }

    @PostMapping("/update/{id}")
    public String update(HttpServletRequest request, @PathVariable("id") String id) {

        String codeName = request.getParameter("update-0").trim();
        Address address = addressService.findById(Long.valueOf(request.getParameter("update-1")));
        StationType stationType = StationType.valueOf(request.getParameter("update-2"));
        short availableCables = Short.parseShort(request.getParameter("update-3"));
        short availableChannels = Short.parseShort(request.getParameter("update-4"));
        boolean workingStatus = Boolean.getBoolean(request.getParameter("update-5"));
        String description = request.getParameter("update-6").trim();

        TelephoneExchange telephoneExchange = new TelephoneExchange();
        telephoneExchange.setCodeName(codeName);
        telephoneExchange.setAddress(address);
        telephoneExchange.setStationType(stationType);
        telephoneExchange.setAvailableChannels(availableChannels);
        telephoneExchange.setAvailableCables(availableCables);
        telephoneExchange.setWorkingStatus(workingStatus);
        telephoneExchange.setDescription(description);
        service.create(telephoneExchange);

        successfull = "Object " + id + " has been created!";
        return "redirect:/telephoneExchanges/";
    }

}
