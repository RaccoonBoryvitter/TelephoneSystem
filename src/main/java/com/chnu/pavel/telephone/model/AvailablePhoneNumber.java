package com.chnu.pavel.telephone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PhoneNumberFree
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 26.05.2021|18:45
 * @Version PhoneNumberFree: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "availablePhoneNumbers")
public class AvailablePhoneNumber {

    @Transient
    public static final String SEQUENCE_NAME = "availablePhoneNumbers";

    private Long id;
    private String number;
    @DBRef
    private TelephoneExchange telephoneExchange;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

}
