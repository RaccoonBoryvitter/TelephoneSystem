package com.chnu.pavel.application.model;

import lombok.*;
import org.springframework.data.annotation.Id;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CommonPhone
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 10.03.2021|11:30
 * @Version CommonPhone: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Phone {

    @Id
    private String    id;
    private PhoneType phoneType;
    private String    isWorking;
}
