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
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ProvinceUiConntroller
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 4/29/2021|10:13 AM
 * @Version ProvinceUiConntroller: 1.0
 */

@Controller
@RequestMapping("/provinces")
@RequiredArgsConstructor
public class ProvinceUiController {

    private final ProvinceService service;

    private String error = "noerror";
    private String successfull = "nosuccess";

    @RequestMapping("/")
    public String findAll(Model model) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm:ss");
        model.addAttribute("formatter", formatter);
        model.addAttribute("items", service.findAll());
        model.addAttribute("states", Arrays.asList(State.values()));
        model.addAttribute("errMsg", error);
        if(!error.equals("noerror")) error = "noerror";
        model.addAttribute("successMsg", successfull);
        if(!successfull.equals("nosuccess")) successfull = "nosuccess";
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
        successfull = "SUCCESS! Object with id " + id + " has been deleted!";
        return "redirect:/provinces/";
    }

    @PostMapping("/create/")
    public String createProvince(HttpServletRequest request) throws IOException {

        String name = request.getParameter("create-name").trim();
        String phoneCode = request.getParameter("create-phone-code").trim();
        State state = State.valueOf(request.getParameter("create-state"));
        String description = request.getParameter("create-description").trim();

        if(service.findByName(name).isPresent() || service.findByPhoneCode(phoneCode).isPresent()) {
            error = "ERROR! Object with such credentials exists!";
        } else if (name.isEmpty() || phoneCode.isEmpty())
            error = "ERROR! Empty values!";
        else {
            Province province = new Province();
            province.setName(name);
            province.setPhoneCode(phoneCode);
            province.setState(state);
            province.setDescription(description);
            service.create(province);
            successfull = "SUCCESS! Object with name " + name + " has been created!";
        }

        return "redirect:/provinces/";
    }

    @PostMapping("/update/{id}")
    public String update(HttpServletRequest request, @PathVariable("id") String id) {

        String name = request.getParameter("update-name").trim();
        String phoneCode = request.getParameter("update-phone-code").trim();
        State state = State.valueOf(request.getParameter("update-state"));
        String description = request.getParameter("update-description").trim();

        if((service.findByPhoneCode(phoneCode).isPresent()
                && !service.findByPhoneCode(phoneCode).get().getName().equals(name))
            || (service.findByName(name).isPresent()
                && !service.findByName(name).get().getPhoneCode().equals(phoneCode))) {
            error = "ERROR! Object with such credentials exists!";
        } else {
            Province province = new Province();
            province.setName(name);
            province.setPhoneCode(phoneCode);
            province.setState(state);
            province.setDescription(description);
            service.updateById(Long.valueOf(id), province);
            successfull = "SUCCESS! Object with id " + id + " has been updated!";
        }

        return "redirect:/provinces/";
    }

}
