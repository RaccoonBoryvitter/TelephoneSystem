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

public enum ConversationType {

    CITY_LOCAL,
    AGENCY_LOCAL,
    ESTABLISHMENT_LOCAL,
    INTERCITY,
    // міжнародний

}
