package com.chnu.pavel.telephone.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

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
    @Field("subscriberId")
    private Subscriber subscriber;
    @DBRef
    @Field("subscriptionFeeId")
    private SubscriptionFee subscriptionFee;
    @DBRef
    @Field("penaltyId")
    private Penalty penalty;
    private double totalCost;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @DateTimeFormat(style="yyyy-MM-dd HH:mm:ss.SSS")
    @Field("createdAt")
    private Date created_at;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @DateTimeFormat(style="yyyy-MM-dd HH:mm:ss.SSS")
    @Field("modifiedAt")
    private Date modified_at;
    private String description;

}
