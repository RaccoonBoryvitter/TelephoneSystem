package com.chnu.pavel.telephone.controller.ui;

import com.chnu.pavel.telephone.form.provinces.ProvinceForm;
import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.model.State;
import com.chnu.pavel.telephone.service.province.interfaces.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ProvinceUiController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 04.04.2021|19:13
 * @Version ProvinceUiController: 1.0
 */

@Controller
@RequestMapping("/ui/provinces")
public class ProvinceUiController {

    @Qualifier("provinceServiceImpl")
    @Autowired
    ProvinceService service;

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public String getProvinces(Model model) {
        model.addAttribute("items", service.getAll());
        return "province/provinces-list";
    }

//    @GetMapping("/get/{id}")
//    public Province getById(@PathVariable("id") String id) {
//        return service.readById(id);
//    }
//
    @RequestMapping( "/delete/{id}")
    public String deleteById(Model model, @PathVariable("id") String id) {
        service.deleteById(id);
        return "redirect:/ui/provinces/get/all/";
    }

    @GetMapping("/create/")
    public String create(Model model) {
        ProvinceForm form = new ProvinceForm();
        List<String> states = Arrays.stream(State.values()).map(State::name).collect(Collectors.toList());

        model.addAttribute("provinceForm", form);
        model.addAttribute("states", states);
        System.out.println(model);
        return "province/province-create";
    }

    @PostMapping("/create/")
    public String create(Model model,
                         @ModelAttribute("provinceForm") ProvinceForm provinceForm) {
        Province province = new Province();
        province.setName(provinceForm.getName());
        province.setPhoneCode(provinceForm.getPhoneCode());
        province.setState(State.valueOf(provinceForm.getState()));

        service.create(province);
        return "redirect:/ui/provinces/get/all";
    }
//
//    @PostMapping("/create/")
//    public Province create(@RequestBody Province province) {
//        return service.create(province);
//    }
//
//    @PostMapping("/update/")
//    public Province update(@RequestBody Province province) {
//        return service.update(province);
//    }

}
