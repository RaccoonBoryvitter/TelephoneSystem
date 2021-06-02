package com.chnu.pavel.telephone.controller.ui;

import com.chnu.pavel.telephone.model.City;
import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.model.State;
import com.chnu.pavel.telephone.service.province.interfaces.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ProvinceUiConntroller
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 4/29/2021|10:13 AM
 * @Version ProvinceUiConntroller: 1.0
 */

@Controller
@RequestMapping("/ui/provinces")
@RequiredArgsConstructor
public class ProvinceUiController {

    private final ProvinceService service;

    @RequestMapping("")
    public String findAll(Model model) {
        model.addAttribute("items", service.findAll());
        model.addAttribute("states", Arrays.asList(State.values()));
        return "province/provinces";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Province findById(@PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @GetMapping("/delete/{id}")
    public String deleteById( @PathVariable("id") String id) {
        service.deleteById(Long.valueOf(id));
        return "redirect:/ui/provinces";
    }

    @PostMapping("/create/")
    public String createProvince(HttpServletRequest request) {
        Province province = new Province();
        province.setName(request.getParameter("create-name").trim());
        province.setPhoneCode(request.getParameter("create-phone-code").trim());
        province.setState(State.valueOf(request.getParameter("create-state")));
        province.setDescription(request.getParameter("create-description"));
        service.create(province);
        return "redirect:/ui/provinces";
    }

    @PostMapping("/update/{id}")
    public String update(HttpServletRequest request, @PathVariable("id") String id) {
        Province province = new Province();
        province.setName(request.getParameter("update-name").trim());
        province.setPhoneCode(request.getParameter("update-phone-code").trim());
        province.setState(State.valueOf(request.getParameter("update-state")));
        province.setDescription(request.getParameter("update-description"));
        service.updateById(Long.valueOf(id), province);
        return "redirect:/ui/provinces";
    }

}
