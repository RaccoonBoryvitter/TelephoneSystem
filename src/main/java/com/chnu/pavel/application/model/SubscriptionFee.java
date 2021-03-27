package com.chnu.pavel.application.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.SubscriptionFee
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 10.03.2021|11:33
 * @Version SubscriptionFee: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionFee {

    @Id
    private String       id;
    private Subscriber   subscriber;
    private Penalty      penalty;
    private BigDecimal   localCost;
    private BigDecimal   intercityCallsCost;
    private BigDecimal   totalCost;

}
