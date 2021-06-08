package com.chnu.pavel.telephone.controller.ui;

import com.chnu.pavel.telephone.model.City;
import com.chnu.pavel.telephone.model.District;
import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.service.city.interfaces.CityService;
import com.chnu.pavel.telephone.service.district.interfaces.DistrictService;
import com.chnu.pavel.telephone.service.province.interfaces.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.DistrictUiController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.06.2021|5:55
 * @Version DistrictUiController: 1.0
 */

@Controller
@RequestMapping("/districts")
@RequiredArgsConstructor
public class DistrictUiController {

    private final CityService cityService;
    private final DistrictService service;

    private String error = "noerror";
    private String successfull = "nosuccess";

    @RequestMapping("")
    public String findAll(Model model) {
        model.addAttribute("items", service.findAll());
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm:ss");
        model.addAttribute("formatter", formatter);
        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("errMsg", error);
        if(!error.equals("noerror")) error = "noerror";
        model.addAttribute("successMsg", successfull);
        if(!successfull.equals("nosuccess")) successfull = "nosuccess";
        return "district/districts";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public District findById(@PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @GetMapping("/delete/{id}")
    public String deleteById( @PathVariable("id") String id) {
        service.deleteById(Long.valueOf(id));
        successfull = "SUCCESS! Object with id " + id + " has been deleted!";
        return "redirect:/districts";
    }

    @PostMapping("/create/")
    public String create(HttpServletRequest request) {
        String name = request.getParameter("create-name").trim();
        City city = cityService.findById(Long.valueOf(request.getParameter("create-city")));
        String description = request.getParameter("create-description").trim();

        if(service.findByName(name).isPresent() && service.findByName(name).get().getCity().equals(city)) {
            error = "ERROR! Object with such credentials exists!";
        } else if (name.isEmpty())
            error = "ERROR! Empty values!";
        else {
            District district = new District();
            district.setName(name);
            district.setCity(city);
            city.setDescription(description);
            service.create(district);
        }
        return "redirect:/districts";
    }

    @PostMapping("/update/{id}")
    public String update(HttpServletRequest request, @PathVariable("id") String id) {

        String name = request.getParameter("update-name").trim();
        City city = cityService.findById(Long.valueOf(request.getParameter("update-city")));
        String description = request.getParameter("update-description").trim();

        if(service.findByName(name).isPresent()
                && service.findByName(name).get().getCity().equals(city)) {
            error = "ERROR! Object with such credentials exists!";
        } else if (name.isEmpty())
            error = "ERROR! Empty values!";
        else {
            District district = new District();
            district.setName(name);
            district.setCity(city);
            city.setDescription(description);
            service.updateById(Long.valueOf(id), district);
        }
        return "redirect:/districts";
    }

}
