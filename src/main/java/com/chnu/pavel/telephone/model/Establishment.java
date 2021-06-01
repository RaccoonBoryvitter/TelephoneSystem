package com.chnu.pavel.telephone.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.Establishment
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 14.03.2021|23:24
 * @Version Establishment: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document(collection = "establishments")
public class Establishment {

    @Id
    private String              id;
    private String              name;
    @DBRef
    private TelephoneExchange   telephoneExchange;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    @Nullable
    private String description;

}
