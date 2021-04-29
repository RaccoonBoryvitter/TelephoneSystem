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
@RequestMapping("/ui/cities")
@RequiredArgsConstructor
public class CityUiController {

    private final CityService service;
    private final ProvinceService provinceService;

    @RequestMapping("")
    public String findAll(Model model) {
        model.addAttribute("items", service.findAll());
        model.addAttribute("provinces", provinceService.findAllProvinces());
        return "city/cities";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public City findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @GetMapping("/delete/{id}")
    public String deleteById( @PathVariable("id") String id) {
        service.deleteById(id);
        return "redirect:/ui/cities";
    }

    @PostMapping("/create/")
    public String createProvince(HttpServletRequest request) {
        City city = new City();
        city.setName(request.getParameter("create-name").trim());
        city.setPhoneCode(request.getParameter("create-phone-code").trim());
        city.setProvince(provinceService.findProvinceById(request.getParameter("create-province")));
        service.create(city);
        return "redirect:/ui/cities";
    }

    @PostMapping("/update/{id}")
    public String update(HttpServletRequest request, @PathVariable("id") String id) {
        City city = new City();
        city.setName(request.getParameter("update-name").trim());
        city.setPhoneCode(request.getParameter("update-phone-code").trim());
        city.setProvince(provinceService.findProvinceById(request.getParameter("update-province")));
        service.updateById(city, id);
        return "redirect:/ui/cities";
    }

}
