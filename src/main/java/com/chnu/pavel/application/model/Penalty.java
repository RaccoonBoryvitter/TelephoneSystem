package com.chnu.pavel.application.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.Debt
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 15.03.2021|01:21
 * @Version Debt: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Penalty {

    @Id
    private String       id;
    private BigDecimal   cost;
    private boolean      isMessageSent;
    private short        daysPassed;

}
