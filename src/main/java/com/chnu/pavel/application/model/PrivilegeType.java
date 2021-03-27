package com.chnu.pavel.application.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PrivilegeType
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 15.03.2021|02:56
 * @Version PrivilegeType: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PrivilegeType {
    // TODO: enum

    @Id
    private String       id;
    private String       socialStatus;
    private BigDecimal   charge;

}
