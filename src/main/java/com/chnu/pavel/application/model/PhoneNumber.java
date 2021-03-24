package com.chnu.pavel.application.model;

import lombok.*;
import org.springframework.data.annotation.Id;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PhoneNumber
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 10.03.2021|22:22
 * @Version PhoneNumber: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PhoneNumber {

    @Id
    private String              id;
    private String              number;
    private Phone               phone;
    private Address             address;
    private TelephoneExchange   telephoneExchange;

}
