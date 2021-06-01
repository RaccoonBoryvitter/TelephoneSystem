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
@Document(collection = "districts")
public class District {

    @Transient
    public static final String SEQUENCE_NAME = "districts";

    @Id
    private Long   id;
    private String   name;
    @DBRef
    private City     city;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

}
