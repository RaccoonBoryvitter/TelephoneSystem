package com.chnu.pavel.telephone.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

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

    @Id
    private String       id;
    private BigDecimal   cost;
    private boolean      isWarningSent;
    private short        penaltyDaysAmount;

}
