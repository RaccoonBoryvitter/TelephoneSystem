package com.chnu.pavel.application.model;

import lombok.*;
import org.springframework.data.annotation.Id;

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
@ToString
@Builder
public class Region {

    @Id
    private String id;
    private String name;
    private State  state;

}
