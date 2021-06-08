package com.chnu.pavel.telephone.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.SwaggerApiController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 07.06.2021|23:17
 * @Version SwaggerApiController: 1.0
 */

@Controller
@RequestMapping("/docs/")
public class SwaggerApiController {

    @RequestMapping("/swagger")
    public String swaggerPage() {
        return "/documentation/swagger/swagger-api";
    }

}
