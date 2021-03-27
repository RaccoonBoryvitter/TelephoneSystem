package com.chnu.pavel.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

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
public class SubscriptionFeeBill {

    @Id
    private String id;
    private Subscriber subscriber;
    private SubscriptionFee subscriptionFee;

}
