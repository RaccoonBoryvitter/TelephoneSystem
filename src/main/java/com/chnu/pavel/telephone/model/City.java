package com.chnu.pavel.telephone.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

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
@Builder
@Document(collection = "cities")
public class City {

    @Transient
    public static final String SEQUENCE_NAME = "cities";

    @Id
    private Long id;
    private String name;
    private String phoneCode;
    @DBRef
    private Province province;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

}
