package com.chnu.pavel.application.model;

import lombok.*;
import org.springframework.data.annotation.Id;

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
@ToString
public class TelephoneExchange {

    @Id
    private String     id;
    private String     codeName;
    private District   district;
    private String     stationType;
    private String     workingStatus;

}
