package com.chnu.pavel.application.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.SwaggerConfiguration
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 24.03.2021|12:06
 * @Version SwaggerConfiguration: 1.0
 */

@Configuration
public class SwaggerConfiguration {

    public OpenAPI studentOpenApi() {
        return new OpenAPI().
                info(
                        new Info()
                        .title("Курсова")
                        .version("1.0.0")
                        .contact(
                                new Contact()
                                .email("my-email@mail.com")
                                .name("Name")
                                .url("my-site.ucoz.ua")
                        )
                );
    }

}
