package com.chnu.pavel.telephone.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    @Id
    private String   id;
    private String   name;
    private City     city;

}
