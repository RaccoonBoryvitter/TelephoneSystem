package com.chnu.pavel.application.model;

import lombok.*;
import org.springframework.data.annotation.Id;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.District
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 14.03.2021|22:27
 * @Version District: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class District {

    @Id
    private String   id;
    private String   name;
    private City     city;

}
