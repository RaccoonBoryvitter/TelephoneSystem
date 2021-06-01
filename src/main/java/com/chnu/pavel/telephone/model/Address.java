package com.chnu.pavel.telephone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

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
@Document(collection = "addresses")
public class Address {

    @Id
    private String     id;
    @DBRef
    private District   district;
    private String     street;
    private String     building;
    private String     apartmentNo;
    private String     zipCode;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    @Nullable
    private String description;

}
