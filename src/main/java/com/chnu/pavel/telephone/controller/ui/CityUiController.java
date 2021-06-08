package com.chnu.pavel.telephone.controller.ui;

import com.chnu.pavel.telephone.model.City;
import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.model.State;
import com.chnu.pavel.telephone.service.city.interfaces.CityService;
import com.chnu.pavel.telephone.service.province.interfaces.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CityUiController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 4/22/2021|11:20 AM
 * @Version CityUiController: 1.0
 */

@Controller
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityUiController {

    private final CityService service;
    private final ProvinceService provinceService;

    private String error = "noerror";
    private String successfull = "nosuccess";

    @RequestMapping("")
    public String findAll(Model model) {
        model.addAttribute("items", service.findAll());
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm:ss");
        model.addAttribute("formatter", formatter);
        model.addAttribute("provinces", provinceService.findAll());
        model.addAttribute("errMsg", error);
        if(!error.equals("noerror")) error = "noerror";
        model.addAttribute("successMsg", successfull);
        if(!successfull.equals("nosuccess")) successfull = "nosuccess";
        return "city/cities";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public City findById(@PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @GetMapping("/delete/{id}")
    public String deleteById( @PathVariable("id") String id) {
        service.deleteById(Long.valueOf(id));
        successfull = "SUCCESS! Object with id " + id + " has been deleted!";
        return "redirect:/cities";
    }

    @PostMapping("/create/")
    public String create(HttpServletRequest request) {
        String name = request.getParameter("create-name").trim();
        String phoneCode = request.getParameter("create-phone-code").trim();
        Province province = provinceService.findById(Long.valueOf(request.getParameter("create-province")));
        String description = request.getParameter("create-description").trim();

        if(service.findByName(name).isPresent() && service.findByName(name).get().getPhoneCode().equals(phoneCode)) {
            error = "ERROR! Object with such credentials exists!";
        } else if (name.isEmpty() || phoneCode.isEmpty())
            error = "ERROR! Empty values!";
        else {
            City city = new City();
            city.setName(name);
            city.setPhoneCode(phoneCode);
            city.setProvince(province);
            city.setDescription(description);
            service.create(city);
        }
        return "redirect:/cities";
    }

    @PostMapping("/update/{id}")
    public String update(HttpServletRequest request, @PathVariable("id") String id) {

        String name = request.getParameter("update-name").trim();
        String phoneCode = request.getParameter("update-phone-code").trim();
        Province province = provinceService.findById(Long.valueOf(request.getParameter("update-province")));
        String description = request.getParameter("update-description").trim();

        if((service.findByName(name).isPresent()
                && service.findByName(name).get().getPhoneCode().equals(phoneCode))
            || (service.findByPhoneCode(phoneCode).isPresent()
                && service.findByPhoneCode(phoneCode).get().getName().equals(name))) {
            error = "ERROR! Object with such credentials exists!";
        } else if (name.isEmpty() || phoneCode.isEmpty())
            error = "ERROR! Empty values!";
        else {
            City city = new City();
            city.setName(name);
            city.setPhoneCode(phoneCode);
            city.setProvince(province);
            city.setDescription(description);
            service.updateById(Long.valueOf(id), city);
        }
        return "redirect:/cities";
    }

}
