package com.chnu.pavel.telephone.controller.ui;

import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.model.State;
import com.chnu.pavel.telephone.service.province.interfaces.ProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
@RequiredArgsConstructor
public class ProvinceUiController {

    private final ProvinceService service;

    @RequestMapping("")
    public String findAllProvinces(Model model) {
        model.addAttribute("items", service.findAllProvinces());
        model.addAttribute("states", Arrays.asList(State.values()));
        return "province/provinces";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Province findProvinceById(@PathVariable("id") String id) {
        return service.findProvinceById(id);
    }

    @GetMapping("/delete/{id}")
    public String deleteProvinceById( @PathVariable("id") String id) {
        service.deleteProvinceById(id);
        return "redirect:/ui/provinces";
    }

    @PostMapping("/create/")
    public String createProvince(HttpServletRequest request) {
        Province province = new Province();
        province.setName(request.getParameter("create-name").trim());
        province.setPhoneCode(request.getParameter("create-phone-code").trim());
        province.setState(State.valueOf(request.getParameter("create-state").trim()));
        service.createProvince(province);
        return "redirect:/ui/provinces";
    }

    @PostMapping("/update/{id}")
    public String update(HttpServletRequest request, @PathVariable("id") String id) {
        Province province = new Province();
        province.setName(request.getParameter("update-name").trim());
        province.setPhoneCode(request.getParameter("update-phone-code").trim());
        province.setState(State.valueOf(request.getParameter("update-state").trim()));
        service.updateProvinceById(province, id);
        return "redirect:/ui/provinces";
    }


}
