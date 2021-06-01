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
 * TelephoneSystem.Agency
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 14.03.2021|23:23
 * @Version Agency: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "agencies")
public class Agency {

    @Transient
    public static final String SEQUENCE_NAME = "agencies";

    @Id
    private Long id;
    private String name;
    @DBRef
    private Subscriber owner;
    @DBRef
    private TelephoneExchange telephoneExchange;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

}
