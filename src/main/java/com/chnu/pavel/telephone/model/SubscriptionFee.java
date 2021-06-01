package com.chnu.pavel.telephone.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Document(collection = "subscriptionFees")
public class SubscriptionFee {

    @Transient
    public static final String SEQUENCE_NAME = "subscriptionFees";

    @Id
    private Long id;
    private double localCallsCost;
    private double intercityCallsCost;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

}
