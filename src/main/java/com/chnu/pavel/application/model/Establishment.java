package com.chnu.pavel.application.model;

import lombok.*;
import org.springframework.data.annotation.Id;

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
public class Establishment {

    @Id
    private String              id;
    private String              name;
    private TelephoneExchange   telephoneExchange;

}
