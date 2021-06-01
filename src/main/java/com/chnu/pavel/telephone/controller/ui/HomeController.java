package com.chnu.pavel.telephone.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.HomeController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 02.06.2021|2:30
 * @Version HomeController: 1.0
 */

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String homepage() {
        return "index";
    }

}
