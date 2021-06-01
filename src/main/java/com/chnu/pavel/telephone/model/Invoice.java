package com.chnu.pavel.telephone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    @Transient
    public static final String SEQUENCE_NAME = "invoices";

    @Id
    private Long id;
    @DBRef
    private Subscriber subscriber;
    @DBRef
    private SubscriptionFee subscriptionFee;
    @DBRef
    private Penalty penalty;
    private double totalCost;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

}
