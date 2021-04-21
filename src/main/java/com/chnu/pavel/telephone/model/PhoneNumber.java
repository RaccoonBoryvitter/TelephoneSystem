package com.chnu.pavel.telephone.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(collection = "phoneNumbers")
public class PhoneNumber {

    @Id
    private String              id;
    private String              number;
    @DBRef
    private Phone               phone;
    @DBRef
    private Address             address;
    @DBRef
    private TelephoneExchange   telephoneExchange;

}
