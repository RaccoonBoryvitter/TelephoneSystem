package com.chnu.pavel.telephone.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.Region
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 25.03.2021|09:07
 * @Version Region: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "provinces")
public class Province {

    @Id
    private String id;
    private String name;
    private String phoneCode;
    private State  state;

}