package com.chnu.pavel.application.model;

import lombok.*;
import org.springframework.data.annotation.Id;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.City
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 15.03.2021|02:46
 * @Version City: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class City {

    @Id
    private String id;
    private String name;
    private String phoneCode;
    private Country country;

}
