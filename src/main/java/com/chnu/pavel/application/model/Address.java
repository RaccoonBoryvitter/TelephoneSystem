package com.chnu.pavel.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.Address
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 10.03.2021|11:29
 * @Version Address: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    private String     id;
    private District   district;
    private String     street;
    private String     building;
    private String     apartmentNo;
    private String     zipCode;

}
