package com.chnu.pavel.telephone.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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

    @Transient
    public static final String SEQUENCE_NAME = "phones";

    @Id
    private Long id;
    private String name;
    private PhoneType phoneType;
    private boolean isWorking;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;
}
