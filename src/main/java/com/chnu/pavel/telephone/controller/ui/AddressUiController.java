package com.chnu.pavel.telephone.controller.ui;

import com.chnu.pavel.telephone.model.Address;
import com.chnu.pavel.telephone.model.City;
import com.chnu.pavel.telephone.model.District;
import com.chnu.pavel.telephone.service.address.interfaces.AddressService;
import com.chnu.pavel.telephone.service.district.interfaces.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AddressUiController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.06.2021|6:19
 * @Version AddressUiController: 1.0
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressUiController {

    private final AddressService service;
    private final DistrictService districtService;

    private String error = "noerror";
    private String successfull = "nosuccess";

    @RequestMapping("")
    public String findAll(Model model) {
        model.addAttribute("items", service.findAll());
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm:ss");
        model.addAttribute("formatter", formatter);
        model.addAttribute("districts", districtService.findAll());
        model.addAttribute("errMsg", error);
        if(!error.equals("noerror")) error = "noerror";
        model.addAttribute("successMsg", successfull);
        if(!successfull.equals("nosuccess")) successfull = "nosuccess";
        return "address/addresses";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Address findById(@PathVariable("id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @GetMapping("/delete/{id}")
    public String deleteById( @PathVariable("id") String id) {
        service.deleteById(Long.valueOf(id));
        successfull = "SUCCESS! Object with id " + id + " has been deleted!";
        return "redirect:/addresses";
    }

    @PostMapping("/create/")
    public String create(HttpServletRequest request) {
        String street = request.getParameter("create-street").trim();
        String building = request.getParameter("create-building").trim();
        String apartmentNo = request.getParameter("create-apartment").trim();
        String zipCode = request.getParameter("create-zipCode").trim();
        District district = districtService.findById(Long.valueOf(request.getParameter("create-district")));
        String description = request.getParameter("create-description").trim();

        if(service.findByStreet(street).isPresent() && service.findByStreet(street).get().getDistrict().equals(district)) {
            error = "ERROR! Object with such credentials exists!";
        } else if (street.isEmpty() || building.isEmpty() || zipCode.isEmpty())
            error = "ERROR! Empty values!";
        else {
            Address address = new Address();
            address.setDistrict(district);
            address.setBuilding(building);
            address.setApartmentNo(apartmentNo);
            address.setZipCode(zipCode);
            address.setDescription(description);
            service.create(address);
        }
        return "redirect:/addresses";
    }

    @PostMapping("/update/{id}")
    public String update(HttpServletRequest request, @PathVariable("id") String id) {

        String street = request.getParameter("update-street").trim();
        String building = request.getParameter("update-building").trim();
        String apartmentNo = request.getParameter("update-apartment").trim();
        String zipCode = request.getParameter("update-zipcode").trim();
        District district = districtService.findById(Long.valueOf(request.getParameter("update-district")));
        String description = request.getParameter("update-description").trim();

        if(service.findByStreet(street).isPresent()
                && service.findByStreet(street).get().getBuilding().equals(building)
                && service.findByStreet(street).get().getApartmentNo().equals(apartmentNo)) {
            error = "ERROR! Object with such credentials exists!";
        } else if (street.isEmpty() || building.isEmpty() || zipCode.isEmpty())
            error = "ERROR! Empty values!";
        else {
            Address address = new Address();
            address.setDistrict(district);
            address.setBuilding(building);
            address.setApartmentNo(apartmentNo);
            address.setZipCode(zipCode);
            address.setDescription(description);
            service.updateById(Long.valueOf(id), address);
        }
        return "redirect:/addresses";
    }

}
