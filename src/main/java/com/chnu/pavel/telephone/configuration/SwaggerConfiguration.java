package com.chnu.pavel.telephone.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.SwaggerConfiguration
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 4/29/2021|5:39 AM
 * @Version SwaggerConfiguration: 1.0
 */

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(
                new Info()
                        .title("Telephone Exchange Database Management System")
                        .version("0.5.3")
                        .contact(
                                new Contact()
                                        .name("Pavel Shcherbatyi")
                                        .email("pavel.shcherbatyi@protonmail.com")
                                        .url("https://github.com/r3d-scarf")
                        )
        );
    }

}
