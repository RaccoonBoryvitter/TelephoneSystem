package com.chnu.pavel.telephone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.SubscribtionFeeBill
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 25.03.2021|09:45
 * @Version SubscribtionFeeBill: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "invoices")
public class Invoice {

    @Id
    private String id;
    private Subscriber subscriber;
    private SubscriptionFee subscriptionFee;
    private Penalty penalty;
    private BigDecimal totalCost;

}
