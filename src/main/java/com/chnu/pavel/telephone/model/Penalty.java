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
 * TelephoneSystem.Debt
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 15.03.2021|01:21
 * @Version Penalty: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document(collection = "penalties")
public class Penalty {

    @Transient
    public static final String SEQUENCE_NAME = "penalties";

    @Id
    private Long id;
    private double cost;
    private boolean isWarningSent;
    private short penaltyDaysAmount;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

}
