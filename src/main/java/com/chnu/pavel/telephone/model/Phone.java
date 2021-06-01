package com.chnu.pavel.telephone.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

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
@Document(collection = "phones")
public class Phone {

    @Id
    private String    id;
    private String    name;
    private PhoneType phoneType;
    private String    isWorking;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    @Nullable
    private String description;
}
