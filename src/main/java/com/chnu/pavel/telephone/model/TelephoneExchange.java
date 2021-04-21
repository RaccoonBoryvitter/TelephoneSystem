package com.chnu.pavel.telephone.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.BusinessTelephoneExchange
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 10.03.2021|11:30
 * @Version BusinessTelephoneExchange: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "telephoneExchanges")
public class TelephoneExchange {

    @Id
    private String          id;
    private String          codeName;
    @DBRef
    private Address         address;
    private StationType     stationType;
    private short           availableCables;
    private short           availableChannels;
    private String          workingStatus;

}
