package com.chnu.pavel.application.model;

import lombok.*;
import org.springframework.data.annotation.Id;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.Country
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 22.03.2021|02:11
 * @Version Country: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class State {

    @Id
    private String id;
    private String name;
    private String phoneCode;

}
