package com.chnu.pavel.application.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ConversationType
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 15.03.2021|02:48
 * @Version ConversationType: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ConversationType {

    @Id
    private String       id;
    private String       type;
    private BigDecimal   extraCharge;

}
