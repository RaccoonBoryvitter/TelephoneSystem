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
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityUiController {

    private final CityService service;
    private final ProvinceService provinceService;

    @RequestMapping("")
    public String findAll(Model model) {
        model.addAttribute("items", service.findAll());
        model.addAttribute("provinces", provinceService.findAll());
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
        return "redirect:/cities";
    }

    @PostMapping("/create/")
    public String create(HttpServletRequest request) {
        City city = new City();
        city.setName(request.getParameter("create-name").trim());
        city.setPhoneCode(request.getParameter("create-phone-code").trim());
        city.setProvince(provinceService.findById(Long.valueOf(request.getParameter("create-province"))));
        city.setDescription(request.getParameter("create-description"));
        service.create(city);
        return "redirect:/cities";
    }

    @PostMapping("/update/{id}")
    public String update(HttpServletRequest request, @PathVariable("id") String id) {
        City city = new City();
        city.setName(request.getParameter("update-name").trim());
        city.setPhoneCode(request.getParameter("update-phone-code").trim());
        city.setProvince(provinceService.findById(Long.valueOf(request.getParameter("create-province"))));
        city.setDescription(request.getParameter("create-description"));
        service.updateById(Long.valueOf(id), city);
        return "redirect:/cities";
    }

}
