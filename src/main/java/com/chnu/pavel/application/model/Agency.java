package com.chnu.pavel.application.model;

import lombok.*;
import org.springframework.data.annotation.Id;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.Agency
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 14.03.2021|23:23
 * @Version Agency: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Agency {

    @Id
    private String              id;
    private String              name;
    private Address             address;
    // TODO: owner
    private TelephoneExchange   telephoneExchange;

}
