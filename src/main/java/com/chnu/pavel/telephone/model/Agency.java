package com.chnu.pavel.telephone.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    @Id
    private String              id;
    private String              name;
    private String              ownerFullName;
    private TelephoneExchange   telephoneExchange;

}
